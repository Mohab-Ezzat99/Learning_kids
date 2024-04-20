package mrandroid.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import mrandroid.app.R;
import mrandroid.app.adapter.AnswerAdapter;
import mrandroid.app.databinding.ActivityHomeBinding;
import mrandroid.app.model.QuestionModel;
import mrandroid.app.util.AnswersInfo;
import mrandroid.app.util.AudioPlayer;
import mrandroid.app.util.QuestionsInfo;

public class HomeActivity extends AppCompatActivity implements AnswerAdapter.OnItemClickListener {

    private ActivityHomeBinding binding;
    private AudioPlayer audioPlayer;
    private List<QuestionModel> questionList;
    private List<Integer> answersList;
    private AnswerAdapter answerAdapter;
    private boolean hasSelectAnswer = false;
    private int questionPosition = 0;
    private int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int type = getIntent().getIntExtra("type", 0);
        switch (type) {
            case 1:
                questionList = QuestionsInfo.getCharArQuestions();
                break;
            case 2:
                questionList = QuestionsInfo.getCharEnQuestions();
                break;
            case 3:
                questionList = QuestionsInfo.getColorQuestions();
                break;
            case 4:
                questionList = QuestionsInfo.getAnimalQuestions();
                break;
            case 5:
                questionList = QuestionsInfo.getNumberArQuestions();
                break;
            case 6:
                questionList = QuestionsInfo.getNumberEnQuestions();
                break;
            case 7:
                questionList = QuestionsInfo.getShapeQuestions();
                break;
        }

        switch (type) {
            case 1:
                answersList = AnswersInfo.getCharArAnswers();
                break;
            case 2:
                answersList = AnswersInfo.getCharEnAnswers();
                break;
            case 3:
                answersList = AnswersInfo.getColorAnswers();
                break;
            case 4:
                answersList = AnswersInfo.getAnimalAnswers();
                break;
            case 5:
                answersList = AnswersInfo.getNumberArAnswers();
                break;
            case 6:
                answersList = AnswersInfo.getNumberEnAnswers();
                break;
            case 7:
                answersList = AnswersInfo.getShapeAnswers();
                break;
        }

        audioPlayer = new AudioPlayer();
        answerAdapter = new AnswerAdapter();
        answerAdapter.setListener(this);
        binding.rvAnswers.setAdapter(answerAdapter);

        binding.ivSound.setOnClickListener(v -> {
            QuestionModel questionModel = questionList.get(questionPosition);
            audioPlayer.play(this, questionModel.getQuestionSound(), () -> {
                // nothing
            });
        });

        binding.fabSubmit.setOnClickListener(v -> {
            if (!hasSelectAnswer) {
                Toast.makeText(this, "Please select answer!", Toast.LENGTH_SHORT).show();
                return;
            }

            updateAnswerResult();
        });

        setCurrentQuestion();
    }

    private void updateAnswerResult() {
        binding.fabSubmit.setClickable(false);
        int resultSound = R.raw.wrong; // by default
        QuestionModel questionModel = questionList.get(questionPosition);
        boolean isAnswerCorrect = answerAdapter.getSelectedAnswer() == questionModel.getCorrectAnswer();
        if (isAnswerCorrect) {
            correctAnswers++;
            resultSound = R.raw.clap;
        }

        audioPlayer.play(this, resultSound, () -> {
            if (questionPosition == questionList.size() - 1) {
                Intent intent = new Intent(getBaseContext(), ExamResultActivity.class);
                intent.putExtra("total", questionList.size());
                intent.putExtra("score", correctAnswers);
                startActivity(intent);
                finish();
            } else {
                questionPosition++;
                setCurrentQuestion();
            }
        });
    }

    private void setCurrentQuestion() {
        binding.fabSubmit.setClickable(true);
        hasSelectAnswer = false;
        QuestionModel questionModel = questionList.get(questionPosition);
        audioPlayer.play(this, questionModel.getQuestionSound(), () -> {
            // nothing
        });

        binding.tvQuestionCount.setText("Q: " + (questionPosition + 1) + "/" + questionList.size());
        binding.tvQuestionText.setText(questionModel.getQuestionText());
        answerAdapter.setList(answersList);
    }

    @Override
    public void onItemClick(Integer item) {
        hasSelectAnswer = true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        audioPlayer.stop();
    }
}