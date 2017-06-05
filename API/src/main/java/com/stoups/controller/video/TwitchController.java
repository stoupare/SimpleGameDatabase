package com.stoups.controller.video;

import com.stoups.models.Comment;
import com.stoups.models.TwitchChannel;
import com.stoups.request.AnalyticsRequest;
import com.stoups.services.video.service.TwitchSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by astouparenko on 5/29/2017.
 */
@RestController
@RequestMapping(value = "/core/analytics/twitch")
public class TwitchController {

    @Autowired
    TwitchSearchService twitchService;

    @RequestMapping(value = "/topChannels")
    public List<TwitchChannel> analyzeYoutube(@RequestBody AnalyticsRequest request){

        String query = request.getQuery();
        return twitchService.searchTopChannels(query);
    }
}
