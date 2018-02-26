package com.qencode.api.java.client.response;

import org.codehaus.jackson.annotate.JsonProperty;

public class QencodeApiResponse {
    private int error = -1;
    private String message;

    @JsonProperty("error")
    public int getError() {
        return error;
    }
    @JsonProperty("error")
    public void setError(int error) {
        this.error = error;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }
}
