package com.example.model;


public class Fortune {

    private Long id;

    private int MONEY;  // 金钱运分数
    private int JOB;   // 工作运分数
    private int LOVE;   // 爱情运分数

    // 构造函数
    public Fortune() {
    }

    public Fortune(int moneyScore, int workScore, int loveScore) {
        this.MONEY = moneyScore;
        this.JOB = workScore;
        this.LOVE = loveScore;
    }

    // Getter和Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMoneyScore() {
        return MONEY;
    }

    public void setMoneyScore(int moneyScore) {
        this.MONEY = moneyScore;
    }

    public int getWorkScore() {
        return JOB;
    }

    public void setWorkScore(int workScore) {
        this.JOB = workScore;
    }

    public int getLoveScore() {
        return LOVE;
    }

    public void setLoveScore(int loveScore) {
        this.LOVE = loveScore;
    }
}