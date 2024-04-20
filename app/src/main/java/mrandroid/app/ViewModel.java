package mrandroid.app;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;
import mrandroid.app.model.QuestionModel;

public class ViewModel extends AndroidViewModel {

    private final Repository repository;

    public ViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public void insertQuestion(QuestionModel question) {
        repository.insertQuestion(question);
    }

    public LiveData<List<QuestionModel>> getAllQuestions() {
        return repository.getAllQuestions();
    }

    public void deleteAllQuestions() {
        repository.deleteAllQuestions();
    }

}
