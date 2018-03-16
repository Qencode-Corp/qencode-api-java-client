package com.qencode.api.java.client.classes.CustomParams;

import org.codehaus.jackson.annotate.JsonProperty;

public class Stream {
    /**
     * Output video frame size in pixels("width"x"height"). Defaults to original frame size.
     */
    private String size;

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
     * Segment duration to split media (in seconds). Defaults to 8.
     */
    private int segmentDuration;

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

    /**
     * {@link Stream#size}
     */
    public String getSize() {
        return size;
    }

    /**
     * {@link Stream#size}
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * {@link Stream#videoCodec}
     */
    @JsonProperty("video_codec")
    public String getVideoCodec() {
        return videoCodec;
    }

    /**
     * {@link Stream#videoCodec}
     */
    @JsonProperty("video_codec")
    public void setVideoCodec(String videoCodec) {
        this.videoCodec = videoCodec;
    }

    /**
     * {@link Stream#bitrate}
     */
    public int getBitrate() {
        return bitrate;
    }

    /**
     * {@link Stream#bitrate}
     */
    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }

    /**
     * {@link Stream#quality}
     */
    public int getQuality() {
        return quality;
    }

    /**
     * {@link Stream#quality}
     */
    public void setQuality(int quality) {
        this.quality = quality;
    }

    /**
     * {@link Stream#rotate}
     */
    public int getRotate() {
        return rotate;
    }

    /**
     * {@link Stream#rotate}
     */
    public void setRotate(int rotate) {
        this.rotate = rotate;
    }

    /**
     * {@link Stream#framerate}
     */
    public String getFramerate() {
        return framerate;
    }

    /**
     * {@link Stream#framerate}
     */
    public void setFramerate(String framerate) {
        this.framerate = framerate;
    }

    /**
     * {@link Stream#pixFormat}
     */
    @JsonProperty("pix_format")
    public String getPixFormat() {
        return pixFormat;
    }

    /**
     * {@link Stream#pixFormat}
     */
    @JsonProperty("pix_format")
    public void setPixFormat(String pixFormat) {
        this.pixFormat = pixFormat;
    }

    /**
     * {@link Stream#profile}
     */
    public String getProfile() {
        return profile;
    }

    /**
     * {@link Stream#profile}
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     * {@link Stream#videoCodecParameters}
     */
    @JsonProperty("video_codec_parameters")
    public VideoCodecParameters getVideoCodecParameters() {
        return videoCodecParameters;
    }
    /**
     * {@link Stream#videoCodecParameters}
     */
    @JsonProperty("video_codec_parameters")
    public void setVideoCodecParameters(VideoCodecParameters videoCodecParameters) {
        this.videoCodecParameters = videoCodecParameters;
    }

    /**
     * {@link Stream#keyframe}
     */
    public int getKeyframe() {
        return keyframe;
    }

    /**
     * {@link Stream#keyframe}
     */
    public void setKeyframe(int keyframe) {
        this.keyframe = keyframe;
    }

    /**
     * {@link Stream#segmentDuration}
     */
    @JsonProperty("segment_duration")
    public int getSegmentDuration() {
        return segmentDuration;
    }

    /**
     * {@link Stream#segmentDuration}
     */
    @JsonProperty("segment_duration")
    public void setSegmentDuration(int segmentDuration) {
        this.segmentDuration = segmentDuration;
    }

    /**
     * {@link Stream#startTime}
     */
    @JsonProperty("start_time")
    public int getStartTime() {
        return startTime;
    }

    /**
     * {@link Stream#startTime}
     */
    @JsonProperty("start_time")
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    /**
     * {@link Stream#duration}
     */
    public int getDuration() {
        return duration;
    }

    /**
     * {@link Stream#duration}
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * {@link Stream#audioBitrate}
     */
    @JsonProperty("audio_bitrate")
    public int getAudioBitrate() {
        return audioBitrate;
    }

    /**
     * {@link Stream#audioBitrate}
     */
    @JsonProperty("audio_bitrate")
    public void setAudioBitrate(int audioBitrate) {
        this.audioBitrate = audioBitrate;
    }

    /**
     * {@link Stream#audioSampleRate}
     */
    @JsonProperty("audio_sample_rate")
    public int getAudioSampleRate() {
        return audioSampleRate;
    }

    /**
     * {@link Stream#audioSampleRate}
     */
    @JsonProperty("audio_sample_rate")
    public void setAudioSampleRate(int audioSampleRate) {
        this.audioSampleRate = audioSampleRate;
    }

    /**
     * {@link Stream#audioChannelsNumber}
     */
    @JsonProperty("audio_channels_number")
    public int getAudioChannelsNumber() {
        return audioChannelsNumber;
    }

    /**
     * {@link Stream#audioChannelsNumber}
     */
    @JsonProperty("audio_channels_number")
    public void setAudioChannelsNumber(int audioChannelsNumber) {
        this.audioChannelsNumber = audioChannelsNumber;
    }

    /**
     * {@link Stream#audioCodec}
     */
    @JsonProperty("audio_codec")
    public String getAudioCodec() {
        return audioCodec;
    }

    /**
     * {@link Stream#audioCodec}
     */
    @JsonProperty("audio_codec")
    public void setAudioCodec(String audioCodec) {
        this.audioCodec = audioCodec;
    }
}
