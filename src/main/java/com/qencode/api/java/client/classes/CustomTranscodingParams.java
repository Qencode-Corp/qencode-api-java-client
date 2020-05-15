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

    /**
     * CallbackUrl - URL of an endpoint on your server to handle task callbacks
     */
    private String callback_url;

    /**
     * {@link CustomTranscodingParams#callback_url}
     */
    public String getCallbackUrl() {
        return callback_url;
    }
    /**
     * {@link CustomTranscodingParams#callback_url}
     */
    public void setCallbackUrl(String callback_url) {
        this.callback_url = callback_url;
    }
    
    public CustomTranscodingParams()
    {
        format = new ArrayList<Format>();
    }

}