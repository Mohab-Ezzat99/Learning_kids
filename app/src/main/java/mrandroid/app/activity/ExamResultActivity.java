package mrandroid.app.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import mrandroid.app.activity.HomeActivity;
import mrandroid.app.databinding.ActivityExamResultBinding;

public class ExamResultActivity extends AppCompatActivity {

    private ActivityExamResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExamResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int total = getIntent().getIntExtra("total", 0);
        int score = getIntent().getIntExtra("score", 0);
        binding.tvResult.setText("النتيجة: " + score + "/" + total);

        binding.btnReTakeExam.setOnClickListener(v -> {
            startActivity(new Intent(getBaseContext(), StartActivity.class));
            finish();
        });
    }
}