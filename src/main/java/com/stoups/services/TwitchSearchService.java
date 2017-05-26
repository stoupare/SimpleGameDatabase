package com.stoups.services;

import com.stoups.configuration.Configuration;
import com.stoups.models.TwitchChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.HtmlUtils;
import sun.net.util.URLUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import static org.springframework.http.HttpMethod.POST;

/**
 * Created by astouparenko on 5/26/2017.
 */
@Service
public class TwitchSearchService {

    @Autowired
    Configuration config;
    @Autowired
    private RestTemplate restTemplate;

    public List<TwitchChannel> searchTopChannels (String query) {
        searchTwitchChannel(query);

        return null;
    }


    private void searchTwitchChannel (String query) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Client-Id", config.getTwitchKey());

        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        try {
            query = URLEncoder.encode(query, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Could not Url Encode");
        }
        restTemplate.exchange("https://api.twitch.tv/kraken/search/channels?query=" + query, POST, entity, String.class);
    }
}
