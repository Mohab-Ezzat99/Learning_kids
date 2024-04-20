package mrandroid.app.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class QuestionModel {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String questionText;
    private int questionSound;
    private int correctAnswer;

    public QuestionModel(String questionText, int questionSound, int correctAnswer) {
        this.questionText = questionText;
        this.questionSound = questionSound;
        this.correctAnswer = correctAnswer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public int getQuestionSound() {
        return questionSound;
    }

    public void setQuestionSound(int questionSound) {
        this.questionSound = questionSound;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
