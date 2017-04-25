package com.stoups.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by astouparenko on 4/25/2017.
 */
@org.springframework.context.annotation.Configuration
@PropertySource("classpath:app.properties")
public class Configuration {

    @Value("${proj.api.keys.vgdb}")
    private String vgdbKey;

    @Value("${proj.api.keys.youtube}")
    private String youtubeKey;


    public String getVgdbKey() {
        return vgdbKey;
    }

    public String getYoutubeKey() {
        return youtubeKey;
    }
}
