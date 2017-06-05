package com.stoups.models.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.stoups.models.TwitchChannel;

import java.util.HashMap;
import java.util.List;

/**
 * Created by astouparenko on 6/5/2017.
 */
public class TwitchResponseWrapper {

    @JsonProperty("_total")
    long total;

    @JsonProperty("_links")
    HashMap<String, String> links;

    @JsonProperty("channels")
    List<TwitchChannel> channels;

    public List<TwitchChannel> getChannels() {
        return channels;
    }

    public void setChannels(List<TwitchChannel> channels) {
        this.channels = channels;
    }

}
