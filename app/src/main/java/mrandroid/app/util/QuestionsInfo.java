package mrandroid.app.util;

import java.util.ArrayList;
import java.util.List;

import mrandroid.app.R;
import mrandroid.app.model.QuestionModel;

public class QuestionsInfo {

    public static List<QuestionModel> getCharArQuestions() {
        ArrayList<QuestionModel> questions_char_ar = new ArrayList<>();
        questions_char_ar.add(new QuestionModel("أين حرف أ ؟", R.raw.sca_a, R.drawable.pic_ca_18));
        questions_char_ar.add(new QuestionModel("أين حرف ب ؟", R.raw.sca_b, R.drawable.pic_ca_2));
        questions_char_ar.add(new QuestionModel("أين حرف د ؟", R.raw.sca_d, R.drawable.pic_ca_8));
        questions_char_ar.add(new QuestionModel("أين حرف ك ؟", R.raw.sca_k, R.drawable.pic_ca_22));
        questions_char_ar.add(new QuestionModel("أين حرف ن ؟", R.raw.sca_n, R.drawable.pic_ca_25));
        questions_char_ar.add(new QuestionModel("أين حرف ر ؟", R.raw.sca_r, R.drawable.pic_ca_10));
        questions_char_ar.add(new QuestionModel("أين حرف س ؟", R.raw.sca_s, R.drawable.pic_ca_12));
        questions_char_ar.add(new QuestionModel("أين حرف ت ؟", R.raw.sca_t, R.drawable.pic_ca_3));
        questions_char_ar.add(new QuestionModel("أين حرف و ؟", R.raw.sca_w, R.drawable.pic_ca_27));
        questions_char_ar.add(new QuestionModel("أين حرف ي ؟", R.raw.sca_y, R.drawable.pic_ca_28));
        return questions_char_ar;
    }

    public static List<QuestionModel> getCharEnQuestions() {
        ArrayList<QuestionModel> questions_char_en = new ArrayList<>();
        questions_char_en.add(new QuestionModel("أين حرف a ؟", R.raw.sce_a, R.drawable.pic_char_a));
        questions_char_en.add(new QuestionModel("أين حرف b ؟", R.raw.sce_b, R.drawable.pic_char_b));
        questions_char_en.add(new QuestionModel("أين حرف d ؟", R.raw.sce_d, R.drawable.pic_char_d));
        questions_char_en.add(new QuestionModel("أين حرف k ؟", R.raw.sce_k, R.drawable.pic_char_k));
        questions_char_en.add(new QuestionModel("أين حرف n ؟", R.raw.sce_n, R.drawable.pic_char_n));
        questions_char_en.add(new QuestionModel("أين حرف r ؟", R.raw.sce_r, R.drawable.pic_char_r));
        questions_char_en.add(new QuestionModel("أين حرف s ؟", R.raw.sce_s, R.drawable.pic_char_s));
        questions_char_en.add(new QuestionModel("أين حرف t ؟", R.raw.sce_t, R.drawable.pic_char_t));
        questions_char_en.add(new QuestionModel("أين حرف w ؟", R.raw.sce_w, R.drawable.pic_char_w));
        questions_char_en.add(new QuestionModel("أين حرف y ؟", R.raw.sce_y, R.drawable.pic_char_y));
        return questions_char_en;
    }

    public static List<QuestionModel> getColorQuestions() {
        ArrayList<QuestionModel> questions_color = new ArrayList<>();
        questions_color.add(new QuestionModel("أين اللون الأزرق ؟", R.raw.s_blue, R.drawable.pic_color_blue));
        questions_color.add(new QuestionModel("أين اللون الأخضر ؟", R.raw.s_green, R.drawable.pic_color_green));
        questions_color.add(new QuestionModel("أين اللون البنفسجي ؟", R.raw.s_move, R.drawable.pic_color_move));
        questions_color.add(new QuestionModel("أين اللون البرتقالي ؟", R.raw.s_orange, R.drawable.pic_color_orange));
        questions_color.add(new QuestionModel("أين اللون الأحمر ؟", R.raw.s_red, R.drawable.pic_color_red));
        questions_color.add(new QuestionModel("أين اللون السماوي ؟", R.raw.s_smay, R.drawable.pic_color_syan));
        questions_color.add(new QuestionModel("أين اللون الأصفر ؟", R.raw.s_yellow, R.drawable.pic_color_yellow));
        return questions_color;
    }

    public static List<QuestionModel> getAnimalQuestions() {
        ArrayList<QuestionModel> questions_animal = new ArrayList<>();
        questions_animal.add(new QuestionModel("أين الفيل ؟", R.raw.s_elephant, R.drawable.pic_forest_elephant));
        questions_animal.add(new QuestionModel("أين الأسد ؟", R.raw.s_lion, R.drawable.pic_forest_lion));
        questions_animal.add(new QuestionModel("أين القرد ؟", R.raw.s_monkey, R.drawable.pic_forest_monkey));
        questions_animal.add(new QuestionModel("أين الثعبان ؟", R.raw.s_snake, R.drawable.pic_forest_snake));
        questions_animal.add(new QuestionModel("أين النمر ؟", R.raw.s_tiger, R.drawable.pic_forest_tiger));
        questions_animal.add(new QuestionModel("أين الزرافة ؟", R.raw.s_zarafa, R.drawable.pic_forest_zrafa));
        questions_animal.add(new QuestionModel("أين الحمار الوحشي ؟", R.raw.s_zebra, R.drawable.pic_forest_zebra));
        return questions_animal;
    }

    public static List<QuestionModel> getNumberArQuestions() {
        ArrayList<QuestionModel> questions_number_ar = new ArrayList<>();
        questions_number_ar.add(new QuestionModel("أين رقم 1 ؟", R.raw.sn1, R.drawable.pic_numbers_1_ar));
        questions_number_ar.add(new QuestionModel("أين رقم 4 ؟", R.raw.sn4, R.drawable.pic_numbers_4_ar));
        questions_number_ar.add(new QuestionModel("أين رقم 6 ؟", R.raw.sn6, R.drawable.pic_numbers_6_ar));
        questions_number_ar.add(new QuestionModel("أين رقم 9 ؟", R.raw.sn9, R.drawable.pic_numbers_9_ar));
        questions_number_ar.add(new QuestionModel("أين رقم 7 ؟", R.raw.sn7, R.drawable.pic_numbers_7_ar));
        questions_number_ar.add(new QuestionModel("أين رقم 3 ؟", R.raw.sn3, R.drawable.pic_numbers_3_ar));
        questions_number_ar.add(new QuestionModel("أين رقم 5 ؟", R.raw.sn5, R.drawable.pic_numbers_5_ar));
        questions_number_ar.add(new QuestionModel("أين رقم 10 ؟", R.raw.sn10, R.drawable.pic_numbers_10_ar));
        questions_number_ar.add(new QuestionModel("أين رقم 2 ؟", R.raw.sn2, R.drawable.pic_numbers_2_ar));
        questions_number_ar.add(new QuestionModel("أين رقم 8 ؟", R.raw.sn8, R.drawable.pic_numbers_8_ar));
        return questions_number_ar;
    }

    public static List<QuestionModel> getNumberEnQuestions() {
        ArrayList<QuestionModel> questions_number_en = new ArrayList<>();
        questions_number_en.add(new QuestionModel("أين رقم 1 ؟", R.raw.sn1, R.drawable.pic_numbers_1_en));
        questions_number_en.add(new QuestionModel("أين رقم 4 ؟", R.raw.sn4, R.drawable.pic_numbers_4_en));
        questions_number_en.add(new QuestionModel("أين رقم 6 ؟", R.raw.sn6, R.drawable.pic_numbers_6_en));
        questions_number_en.add(new QuestionModel("أين رقم 9 ؟", R.raw.sn9, R.drawable.pic_numbers_9_en));
        questions_number_en.add(new QuestionModel("أين رقم 7 ؟", R.raw.sn7, R.drawable.pic_numbers_7_en));
        questions_number_en.add(new QuestionModel("أين رقم 3 ؟", R.raw.sn3, R.drawable.pic_numbers_3_en));
        questions_number_en.add(new QuestionModel("أين رقم 5 ؟", R.raw.sn5, R.drawable.pic_numbers_5_en));
        questions_number_en.add(new QuestionModel("أين رقم 10 ؟", R.raw.sn10, R.drawable.pic_numbers_10));
        questions_number_en.add(new QuestionModel("أين رقم 2 ؟", R.raw.sn2, R.drawable.pic_numbers_2_en));
        questions_number_en.add(new QuestionModel("أين رقم 8 ؟", R.raw.sn8, R.drawable.pic_numbers_8_en));
        return questions_number_en;
    }

    public static List<QuestionModel> getShapeQuestions() {
        ArrayList<QuestionModel> questions_shape = new ArrayList<>();
        questions_shape.add(new QuestionModel("أين المعين ؟", R.raw.s_mo3yn, R.drawable.pic_shape_mo3yn));
        questions_shape.add(new QuestionModel("أين الشكل البيضاوي ؟", R.raw.s_oval, R.drawable.pic_shape_oval));
        questions_shape.add(new QuestionModel("أين متوازى المستطيلات ؟", R.raw.s_parallel, R.drawable.pic_shape_motwazy));
        questions_shape.add(new QuestionModel("أين المستطيل ؟", R.raw.s_rec, R.drawable.pic_shape_rectangle));
        questions_shape.add(new QuestionModel("أين الشكل السداسي ؟", R.raw.s_sdasy, R.drawable.pic_shape_sdasy));
        questions_shape.add(new QuestionModel("أين المربع ؟", R.raw.s_square, R.drawable.pic_shape_square));
        questions_shape.add(new QuestionModel("أين المثلث ؟", R.raw.s_triangle, R.drawable.pic_shape_tringle));
        return questions_shape;
    }
}
