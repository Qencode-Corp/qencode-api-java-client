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

    private int optimizeBitrate;

    /**
     * Output video frame size in pixels("width"x"height"). Defaults to original frame size.
     */
    private String size;

    /**
     * Output video frame height in pixels. Defaults to original frame height.
     */
    private int height;

    /**
     * Output video frame width in pixels. Defaults to original frame width.
     */
    private int width;

    /**
     * Output stream video codec. Defaults to libx264. Possible values are: libx264, libx265, libvpx, libvpx-vp9.
     */
    private String videoCodec;

    /**
     * Output video stream bitrate in kylobytes. Defaults to 512.
     * Note: don't specify bitrate unless you want constant bitrate for the video.
     * To create variable bitrate use quality param.
     */
    private int bitrate;

    /**
     * Output video stream quality (aka Constant rate factor). Use this param to produce optimized videos with variable bitrate.
     * For H.264 the range is 0-51: where 0 is lossless and 51 is worst possible.
     * A lower value is a higher quality and a subjectively sane range is 18-28.
     * Consider 18 to be visually lossless or nearly so: it should look the same or nearly the same as the input but it isn't technically lossless.
     */
    private int quality;

    /**
     * Rotate video through specified degrees value. Possible values are 90, 180, 270.
     */
    private int rotate;

    /**
     * Output video frame rate. Defaults to original frame rate.
     */
    private String framerate;

    /**
     * Output video pixel format. Possible values are yuv420p, yuv422p, yuvj420p, yuvj422p. Defaults to yuv420p.
     */
    private String pixFormat;

    /**
     * x264 video codec settings profile. Possible values are high, main, baseline. Defaults to main.
     */
    private String profile;

    /**
     * Output stream video codec parameters.
     */
    private VideoCodecParameters videoCodecParameters;

    /**
     * Keyframe period (in frames). Defaults to 90.
     */
    private int keyframe;

    /**
     * Specifies the start time (in seconds) in input video to begin transcoding from.
     */
    private int startTime;

    /**
     * Specifies duration of the video fragment (in seconds) to be transcoded.
     */
    private int duration;

    /**
     * Output file audio bitrate value in kylobytes. Defaults to 64.
     */
    private int audioBitrate;

    /**
     * Output file audio sample rate. Defaults to 44100.
     */
    private int audioSampleRate;

    /**
     * Output file audio channels number. Default value is 2.
     */
    private int audioChannelsNumber;

    /**
     * Output file audio codec name. Possible values are: aac, vorbis. Defaults to aac.
     */
    private String audioCodec;

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

    /**
     * {@link Format#size}
     */
    public String getSize() {
        return size;
    }

    /**
     * {@link Format#size}
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * {@link Format#height}
     */
    public int getHeight() {
        return height;
    }

    /**
     * {@link Format#height}
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * {@link Format#width}
     */
    public int getWidth() {
        return width;
    }

    /**
     * {@link Format#width}
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * {@link Format#videoCodec}
     */
    @JsonProperty("video_codec")
    public String getVideoCodec() {
        return videoCodec;
    }

    /**
     * {@link Format#videoCodec}
     */
    @JsonProperty("video_codec")
    public void setVideoCodec(String videoCodec) {
        this.videoCodec = videoCodec;
    }

    /**
     * {@link Format#bitrate}
     */
    public int getBitrate() {
        return bitrate;
    }

    /**
     * {@link Format#bitrate}
     */
    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }

    /**
     * {@link Format#quality}
     */
    public int getQuality() {
        return quality;
    }

    /**
     * {@link Format#quality}
     */
    public void setQuality(int quality) {
        this.quality = quality;
    }

    /**
     * {@link Format#rotate}
     */
    public int getRotate() {
        return rotate;
    }

    /**
     * {@link Format#rotate}
     */
    public void setRotate(int rotate) {
        this.rotate = rotate;
    }

    /**
     * {@link Format#framerate}
     */
    public String getFramerate() {
        return framerate;
    }

    /**
     * {@link Format#framerate}
     */
    public void setFramerate(String framerate) {
        this.framerate = framerate;
    }

    /**
     * {@link Format#pixFormat}
     */
    @JsonProperty("pix_format")
    public String getPixFormat() {
        return pixFormat;
    }

    /**
     * {@link Format#pixFormat}
     */
    @JsonProperty("pix_format")
    public void setPixFormat(String pixFormat) {
        this.pixFormat = pixFormat;
    }

    /**
     * {@link Format#profile}
     */
    public String getProfile() {
        return profile;
    }

    /**
     * {@link Format#profile}
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     * {@link Format#videoCodecParameters}
     */
    @JsonProperty("video_codec_parameters")
    public VideoCodecParameters getVideoCodecParameters() {
        return videoCodecParameters;
    }
    /**
     * {@link Format#videoCodecParameters}
     */
    @JsonProperty("video_codec_parameters")
    public void setVideoCodecParameters(VideoCodecParameters videoCodecParameters) {
        this.videoCodecParameters = videoCodecParameters;
    }

    /**
     * {@link Format#keyframe}
     */
    public int getKeyframe() {
        return keyframe;
    }

    /**
     * {@link Format#keyframe}
     */
    public void setKeyframe(int keyframe) {
        this.keyframe = keyframe;
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
     * {@link Format#startTime}
     */
    @JsonProperty("start_time")
    public int getStartTime() {
        return startTime;
    }

    /**
     * {@link Format#startTime}
     */
    @JsonProperty("start_time")
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    /**
     * {@link Format#duration}
     */
    public int getDuration() {
        return duration;
    }

    /**
     * {@link Format#duration}
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * {@link Format#audioBitrate}
     */
    @JsonProperty("audio_bitrate")
    public int getAudioBitrate() {
        return audioBitrate;
    }

    /**
     * {@link Format#audioBitrate}
     */
    @JsonProperty("audio_bitrate")
    public void setAudioBitrate(int audioBitrate) {
        this.audioBitrate = audioBitrate;
    }

    /**
     * {@link Format#audioSampleRate}
     */
    @JsonProperty("audio_sample_rate")
    public int getAudioSampleRate() {
        return audioSampleRate;
    }

    /**
     * {@link Format#audioSampleRate}
     */
    @JsonProperty("audio_sample_rate")
    public void setAudioSampleRate(int audioSampleRate) {
        this.audioSampleRate = audioSampleRate;
    }

    /**
     * {@link Format#audioChannelsNumber}
     */
    @JsonProperty("audio_channels_number")
    public int getAudioChannelsNumber() {
        return audioChannelsNumber;
    }

    /**
     * {@link Format#audioChannelsNumber}
     */
    @JsonProperty("audio_channels_number")
    public void setAudioChannelsNumber(int audioChannelsNumber) {
        this.audioChannelsNumber = audioChannelsNumber;
    }

    /**
     * {@link Format#audioCodec}
     */
    @JsonProperty("audio_codec")
    public String getAudioCodec() {
        return audioCodec;
    }

    /**
     * {@link Format#audioCodec}
     */
    @JsonProperty("audio_codec")
    public void setAudioCodec(String audioCodec) {
        this.audioCodec = audioCodec;
    }
    
}