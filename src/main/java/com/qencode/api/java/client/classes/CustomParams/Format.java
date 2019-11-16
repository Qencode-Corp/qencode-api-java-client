package com.qencode.api.java.client.classes.CustomParams;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Format {
    /**
     * Output video format. Currently supported values are mp4, webm, advanced_hls, advanced_dash. Required.
     */
    private String output;

    /**
     * Output video file extension (for MP4 - defaults to '.mp4', for WEBM - defaults to '.webm').
     */
    private String fileExtension;

    /**
     * URI to store output video in. In case this value is not specified, video is temporarily stored on Qencode servers.
     */
    private Destination destination;

    /**
     * Segment duration to split media (in seconds). Defaults to 8.
     */
    private int segmentDuration;

    /**
     * Contains a list of elements each describing a single view stream (e.g. for HLS format).
     */
    private List<Stream> stream;

    /**
     * Option to turn on optimize bitrate mode. Defaults to 0.
     */
    private int optimizeBitrate;

    public Format()
    {
        stream = new ArrayList<Stream>();
    }

    /**
     * {@link Format#output}
     */
    @JsonProperty("output")
    public String getOutput() {
        return output;
    }

    /**
     * {@link Format#output}
     */
    @JsonProperty("output")
    public void setOutput(String output) {
        this.output = output;
    }

    /**
     * {@link Format#fileExtension}
     */
    @JsonProperty("file_extension")
    public String getFileExtension() {
        return fileExtension;
    }

    /**
     * {@link Format#fileExtension}
     */
    @JsonProperty("file_extension")
    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    /**
     * {@link Format#destination}
     */
    @JsonProperty("destination")
    public Destination getDestination() {
        return destination;
    }

    /**
     * {@link Format#destination}
     */
    @JsonProperty("destination")
    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    /**
     * {@link Format#segmentDuration}
     */
    @JsonProperty("segment_duration")
    public int getSegmentDuration() {
        return segmentDuration;
    }

    /**
     * {@link Format#segmentDuration}
     */
    @JsonProperty("segment_duration")
    public void setSegmentDuration(int segmentDuration) {
        this.segmentDuration = segmentDuration;
    }

    /**
     * {@link Format#optimizeBitrate}
     */
    @JsonProperty("optimize_bitrate")
    public int getOptimizeBitrate() {
        return optimizeBitrate;
    }

    /**
     * {@link Format#optimizeBitrate}
     */
    @JsonProperty("optimize_bitrate")
    public void setOptimizeBitrate(int optimizeBitrate) {
        this.optimizeBitrate = optimizeBitrate;
    }

    /**
     * {@link Format#stream}
     */
    @JsonProperty("stream")
    public List<Stream> getStream() {
        return stream;
    }

    /**
     * {@link Format#stream}
     */
    @JsonProperty("stream")
    public void setStream(List<Stream> stream) {
        this.stream = stream;
    }
}