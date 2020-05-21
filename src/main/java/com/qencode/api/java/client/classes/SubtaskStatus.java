package com.qencode.api.java.client.classes;

import org.codehaus.jackson.annotate.JsonProperty;

public class SubtaskStatus {
     /**
     * Resulting video url
     */
    private String url;

    /**
     * {@link SubtaskStatus#url}
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }
    /**
     * {@link SubtaskStatus#url}
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * User tag value
     */
    private String userTag;
    /**
     * {@link SubtaskStatus#userTag}
     */
    @JsonProperty("user_tag")
    public String getUserTag() {
        return userTag;
    }
    /**
     * {@link SubtaskStatus#userTag}
     */
    @JsonProperty("user_tag")
    public void setUserTag(String userTag) {
        this.userTag = userTag;
    }

    /**
     * Transcoding profile ID(s) - Is empty for custom transcoding jobs
     */
    private String profile;
    /**
     * {@link SubtaskStatus#profile}
     */
    @JsonProperty("profile")
    public String getProfile() {
        return profile;
    }
    /**
     * {@link SubtaskStatus#profile}
     */
    @JsonProperty("profile")
    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     * System tag value (e.g. video-0-0)
     */
    private String tag;
    /**
     * {@link SubtaskStatus#tag}
     */
    @JsonProperty("tag")
    public String getTag() {
        return tag;
    }
    /**
     * {@link SubtaskStatus#tag}
     */
    @JsonProperty("tag")
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * Contains info about where the output video is stored
     */
    private StorageInfo storageInfo;
    @JsonProperty("storage")
    public StorageInfo getStorageInfo() {
        return storageInfo;
    }
    @JsonProperty("storage")
    public void setStorageInfo(StorageInfo storageInfo) {
        this.storageInfo = storageInfo;
    }


    private int bitrate;

    @JsonProperty("bitrate")
    public int getBitrate() {
        return bitrate;
    }

    @JsonProperty("bitrate")
    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }


    private Double duration;

    @JsonProperty("duration")
    public Double getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Double duration) {
        this.duration = duration;
    }



    private double size;

    @JsonProperty("size")
    public double getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(double size) {
        this.size = size;
    }


    private SubtaskMeta meta;

    @JsonProperty("meta")
    public SubtaskMeta getMeta() {
        return meta;
    }

    @JsonProperty("meta")
    public void setMeta(SubtaskMeta meta) {
        this.meta = meta;
    }

    

    
}