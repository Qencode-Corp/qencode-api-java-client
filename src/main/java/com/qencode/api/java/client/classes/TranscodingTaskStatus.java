package com.qencode.api.java.client.classes;

import org.codehaus.jackson.annotate.JsonProperty;
import java.util.List;

public class TranscodingTaskStatus {
    private String status;
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    private Float percent;
    @JsonProperty("percent")
    public Float getPercent() {
        return percent;
    }
    @JsonProperty("percent")
    public void setPercent(Float percent) {
        this.percent = percent;
    }

    private List<VideoStatus> videos;
    @JsonProperty("videos")
    public List<VideoStatus> getVideos() {
        return this.videos;
    }
    @JsonProperty("videos")
    public void setVideos(List<VideoStatus> videos) {
        this.videos = videos;
    }

    private List<ImageStatus> images;
    @JsonProperty("images")
    public List<ImageStatus> getImages() {
        return this.images;
    }
    @JsonProperty("images")
    public void setImages(List<ImageStatus> images) {
        this.images = images;
    }
}
