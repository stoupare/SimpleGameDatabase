package com.stoups.controller;

import com.stoups.Request.AnalyticsRequest;
import com.stoups.models.Comment;
import com.stoups.services.YoutubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by astouparenko on 5/1/2017.
 */

@RestController
@RequestMapping(value = {"/core/analytics"})
public class AnalyticsController {

    @Autowired
    YoutubeService analyticsService;

    @RequestMapping(value = "/youtube/topComments")
    public List<Comment> analyzeYoutube(@RequestBody AnalyticsRequest request){
        return analyticsService.getTopComments(request);
    }
}
