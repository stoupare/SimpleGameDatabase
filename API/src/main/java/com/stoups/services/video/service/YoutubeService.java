package com.stoups.services.video.service;

import com.stoups.request.AnalyticsRequest;
import com.stoups.models.Comment;
import com.stoups.models.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by astouparenko on 4/25/2017.
 */
@Service
public class YoutubeService {

    public static int STANDARD_ROW_COUNT = 50;

    @Autowired
    YoutubeVideoCollector youtube;

    public List<Comment> getTopComments(AnalyticsRequest request) {
        String q = request.getQuery();
        int rows = (request.getRows() > 0 ) ? request.getRows() : STANDARD_ROW_COUNT;

        List<Video> videos = youtube.searchYoutubeVideos(q, "viewCount", 40);
        List<Comment> topComments = new ArrayList<>();
        for (Video video : videos) {
            List<Comment> videoComments = youtube.getTopCommentsForVideo(video.getVideoId(), video.getTitle(), rows, 0);
            topComments.addAll(videoComments);
        }

        Collections.sort(topComments, (o1, o2) -> (int)(o2.getLikeCount() - o1.getLikeCount()));

        return topComments;
    }

}
