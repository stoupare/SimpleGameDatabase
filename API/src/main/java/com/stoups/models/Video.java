package com.stoups.models;

import com.google.api.client.util.DateTime;

/**
 * Created by astouparenko on 4/27/2017.
 */
public class Video {

    String description;
    String videoId;
    String title;
    String thumbnailUrl;
    String ChannelId;
    String channelName;
    String liveContent;

    DateTime published;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getChannelId() {
        return ChannelId;
    }

    public void setChannelId(String channelId) {
        ChannelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getLiveContent() {
        return liveContent;
    }

    public void setLiveContent(String liveContent) {
        this.liveContent = liveContent;
    }

    public DateTime getPublished() {
        return published;
    }

    public void setPublished(DateTime published) {
        this.published = published;
    }
}
