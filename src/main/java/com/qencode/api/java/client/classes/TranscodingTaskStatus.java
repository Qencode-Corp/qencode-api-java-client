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

    private String statusUrl;
    @JsonProperty("status_url")
    public String getStatusUrl() {
        return statusUrl;
    }
    @JsonProperty("status_url")
    public void setStatusUrl(String statusUrl) {
        this.statusUrl = statusUrl;
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

    private int error;
    @JsonProperty("error")
    public int getError() {
        return error;
    }
    @JsonProperty("error")
    public void setError(int error) {
        this.error = error;
    }

    private String errorDescription;
    @JsonProperty("error_description")
    public String getErrorDescription() {
        return errorDescription;
    }
    @JsonProperty("error_description")
    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }



    private Double sourceSize;
    @JsonProperty("source_size")
    public Double getSourceSize() {
        return sourceSize;
    }
    @JsonProperty("source_size")
    public void setSourceSize(Double sourceSize) {
        this.sourceSize = sourceSize;
    }

    private List<AudiosStatus> audios;
    @JsonProperty("audios")
    public List<AudiosStatus> getAudios() {
        return audios;
    }
    @JsonProperty("audios")
    public void setAudios(List<AudiosStatus> audios) {
        this.audios = audios;
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




}
