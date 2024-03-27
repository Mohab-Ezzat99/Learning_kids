package mrandroid.app.activity.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import mrandroid.app.R;
import mrandroid.app.adapter.AnswerAdapter;
import mrandroid.app.databinding.ActivityHomeBinding;
import mrandroid.app.model.AnswerModel;
import mrandroid.app.model.QuestionModel;
import mrandroid.app.util.AudioPlayer;
import mrandroid.app.util.Info;
import mrandroid.app.util.LoadingDialog;

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
        questionList = Info.getAllQuestions();
        answerAdapter = new AnswerAdapter();
        answerAdapter.setListener(this);
        binding.rvAnswers.setAdapter(answerAdapter);

        binding.ivSound.setOnClickListener(v -> {
            QuestionModel questionModel = questionList.get(questionPosition);
            audioPlayer.play(this, questionModel.getQuestion());
        });

        binding.fabSubmit.setOnClickListener(v -> {
            if (!hasSelectAnswer) {
                Toast.makeText(this, "Please select answer!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (questionPosition == questionList.size() - 1) {
                updateAnswerResult();

                Intent intent = new Intent(getBaseContext(), ExamResultActivity.class);
                intent.putExtra("total", questionList.size());
                intent.putExtra("score", correctAnswers);
                startActivity(intent);
                finish();
            } else {
                updateAnswerResult();

                questionPosition++;
                setCurrentQuestion();
            }
        });

        setCurrentQuestion();
    }

    private void updateAnswerResult() {
        boolean isAnswerCorrect = answerAdapter.getSelectedAnswer().isCorrect();
        if (isAnswerCorrect) correctAnswers++;
    }

    private void setCurrentQuestion() {
        hasSelectAnswer = false;
        QuestionModel questionModel = questionList.get(questionPosition);
        audioPlayer.play(this, questionModel.getQuestion());

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