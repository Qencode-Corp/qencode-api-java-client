package com.qencode.api.java.client.response;

import org.codehaus.jackson.annotate.JsonProperty;

public class StartEncodeResponse extends QencodeApiResponse {
    /**
     * Url to check task status at
     */
    private String statusUrl;

    /**
     * {@link StartEncodeResponse#statusUrl}
     */
    @JsonProperty("status_url")
    public String getStatusUrl() {
        return statusUrl;
    }
    /**
     * {@link StartEncodeResponse#statusUrl}
     */
    @JsonProperty("status_url")
    public void setStatusUrl(String statusUrl) {
        this.statusUrl = statusUrl;
    }
}
