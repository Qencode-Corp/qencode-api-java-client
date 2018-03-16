package com.qencode.api.java.client.classes;

import com.qencode.api.java.client.classes.CustomParams.Format;

import java.util.ArrayList;
import java.util.List;

public class CustomTranscodingParams {
    /**
     * Source video URI. Can be http(s) url or tus uri
     */
    private String source;

    /**
     * {@link CustomTranscodingParams#source}
     */
    public String getSource() {
        return source;
    }
    /**
     * {@link CustomTranscodingParams#source}
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * A list of objects, each describing params for a single output video stream (MP4, WEBM, HLS or MPEG-DASH).
     */
    private List<Format> format;

    /**
     * {@link CustomTranscodingParams#format}
     */
    public List<Format> getFormat() {
        return format;
    }
    /**
     * {@link CustomTranscodingParams#format}
     */
    public void setFormat(List<Format> format) {
        this.format = format;
    }

    public CustomTranscodingParams()
    {
        format = new ArrayList<Format>();
    }

}