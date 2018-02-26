package com.qencode.api.java.client.response;

import com.qencode.api.java.client.classes.TranscodingTaskStatus;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Map;

public class StatusResponse extends QencodeApiResponse {
    private Map<String, TranscodingTaskStatus> statuses;
    @JsonProperty("statuses")
    public Map<String, TranscodingTaskStatus> getStatuses() {
        return this.statuses;
    }
    @JsonProperty("statuses")
    public void setStatuses(Map<String, TranscodingTaskStatus> statuses) {
        this.statuses = statuses;
    }

}
