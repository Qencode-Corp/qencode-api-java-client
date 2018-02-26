package com.qencode.api.java.client.classes;

import org.codehaus.jackson.annotate.JsonProperty;

public class ImageStatus {
    private String url;

    /**
     * Resulting thumbnail url
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    private String tag;

    /**
     * System tag value (e.g. image-0-0)
     */
    @JsonProperty("tag")
    public String getTag() {
        return tag;
    }
    @JsonProperty("tag")
    public void setTag(String tag) {
        this.tag = tag;
    }

    private StorageInfo storageInfo;

    /**
     * Contains info about where the thumbnail is stored
     */
    @JsonProperty("storage_info")
    public StorageInfo getStorageInfo() {
        return storageInfo;
    }
    @JsonProperty("storage_info")
    public void setStorageInfo(StorageInfo storageInfo) {
        this.storageInfo = storageInfo;
    }
}
