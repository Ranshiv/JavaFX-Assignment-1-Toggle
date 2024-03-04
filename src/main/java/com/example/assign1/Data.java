//Author Name -> Ranshiv Kumar
//Project Description ->
//Date -> 26-Feb-2024
//Submitted to ->Zahi Abdelaziz

package com.example.assign1;

import javafx.beans.property.*;

public class Data {
//    Variables to store id, current Rank, Last Year Rank, Language Name, Rating, Rating Change(ΔR) Respectively
//    private final IntegerProperty id;
    private final IntegerProperty currentRank;
    private final IntegerProperty lastYearRank;
    private final StringProperty languageName;
    private final DoubleProperty rating;
    private final DoubleProperty ratingChange;

//    Constructor -> To initialize the object
    public Data(int id, int currentRank, int lastYearRank, String languageName, double rating, double ratingChange) {
//        this keyword is used to direct the variable to the object
//        this.id = new SimpleIntegerProperty(id);
        this.currentRank = new SimpleIntegerProperty(currentRank);
        this.lastYearRank = new SimpleIntegerProperty(lastYearRank);
        this.languageName = new SimpleStringProperty(languageName);
        this.rating = new SimpleDoubleProperty(rating);
        this.ratingChange = new SimpleDoubleProperty(ratingChange);
    }
//    ?-  Short Flowchart how the following methods are going to work -?
//    Getters -> Returns the StringProperty itself set by the user. -> Sets the value of the given variable

    //  Getter and Setters
//    public int getId() {
//        return id.get();
//    }
//
//    public IntegerProperty idProperty() {
//        return id;
//    }
//    //    Sets the ID
//    public void setId(int id) {
//        this.id.set(id);
//    }

    public int getCurrentRank() {
        return currentRank.get();
    }

    public IntegerProperty currentRankProperty() {
        return currentRank;
    }
    //    Sets the value
    public void setCurrentRank(int currentRank) {
        this.currentRank.set(currentRank);
    }
    //    Fetches the value of the Last Year Rank
    public int getLastYearRank() {
        return lastYearRank.get();
    }

    public IntegerProperty lastYearRankProperty() {
        return lastYearRank;
    }
    //    Sets the value
    public void setLastYearRank(int lastYearRank) {
        this.lastYearRank.set(lastYearRank);
    }

//    Fetches the value of the language name
    public String getLanguageName() {
        return languageName.get();
    }

//  Returns the object itself ( Similar to toString() property)
    public StringProperty languageNameProperty() {
        return languageName;
    }

//    Sets the value
    public void setLanguageName(String languageName) {
        this.languageName.set(languageName);
    }

    public double getRating() {
        return rating.get();
    }

    public DoubleProperty ratingProperty() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating.set(rating);
    }

    public double getRatingChange() {
        return ratingChange.get();
    }

    public DoubleProperty ratingChangeProperty() {
        return ratingChange;
    }

    public void setRatingChange(double ratingChange) {
        this.ratingChange.set(ratingChange);
    }
}
