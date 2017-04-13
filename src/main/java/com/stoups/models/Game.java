package com.stoups.models;

import java.util.Date;

/**
 * Created by astouparenko on 4/11/2017.
 */
public class Game {

    private String title;
    private float score;
    private int idValue;
    private Date publishDate;
    private String genre;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getIdValue() {
        return idValue;
    }

    public void setIdValue(int idValue) {
        this.idValue = idValue;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
    
    public String getGenre() {

        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
