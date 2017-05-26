package com.stoups.services;

import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.*;
import com.google.api.services.youtube.model.Comment;
import com.stoups.configuration.Configuration;
import com.stoups.models.*;
import com.stoups.models.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by astouparenko on 4/26/2017.
 */
@Component
public class VideoLinkCollector {

    @Autowired
    Configuration config;

    private static YouTube youtube;
    boolean init = false;

    public List<Video> searchYoutubeVideos(String q, String order, int rows) {

        initRequest();

        // Define the API request for retrieving search results.
        YouTube.Search.List search;
        List<Video> videos = new ArrayList<Video>();

        try {
            search = youtube.search().list("id,snippet");

            //Set Request Params and add Key
            String apiKey = config.getYoutubeKey();
            search.setKey(apiKey);
            search.setQ(q);
            search.setType("video");
            search.setMaxResults((long)rows);
            search.setOrder("viewCount");

            SearchListResponse searchResponse = search.execute();

            List<SearchResult> results = searchResponse.getItems();

            //Set various Values for Videos
            for (SearchResult video : results) {
                Video vidItem = new Video();
                vidItem.setVideoId(video.getId().getVideoId());
                vidItem.setChannelId(video.getId().getChannelId());

                SearchResultSnippet snippet = video.getSnippet();
                vidItem.setDescription(snippet.getDescription());
                vidItem.setTitle(snippet.getTitle());
                vidItem.setPublished(snippet.getPublishedAt());
                vidItem.setLiveContent(snippet.getLiveBroadcastContent());

                ThumbnailDetails thumbnails = snippet.getThumbnails();
                vidItem.setThumbnailUrl(thumbnails.getMedium().getUrl());
                videos.add(vidItem);
            }

        } catch (IOException e) {
            System.out.println("Could not Send Youtube Video List Request");
            return null;
        }

        return videos;
    }

    List<com.stoups.models.Comment> getTopCommentsForVideo(String videoId, String videoName, int rows, int offset) {
        initRequest();

        List<com.stoups.models.Comment> topComments = new ArrayList<>();

        try {
            YouTube.CommentThreads.List search = youtube.commentThreads().list("snippet");

            //Set Request Params and add Key
            String apiKey = config.getYoutubeKey();
            search.setKey(apiKey);
            search.setVideoId(videoId);
            search.setOrder("relevance");
            search.setMaxResults((long)rows);
            CommentThreadListResponse results = search.execute();

            for (CommentThread thread : results.getItems()){
                com.stoups.models.Comment comment = new com.stoups.models.Comment();

                CommentSnippet snippet = thread.getSnippet().getTopLevelComment().getSnippet();
                comment.setUserName(snippet.getAuthorDisplayName());
                comment.setLikeCount(snippet.getLikeCount());
                comment.setText(snippet.getTextDisplay());
                comment.setPostDate(snippet.getPublishedAt());
                comment.setVideoId(snippet.getVideoId());
                comment.setVideoTitle(videoName);
                topComments.add(comment);
            }

        } catch (IOException e) {
          //  System.out.println("Oh oh: " + e.getMessage());
        }

        return topComments;
    }

    public void initRequest() {

        if ( init == false ) {
            //Construct YouTube Request
            youtube = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(), new HttpRequestInitializer() {
                public void initialize(com.google.api.client.http.HttpRequest request) throws IOException {
                }
            }).setApplicationName("SimpleVideoGameDB").build();

            init = true;
        }
    }
}
