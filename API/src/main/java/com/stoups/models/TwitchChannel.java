package com.stoups.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by astouparenko on 5/26/2017.
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class TwitchChannel extends Channel {

    boolean mature;
    String status;

    @JsonProperty("display_name")
    String displayName;
    String game;
    String logo;

}
