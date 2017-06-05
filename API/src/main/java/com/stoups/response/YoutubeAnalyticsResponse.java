package com.stoups.response;

import com.google.api.services.youtube.model.Comment;

import java.util.Map;

/**
 * Created by astouparenko on 5/1/2017.
 */
public class YoutubeAnalyticsResponse {

    private double averageViews;
    private Map<String, Integer> commonWords;
    private double AvgVideoLength;
    private Map<Integer, Comment> topComments;

}
