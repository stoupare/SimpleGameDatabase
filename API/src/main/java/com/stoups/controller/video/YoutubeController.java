package com.stoups.controller.video;

import com.stoups.models.Comment;
import com.stoups.request.AnalyticsRequest;
import com.stoups.services.video.service.YoutubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by astouparenko on 5/29/2017.
 */

@RestController
@RequestMapping(value = {"/core/analytics/youtube"})
public class YoutubeController {

    @Autowired
    YoutubeService youtubeService;

    @RequestMapping(value = "/topComments")
    public List<Comment> analyzeYoutube(@RequestBody AnalyticsRequest request){
        return youtubeService.getTopComments(request);
    }
}
