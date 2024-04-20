package mrandroid.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import mrandroid.app.databinding.ActivityStartBinding;
import mrandroid.app.util.QuestionsInfo;

public class StartActivity extends AppCompatActivity {

    private ActivityStartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvCharAr.setOnClickListener(view -> {
            Intent intent = new Intent(getBaseContext(), HomeActivity.class);
            intent.putExtra("type", QuestionsInfo.charAr);
            startActivity(intent);
        });

        binding.tvCharEn.setOnClickListener(view -> {
            Intent intent = new Intent(getBaseContext(), HomeActivity.class);
            intent.putExtra("type", QuestionsInfo.charEn);
            startActivity(intent);
        });

        binding.tvColors.setOnClickListener(view -> {
            Intent intent = new Intent(getBaseContext(), HomeActivity.class);
            intent.putExtra("type", QuestionsInfo.color);
            startActivity(intent);
        });

        binding.tvAnimals.setOnClickListener(view -> {
            Intent intent = new Intent(getBaseContext(), HomeActivity.class);
            intent.putExtra("type", QuestionsInfo.animal);
            startActivity(intent);
        });

        binding.tvNumbersAr.setOnClickListener(view -> {
            Intent intent = new Intent(getBaseContext(), HomeActivity.class);
            intent.putExtra("type", QuestionsInfo.numberAr);
            startActivity(intent);
        });

        binding.tvNumbersEn.setOnClickListener(view -> {
            Intent intent = new Intent(getBaseContext(), HomeActivity.class);
            intent.putExtra("type", QuestionsInfo.numberEn);
            startActivity(intent);
        });

        binding.tvShapes.setOnClickListener(view -> {
            Intent intent = new Intent(getBaseContext(), HomeActivity.class);
            intent.putExtra("type", QuestionsInfo.shapes);
            startActivity(intent);
        });

    }
}