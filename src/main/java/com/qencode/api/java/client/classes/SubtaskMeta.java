package com.qencode.api.java.client.classes;

import org.codehaus.jackson.annotate.JsonProperty;

public class SubtaskMeta {

    private int resolutionWidth;

    @JsonProperty("resolution_width")
    public int getResolutionWidth() {
        return resolutionWidth;
    }

    @JsonProperty("resolution_width")
    public void setResolutionWidth(int resolutionWidth) {
        this.resolutionWidth = resolutionWidth;
    }

    private int resolutionHeight;

    @JsonProperty("resolution_height")
    public int getResolutionHeight() {
        return resolutionHeight;
    }

    @JsonProperty("resolution_height")
    public void setResolutionHeight(int resolutionHeight) {
        this.resolutionHeight = resolutionHeight;
    }   



    private String framerate;

    @JsonProperty("framerate")
    public String getFramerate() {
        return framerate;
    }

    @JsonProperty("framerate")
    public void setFramerate(String framerate) {
        this.framerate = framerate;
    }

    private int width;

    @JsonProperty("width")
    public int getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(int width) {
        this.width = width;
    }

    private int height;

    @JsonProperty("height")
    public int getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(int height) {
        this.height = height;
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

    private String dar;

    @JsonProperty("dar")
    public String getDar() {
        return dar;
    }

    @JsonProperty("dar")
    public void setDar(String dar) {
        this.dar = dar;
    }

    private String sar;

    @JsonProperty("sar")
    public String getSar() {
        return sar;
    }

    @JsonProperty("sar")
    public void setSar(String sar) {
        this.sar = sar;
    }



    private int resolution;

    @JsonProperty("resolution")
    public int getResolution() {
        return resolution;
    }

    @JsonProperty("resolution")
    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    
}