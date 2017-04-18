package com.stoups.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by astouparenko on 4/11/2017.
 */
public class Game {

    @JsonProperty("name")
    private String title;

    @JsonProperty("rating")
    private float score;


    @JsonProperty("id")
    private int idValue;

    @JsonProperty("created_at")
    private Date publishDate;

    @JsonProperty("genres")
    private ArrayList<Integer> genres;

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
    
    public ArrayList<Integer> getGenre() {

        return genres;
    }

    public void setGenre(ArrayList<Integer> genre) {
        this.genres = genre;
    }
}
