package com.example.DungeonCrawler.Models;

import java.util.ArrayList;
import java.util.List;

public class ScoreData {

    private String name;
    private int finalScore;
    private int attempt;
    private String dateTime;

    private List<ScoreObserver> observerList;



    public ScoreData(String name, int finalScore, int attempt, String dateTime) {
        this.name = name;
        this.finalScore = finalScore;
        this.attempt = attempt;
        this.dateTime = dateTime;
        observerList = new ArrayList<>();

    }

    public String getName() {
        return this.name;
    }
    public String getDateTime() {
        return this.dateTime;
    }


    public int getFinalScore() {
        notifyObservers(this.finalScore);
        return this.finalScore;
    }

    public int getAttempt() {
        return this.attempt;
    }

    public void notifyObservers(int score) {
        for (ScoreObserver observer: observerList) {
            observer.alert(score);
        }
    }



}