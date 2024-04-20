package mrandroid.app.database;

import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import mrandroid.app.model.QuestionModel;

public class Converters {

    @TypeConverter
    public String convertToQuestionsString(List<QuestionModel> messageModels){
        return new Gson().toJson(messageModels);
    }

    @TypeConverter
    public List<QuestionModel> convertToQuestionsList(String stringList){
        Type listType = new TypeToken<List<QuestionModel>>(){}.getType();
        return new Gson().fromJson(stringList,listType);
    }
}
