package mrandroid.app.learingkids.learingkids;

import android.content.Context;
import android.content.SharedPreferences;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class DayProgressPrefs {

    public static final int MAX_SCORE = 14;
    private static final String PREFS_NAME = "day_progress_prefs";
    private static final String KEY_COMPLETED_DAYS = "completed_days";
    private static final SimpleDateFormat DATE_FORMAT =
            new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    private final SharedPreferences prefs;

    public DayProgressPrefs(Context context) {
        prefs = context.getApplicationContext()
                .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public Set<String> getCompletedDays() {
        Set<String> saved = prefs.getStringSet(KEY_COMPLETED_DAYS, null);
        if (saved == null) {
            return new HashSet<>();
        }
        return new HashSet<>(saved);
    }

    public boolean isDayCompleted(String dateKey) {
        return getCompletedDays().contains(dateKey);
    }

    public boolean isDayCompleted(Calendar calendar) {
        return isDayCompleted(toDateKey(calendar));
    }

    /**
     * Marks today as completed. Returns true if this is a new day (score increased).
     */
    public boolean markTodayCompleted() {
        return markDayCompleted(Calendar.getInstance());
    }

    public boolean markDayCompleted(Calendar calendar) {
        String dateKey = toDateKey(calendar);
        Set<String> days = getCompletedDays();
        if (days.contains(dateKey) || days.size() >= MAX_SCORE) {
            return false;
        }
        days.add(dateKey);
        prefs.edit().putStringSet(KEY_COMPLETED_DAYS, days).apply();
        return true;
    }

    public int getScore() {
        return Math.min(getCompletedDays().size(), MAX_SCORE);
    }

    public String getScoreText() {
        return getScore() + "/" + MAX_SCORE;
    }

    public static String toDateKey(Calendar calendar) {
        return DATE_FORMAT.format(calendar.getTime());
    }
}
