package com.qencode.api.java.client.response;

import org.codehaus.jackson.annotate.JsonProperty;

public class CreateTaskResponse extends QencodeApiResponse  {
    /**
     * Transcoding Job ID
     */
    private String task_token;

    /**
     * {@link CreateTaskResponse#task_token}
     */
    @JsonProperty("task_token")
    public String getTaskToken() {
        return task_token;
    }
    /**
     * {@link CreateTaskResponse#task_token}
     */
    @JsonProperty("task_token")
    public void setTaskToken(String task_token) {
        this.task_token = task_token;
    }

    /**
     * Url for direct video upload using tus.io protocol
     * (currently not supported with this library)
     */
    private String upload_url;
    @JsonProperty("upload_url")
    public String getUploadUrl() {
        return upload_url;
    }
    @JsonProperty("upload_url")
    public void setUploadUrl(String upload_url) {
        this.upload_url = upload_url;
    }
}
