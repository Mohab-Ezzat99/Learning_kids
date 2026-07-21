package mrandroid.app.learingkids.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import mrandroid.app.learingkids.databinding.ActivityExamResultBinding;
import mrandroid.app.learingkids.learingkids.DayProgressPrefs;

public class ExamResultActivity extends AppCompatActivity {

    private ActivityExamResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExamResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Mark today's date as completed and increase the 0-14 progress score.
        new DayProgressPrefs(this).markTodayCompleted();

        int total = getIntent().getIntExtra("total", 0);
        int score = getIntent().getIntExtra("score", 0);
        binding.tvResult.setText("النتيجة: " + score + "/" + total);

        binding.btnReTakeExam.setOnClickListener(v -> {
            finish();
        });
    }
}