package com.example.quiz;

public class technology{
    private String question;
    private String opta;
    private String optb;
    private String optc;
    private String optd;
    private String answer;
    public technology(String q, String a, String b, String c, String d, String ans)
    {
        question=q;
        opta=a;
        optb=b;
        optc=c;
        optd=d;
        answer=ans;

    }
    public technology()
    {}

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOpta() {
        return opta;
    }

    public void setOpta(String opta) {
        this.opta = opta;
    }

    public String getOptb() {
        return optb;
    }

    public void setOptb(String optb) {
        this.optb = optb;
    }

    public String getOptc() {
        return optc;
    }

    public void setOptc(String optc) {
        this.optc = optc;
    }

    public String getOptd() {
        return optd;
    }

    public void setOptd(String optd) {
        this.optd = optd;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


}

