package mrandroid.app.learingkids.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Set;

import mrandroid.app.learingkids.R;
import mrandroid.app.learingkids.databinding.ActivityStartBinding;
import mrandroid.app.learingkids.learingkids.DayProgressPrefs;
import mrandroid.app.learingkids.learingkids.QuestionsInfo;

public class StartActivity extends AppCompatActivity {

    private ActivityStartBinding binding;
    private DayProgressPrefs dayProgressPrefs;
    private Calendar displayedMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dayProgressPrefs = new DayProgressPrefs(this);
        displayedMonth = Calendar.getInstance();

        binding.btnScore.setOnClickListener(view -> showDayProgressDialog());

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

    @Override
    protected void onResume() {
        super.onResume();
        updateScoreButton();
    }

    private void updateScoreButton() {
        binding.btnScore.setText(dayProgressPrefs.getScoreText());
    }

    private void showDayProgressDialog() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_day_progress);
        dialog.setCancelable(true);

        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }

        TextView tvMonthYear = dialog.findViewById(R.id.tvMonthYear);
        TextView btnPrevMonth = dialog.findViewById(R.id.btnPrevMonth);
        TextView btnNextMonth = dialog.findViewById(R.id.btnNextMonth);
        TextView btnCloseCalendar = dialog.findViewById(R.id.btnCloseCalendar);
        GridLayout gridDays = dialog.findViewById(R.id.gridDays);

        displayedMonth = Calendar.getInstance();
        bindCalendarMonth(tvMonthYear, gridDays);

        btnPrevMonth.setOnClickListener(v -> {
            displayedMonth.add(Calendar.MONTH, -1);
            bindCalendarMonth(tvMonthYear, gridDays);
        });

        btnNextMonth.setOnClickListener(v -> {
            displayedMonth.add(Calendar.MONTH, 1);
            bindCalendarMonth(tvMonthYear, gridDays);
        });

        btnCloseCalendar.setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }

    private void bindCalendarMonth(TextView tvMonthYear, GridLayout gridDays) {
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM yyyy", new Locale("ar"));
        tvMonthYear.setText(monthFormat.format(displayedMonth.getTime()));

        gridDays.removeAllViews();

        Calendar month = (Calendar) displayedMonth.clone();
        month.set(Calendar.DAY_OF_MONTH, 1);

        int firstDayOfWeek = month.get(Calendar.DAY_OF_WEEK); // Sunday = 1
        int daysInMonth = month.getActualMaximum(Calendar.DAY_OF_MONTH);
        Set<String> completedDays = dayProgressPrefs.getCompletedDays();

        int cellSize = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 36, getResources().getDisplayMetrics());
        int emptyCells = firstDayOfWeek - Calendar.SUNDAY;

        for (int i = 0; i < emptyCells; i++) {
            gridDays.addView(createDayCell("", false, cellSize));
        }

        for (int day = 1; day <= daysInMonth; day++) {
            month.set(Calendar.DAY_OF_MONTH, day);
            String dateKey = DayProgressPrefs.toDateKey(month);
            boolean isDone = completedDays.contains(dateKey);
            gridDays.addView(createDayCell(String.valueOf(day), isDone, cellSize));
        }
    }

    private TextView createDayCell(String text, boolean isDone, int cellSize) {
        TextView dayView = new TextView(this);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.width = 0;
        params.height = cellSize;
        params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);
        params.setMargins(4, 4, 4, 4);
        dayView.setLayoutParams(params);
        dayView.setGravity(Gravity.CENTER);
        dayView.setText(text);
        dayView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);

        if (text.isEmpty()) {
            dayView.setBackgroundResource(android.R.color.transparent);
            dayView.setTextColor(ContextCompat.getColor(this, R.color.gray));
        } else if (isDone) {
            dayView.setBackgroundResource(R.drawable.shape_day_done);
            dayView.setTextColor(ContextCompat.getColor(this, R.color.white));
            dayView.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            dayView.setBackgroundResource(R.drawable.shape_day_default);
            dayView.setTextColor(ContextCompat.getColor(this, R.color.black));
        }
        return dayView;
    }
}
