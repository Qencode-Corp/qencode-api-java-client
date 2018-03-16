package com.qencode.api.java.client.classes.CustomParams;

import org.codehaus.jackson.annotate.JsonProperty;

public class Libx264_VideoCodecParameters extends VideoCodecParameters {
    /**
     * x264 video codec settings profile. Possible values are high, main, baseline. Defaults to main.
     */
    private String vprofile;

    /**
     * Set of constraints that indicate a degree of required decoder performance for a profile.
     */
    private int level;

    /**
     * Context-Adaptive Binary Arithmetic Coding (CABAC) is the default entropy encoder used by x264. Possible values are 1 and 0. Defaults to 1.
     */
    private int coder;

    /**
     * Allows B-frames to be kept as references. Possible values are +bpyramid, +wpred, +mixed_refs, +dct8×8, -fastpskip/+fastpskip, +aud Defaults to None.
     */
    private String flags2;

    /**
     * One of x264's most useful features is the ability to choose among many combinations of inter and intra partitions.
     * Possible values are +partp8x8, +partp4x4, +partb8x8, +parti8x8, +parti4x4.Defaults to None.
     */
    private String partitions;

    private String bf;

    /**
     * Defines motion detection type: 0 -- none, 1 -- spatial, 2 -- temporal, 3 -- auto. Defaults to 1.
     */
    private int directpred;

    /**
     * Motion Estimation method used in encoding.Possible values are epzs, hex, umh, full. Defaults to None.
     */
    private String meMethod;

    /**
     * {@link Libx264_VideoCodecParameters#vprofile}
     */
    @JsonProperty("vprofile")
    public String getVprofile() {
        return vprofile;
    }

    /**
     * {@link Libx264_VideoCodecParameters#vprofile}
     */
    @JsonProperty("vprofile")
    public void setVprofile(String vprofile) {
        this.vprofile = vprofile;
    }

    /**
     * {@link Libx264_VideoCodecParameters#level}
     */
    public int getLevel() {
        return level;
    }

    /**
     * {@link Libx264_VideoCodecParameters#level}
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * {@link Libx264_VideoCodecParameters#coder}
     */
    public int getCoder() {
        return coder;
    }

    /**
     * {@link Libx264_VideoCodecParameters#coder}
     */
    public void setCoder(int coder) {
        this.coder = coder;
    }

    /**
     * {@link Libx264_VideoCodecParameters#flags2}
     */
    public String getFlags2() {
        return flags2;
    }

    /**
     * {@link Libx264_VideoCodecParameters#flags2}
     */
    public void setFlags2(String flags2) {
        this.flags2 = flags2;
    }

    /**
     * {@link Libx264_VideoCodecParameters#partitions}
     */
    public String getPartitions() {
        return partitions;
    }

    /**
     * {@link Libx264_VideoCodecParameters#partitions}
     */
    public void setPartitions(String partitions) {
        this.partitions = partitions;
    }

    /**
     * {@link Libx264_VideoCodecParameters#directpred}
     */
    public int getDirectpred() {
        return directpred;
    }

    /**
     * {@link Libx264_VideoCodecParameters#directpred}
     */
    public void setDirectpred(int directpred) {
        this.directpred = directpred;
    }

    /**
     * {@link Libx264_VideoCodecParameters#meMethod}
     */
    @JsonProperty("me_method")
    public String getMeMethod() {
        return meMethod;
    }

    /**
     * {@link Libx264_VideoCodecParameters#meMethod}
     */
    @JsonProperty("me_method")
    public void setMeMethod(String meMethod) {
        this.meMethod = meMethod;
    }
}