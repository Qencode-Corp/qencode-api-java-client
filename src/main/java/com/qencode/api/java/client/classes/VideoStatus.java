package com.qencode.api.java.client.classes;

import org.codehaus.jackson.annotate.JsonProperty;

public class VideoStatus {
    /**
     * Resulting video url
     */
    private String url;

    /**
     * {@link VideoStatus#url}
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }
    /**
     * {@link VideoStatus#url}
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
     * {@link VideoStatus#userTag}
     */
    @JsonProperty("user_tag")
    public String getUserTag() {
        return userTag;
    }
    /**
     * {@link VideoStatus#userTag}
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
     * {@link VideoStatus#profile}
     */
    @JsonProperty("profile")
    public String getProfile() {
        return profile;
    }
    /**
     * {@link VideoStatus#profile}
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
     * {@link VideoStatus#tag}
     */
    @JsonProperty("tag")
    public String getTag() {
        return tag;
    }
    /**
     * {@link VideoStatus#tag}
     */
    @JsonProperty("tag")
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * Contains info about where the output video is stored
     */
    private StorageInfo storageInfo;
    @JsonProperty("storage_info")
    public StorageInfo getStorageInfo() {
        return storageInfo;
    }
    @JsonProperty("storage_info")
    public void setStorageInfo(StorageInfo storageInfo) {
        this.storageInfo = storageInfo;
    }
}
