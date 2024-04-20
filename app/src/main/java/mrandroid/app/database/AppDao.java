package mrandroid.app.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;
import io.reactivex.rxjava3.core.Completable;
import mrandroid.app.model.QuestionModel;

@Dao
public interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertQuestion(QuestionModel device);

    @Query("SELECT * FROM QuestionModel")
    LiveData<List<QuestionModel>> getAllQuestions();

    @Query("DELETE FROM QuestionModel")
    Completable deleteAllQuestions();

}
