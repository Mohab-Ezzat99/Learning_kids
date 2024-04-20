package mrandroid.app.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import mrandroid.app.R;
import mrandroid.app.adapter.AnswerAdapter;
import mrandroid.app.databinding.ActivityHomeBinding;
import mrandroid.app.model.QuestionModel;
import mrandroid.app.util.AudioPlayer;
import mrandroid.app.util.QuestionsInfo;

public class HomeActivity extends AppCompatActivity implements AnswerAdapter.OnItemClickListener {

    private ActivityHomeBinding binding;
    private AudioPlayer audioPlayer;
    private List<QuestionModel> questionList;
    private AnswerAdapter answerAdapter;
    private boolean hasSelectAnswer = false;
    private int questionPosition = 0;
    private int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        audioPlayer = new AudioPlayer();
        questionList = QuestionsInfo.getAllQuestions();
        answerAdapter = new AnswerAdapter();
        answerAdapter.setListener(this);
        binding.rvAnswers.setAdapter(answerAdapter);

        binding.ivSound.setOnClickListener(v -> {
            QuestionModel questionModel = questionList.get(questionPosition);
            audioPlayer.play(this, questionModel.getQuestion(), () -> {
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
        boolean isAnswerCorrect = answerAdapter.getSelectedAnswer().isCorrect();
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
        audioPlayer.play(this, questionModel.getQuestion(), () -> {
            // nothing
        });

        binding.tvQuestionCount.setText("Q: " + (questionPosition + 1) + "/" + questionList.size());
        binding.tvQuestionText.setText(questionModel.getText());
        answerAdapter.setList(questionModel.getAnswers());
    }

    @Override
    public void onItemClick(AnswerModel item) {
        hasSelectAnswer = true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        audioPlayer.stop();
    }
}