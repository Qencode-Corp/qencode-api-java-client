package com.qencode.api.java.client.classes;

import org.codehaus.jackson.annotate.JsonProperty;

public class StitchVideoItem {
    /**
     * a link to input video
     */
    private String url;
    /**
     * {@link StitchVideoItem#url}
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }
    /**
     * {@link StitchVideoItem#url}
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Duration from specified start time in original video, seconds
     */
    private double duration;
    /**
     * {@link StitchVideoItem#duration}
     */
    @JsonProperty("duration")
    public double getDuration() {
        return duration;
    }
    /**
     * {@link StitchVideoItem#duration}
     * @param value
     */
    @JsonProperty("duration")
    public void setDuration(double value) {
        this.duration = value;
    }

    /**
     * A starting time in seconds in original video to make clip from
     */
    private double startTime;
    /**
     * {@link StitchVideoItem#startTime}
     */
    @JsonProperty("start_time")
    public double getStartTime() {
        return startTime;
    }
    /**
     * {@link StitchVideoItem#startTime}
     * @param value
     */
    @JsonProperty("start_time")
    public void setStartTime(double value) {
        this.startTime = value;
    }
}
