package mrandroid.app.model;

import java.util.List;

public class QuestionModel {

    private String text;
    private int question;
    private List<AnswerModel> answers;

    public QuestionModel(String text, int question, List<AnswerModel> answers) {
        this.text = text;
        this.question = question;
        this.answers = answers;
    }

    public String getText() {return text;}

    public void setText(String text) {this.text = text;}

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public List<AnswerModel> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerModel> answers) {
        this.answers = answers;
    }
}
