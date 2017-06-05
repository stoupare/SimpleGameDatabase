package com.stoups.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by astouparenko on 5/26/2017.
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class Channel {

    private String name;

    @JsonProperty("views")
    private long totalViews;
    //Twitch uses this annoying format for some of the fields.
    @JsonProperty("_id")
    private long id;

    private double weeklyViews;
    private List<String> tags;

    private String description;
    private String url;
    private long followers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(long totalViews) {
        this.totalViews = totalViews;
    }

    public double getWeeklyViews() {
        return weeklyViews;
    }

    public void setWeeklyViews(double weeklyViews) {
        this.weeklyViews = weeklyViews;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getFollowers() {
        return followers;
    }

    public void setFollowers(long followers) {
        this.followers = followers;
    }
}
