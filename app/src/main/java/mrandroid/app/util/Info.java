package mrandroid.app.util;

import java.util.ArrayList;
import java.util.List;

import mrandroid.app.R;
import mrandroid.app.model.AnswerModel;
import mrandroid.app.model.QuestionModel;

public class Info {

    public static List<QuestionModel> getAllQuestions() {
        List<QuestionModel> questionList = new ArrayList<>();

        List<AnswerModel> answerList1 = new ArrayList<>();
        answerList1.add(new AnswerModel(R.drawable.q1a1, false));
        answerList1.add(new AnswerModel(R.drawable.q1a2, true));
        answerList1.add(new AnswerModel(R.drawable.q1a3, false));
        answerList1.add(new AnswerModel(R.drawable.q1a4, false));
        QuestionModel question1 = new QuestionModel("أين رقم 9؟", R.raw.s1, answerList1);

        List<AnswerModel> answerList2 = new ArrayList<>();
        answerList2.add(new AnswerModel(R.drawable.q2a1, true));
        answerList2.add(new AnswerModel(R.drawable.q2a2, false));
        answerList2.add(new AnswerModel(R.drawable.q2a3, false));
        answerList2.add(new AnswerModel(R.drawable.q2a4, false));
        QuestionModel question2 = new QuestionModel("أين الأرنب؟", R.raw.s2, answerList2);

        List<AnswerModel> answerList3 = new ArrayList<>();
        answerList3.add(new AnswerModel(R.drawable.q3a1, true));
        answerList3.add(new AnswerModel(R.drawable.q3a2, false));
        answerList3.add(new AnswerModel(R.drawable.q3a3, false));
        answerList3.add(new AnswerModel(R.drawable.q3a4, false));
        QuestionModel question3 = new QuestionModel("أين المثلث؟", R.raw.s3, answerList3);

        List<AnswerModel> answerList4 = new ArrayList<>();
        answerList4.add(new AnswerModel(R.drawable.q4a1, false));
        answerList4.add(new AnswerModel(R.drawable.q4a2, false));
        answerList4.add(new AnswerModel(R.drawable.q4a3, false));
        answerList4.add(new AnswerModel(R.drawable.q4a4, true));
        QuestionModel question4 = new QuestionModel("أين الأسد؟", R.raw.s4, answerList4);

        List<AnswerModel> answerList5 = new ArrayList<>();
        answerList5.add(new AnswerModel(R.drawable.q5a1, false));
        answerList5.add(new AnswerModel(R.drawable.q5a2, true));
        answerList5.add(new AnswerModel(R.drawable.q5a3, false));
        answerList5.add(new AnswerModel(R.drawable.q5a4, false));
        QuestionModel question5 = new QuestionModel("أين حرف ش؟", R.raw.s5, answerList5);

        List<AnswerModel> answerList6 = new ArrayList<>();
        answerList6.add(new AnswerModel(R.drawable.q6a1, false));
        answerList6.add(new AnswerModel(R.drawable.q6a2, false));
        answerList6.add(new AnswerModel(R.drawable.q6a3, true));
        answerList6.add(new AnswerModel(R.drawable.q6a4, false));
        QuestionModel question6 = new QuestionModel("أين الدائرة؟", R.raw.s6, answerList6);

        List<AnswerModel> answerList7 = new ArrayList<>();
        answerList7.add(new AnswerModel(R.drawable.q7a1, false));
        answerList7.add(new AnswerModel(R.drawable.q7a2, true));
        answerList7.add(new AnswerModel(R.drawable.q7a3, false));
        answerList7.add(new AnswerModel(R.drawable.q7a4, false));
        QuestionModel question7 = new QuestionModel("أين الثعلب؟", R.raw.s7, answerList7);

        List<AnswerModel> answerList8 = new ArrayList<>();
        answerList8.add(new AnswerModel(R.drawable.q8a1, false));
        answerList8.add(new AnswerModel(R.drawable.q8a2, false));
        answerList8.add(new AnswerModel(R.drawable.q8a3, true));
        answerList8.add(new AnswerModel(R.drawable.q8a4, false));
        QuestionModel question8 = new QuestionModel("أين رقم 7؟", R.raw.s8, answerList8);

        List<AnswerModel> answerList9 = new ArrayList<>();
        answerList9.add(new AnswerModel(R.drawable.q9a1, false));
        answerList9.add(new AnswerModel(R.drawable.q9a2, false));
        answerList9.add(new AnswerModel(R.drawable.q9a3, false));
        answerList9.add(new AnswerModel(R.drawable.q9a4, true));
        QuestionModel question9 = new QuestionModel("أين حرف ب؟", R.raw.s9, answerList9);

        List<AnswerModel> answerList10 = new ArrayList<>();
        answerList10.add(new AnswerModel(R.drawable.q10a1, false));
        answerList10.add(new AnswerModel(R.drawable.q10a2, false));
        answerList10.add(new AnswerModel(R.drawable.q10a3, true));
        answerList10.add(new AnswerModel(R.drawable.q10a4, false));
        QuestionModel question10 = new QuestionModel("أين الزرافة؟", R.raw.s10, answerList10);

        questionList.add(question1);
        questionList.add(question2);
        questionList.add(question3);
        questionList.add(question4);
        questionList.add(question5);
        questionList.add(question6);
        questionList.add(question7);
        questionList.add(question8);
        questionList.add(question9);
        questionList.add(question10);

        return questionList;
    }
}
