package mrandroid.app.model;

public class QuestionModel {

    private String questionText;
    private int questionSound;
    private int correctAnswer;

    public QuestionModel(String questionText, int questionSound, int correctAnswer) {
        this.questionText = questionText;
        this.questionSound = questionSound;
        this.correctAnswer = correctAnswer;
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
