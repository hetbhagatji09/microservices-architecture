package com.example.question_service.Model;





public class QuestionWrapper {

    private int id;
    private String questionTitle;
    private String option_a;
    private String option_b;
    private String option_c;
    private String option_d;


    public QuestionWrapper() {
    }

    public QuestionWrapper(int id, String questionTitle, String option_a, String option_b, String option_c, String option_d) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.option_a = option_a;
        this.option_b = option_b;
        this.option_c = option_c;
        this.option_d = option_d;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return questionTitle;
    }

    public void setQuestion(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getOption_a() {
        return option_a;
    }

    public void setOption_a(String option_a) {
        this.option_a = option_a;
    }

    public String getOption_b() {
        return option_b;
    }

    public void setOption_b(String option_b) {
        this.option_b = option_b;
    }

    public String getOption_c() {
        return option_c;
    }

    public void setOption_c(String option_c) {
        this.option_c = option_c;
    }

    public String getOption_d() {
        return option_d;
    }

    public void setOption_d(String option_d) {
        this.option_d = option_d;
    }
}
