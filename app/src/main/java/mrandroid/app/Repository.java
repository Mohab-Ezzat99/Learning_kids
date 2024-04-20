package mrandroid.app;

import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
import mrandroid.app.database.AppDB;
import mrandroid.app.database.AppDao;
import mrandroid.app.model.QuestionModel;

public class Repository {
    private final AppDao appDao;

    public Repository(Application application) {
        this.appDao = AppDB.getInstance(application).appDao();
    }

    public void insertQuestion(QuestionModel question) {
        appDao.insertQuestion(question)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    public LiveData<List<QuestionModel>> getAllQuestions() {
        return appDao.getAllQuestions();
    }

    public void deleteAllQuestions() {
        appDao.deleteAllQuestions()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

}
