package com.vuongthanh.t3h.baitap_buoi7_gamedhbc;

public class Player {
    private int score;
    private String answer;
    private int heart;

    public Player() {
    }

    public Player(int score, String answer, int heart) {
        this.score = score;
        this.answer = answer;
        this.heart = heart;

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getHeart() {
        return heart;
    }

    public void setHeart(int heart) {
        this.heart = heart;
    }
}


