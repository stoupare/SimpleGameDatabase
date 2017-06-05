package com.stoups.services.video.service;

import com.stoups.configuration.Configuration;
import com.stoups.models.TwitchChannel;
import com.stoups.models.wrapper.TwitchResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

/**
 * Created by astouparenko on 5/26/2017.
 */
@Service
public class TwitchSearchService {

    private static Logger logger = LoggerFactory.getLogger(TwitchSearchService.class);

    @Autowired
    Configuration config;

    public List<TwitchChannel> searchTopChannels (String query) {
        return searchTwitchChannel(query);

    }


    private List<TwitchChannel> searchTwitchChannel (String query) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Client-Id", config.getTwitchKey());
        headers.add("Accept", "application/vnd.twitchtv.v5+json");

        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        try {
            query = URLEncoder.encode(query, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.debug("Could not Url Encode");
        }

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<TwitchResponseWrapper> responseEntity = restTemplate.exchange("https://api.twitch.tv/kraken/search/channels?query=" + query, GET, entity, TwitchResponseWrapper.class);
        TwitchResponseWrapper twitch = responseEntity.getBody();
        List<TwitchChannel> channels = twitch.getChannels();

        return channels;
    }
}
