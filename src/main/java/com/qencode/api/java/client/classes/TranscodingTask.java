package com.qencode.api.java.client.classes;

import com.qencode.api.java.client.QencodeApiClient;
import com.qencode.api.java.client.QencodeException;
import com.qencode.api.java.client.response.StartEncodeResponse;
import com.qencode.api.java.client.response.StatusResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class TranscodingTask {
    private QencodeApiClient api;
    
    private String taskToken;

    /**
     * @return Task token value
     */
    public String getTaskToken() {
        return taskToken;
    }

    private String statusUrl;

    /**
     * @return Task status url
     */
    public String getStatusUrl() {
        return statusUrl;
    }

    /**
     * One or several transcoding profile IDs as a comma-separated string
     */
    private String transcodingProfiles;

    /**
     * {@link TranscodingTask#transcodingProfiles}
     */
    public String getTranscodingProfiles() {
        return transcodingProfiles;
    }
    /**
     * {@link TranscodingTask#transcodingProfiles}
     */
    public void setTranscodingProfiles(String transcodingProfiles) {
        this.transcodingProfiles = transcodingProfiles;
    }

    /**
     * a link to input video or TUS uri
     */
    private String uri;

    /**
     * {@link TranscodingTask#uri}
     */
    public String getUri() {
        return uri;
    }
    /**
     * {@link TranscodingTask#uri}
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    private List<StitchVideoItem> stitchVideoItems;

    public StitchVideoItem addStitchVideoItem(String url) {
        StitchVideoItem item = new StitchVideoItem();
        if (stitchVideoItems == null) {
            stitchVideoItems = new ArrayList<StitchVideoItem>();
        }
        stitchVideoItems.add(item);
        item.setUrl(url);
        return item;
    }

    /**
     * Transfer method identifier
     */
    private String transferMethod;
    /**
     * {@link TranscodingTask#transferMethod}
     */
    public String getTransferMethod() {
        return transferMethod;
    }
    /**
     * {@link TranscodingTask#transferMethod}
     */
    public void setTransferMethod(String transferMethod) {
        this.transferMethod = transferMethod;
    }

    /**
     * Duration from specified start time in original video, seconds
     */
    private double duration;
    /**
     * {@link TranscodingTask#duration}
     */
    public double getDuration() {
        return duration;
    }
    /**
     * {@link TranscodingTask#duration}
     * @param value
     */
    public void setDuration(double value) {
        this.duration = value;
    }

    /**
     * A starting time in seconds in original video to make clip from
     */
    private double startTime;
    /**
     * {@link TranscodingTask#startTime}
     */
    public double getStartTime() {
        return startTime;
    }
    /**
     * {@link TranscodingTask#startTime}
     * @param value
     */
    public void setStartTime(double value) {
        this.startTime = value;
    }

    /**
     * Any string data of 1000 characters max length.
     * E.g. you could pass id of your site user uploading the video or any json object.
     */
    private String payload;
    /**
     * {@link TranscodingTask#payload}
     */
    public String getPayload() {
        return payload;
    }
    /**
     * {@link TranscodingTask#payload}
     */
    public void setPayload(String payload) {
        this.payload = payload;
    }

    /**
     * Output path variables map (used to set transcoding profile output path placeholder values)
     */
    private Map<String, String> outputPathVariables;
    /**
     * {@link TranscodingTask#outputPathVariables}
     */
    public Map<String, String> getOutputPathVariables() {
        return outputPathVariables;
    }
    /**
     * {@link TranscodingTask#outputPathVariables}
     */
    public void setOutputPathVariables(Map<String, String> outputPathVariables) {
        this.outputPathVariables = outputPathVariables;
    }

    /**
     * Most recent task status
     */
    private TranscodingTaskStatus lastStatus;
    /**
     * {@link TranscodingTask#lastStatus}
     */
    public TranscodingTaskStatus getLastStatus() {
        return lastStatus;
    }

    /**
     * Constructs new TranscodingTask object
     * @param api reference to QencodeApiClient
     * @param taskToken task token value obtained from create_task API method
     */
    public TranscodingTask(QencodeApiClient api, String taskToken)
    {
        this.api = api;
        this.taskToken = taskToken;
        this.statusUrl = null;
    }

    /**
     * Starts transcoding job using specified transcoding profile or list of profiles
     * @return Response of start_encode API method
     * @throws UnsupportedEncodingException
     * @throws QencodeException
     */
    public StartEncodeResponse start() throws IOException, QencodeException {
        Map<String, String> params = new HashMap<String, String>();
        if (stitchVideoItems.size() > 0) {
            params.put("stitch", api.getMapper().writeValueAsString(stitchVideoItems));
        }
        else {
            params.put("uri", uri);
        }
        params.put("profiles", transcodingProfiles);
        if (transferMethod != null) {
            params.put("transfer_method", transferMethod);
        }
        if (outputPathVariables != null) {
            params.put("output_path_variables", api.getMapper().writeValueAsString(outputPathVariables));
        }

        return _do_request("start_encode", params);
    }

    /**
     * Starts transcoding job using custom params
     * @param taskParams
     * @return Response of start_encode2 API method
     * @throws IOException
     * @throws QencodeException
     */
    public StartEncodeResponse startCustom(CustomTranscodingParams taskParams) throws IOException, QencodeException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("query", api.getMapper().writeValueAsString(taskParams));
        return _do_request("start_encode2", params);
    }

    private StartEncodeResponse _do_request(String methodName, Map<String, String> params) throws UnsupportedEncodingException, QencodeException {
        params.put("task_token", taskToken);
        if (payload != null) {
            params.put("payload", payload);
        }
        if (startTime > 0) {
            params.put("start_time", String.format(Locale.ROOT, "%.4f", startTime));
        }
        if (duration > 0) {
            params.put("duration", String.format(Locale.ROOT, "%.4f", duration));
        }
        String responseStr = api.Request(methodName, params);
        StartEncodeResponse response;
        try {
            response = api.getMapper().readValue(
                    responseStr,
                    StartEncodeResponse.class);
        } catch (Exception e) {
            throw new QencodeException(
                    "Unable to deserialize StartEncodeResponse as JSON", e);
        }
        this.statusUrl = response.getStatusUrl();
        return response;
    }

    /**
     * Gets current task status from Qencode service
     * @return TranscodingTaskStatus object
     * @throws UnsupportedEncodingException
     * @throws QencodeException
     */
    public TranscodingTaskStatus getStatus() throws UnsupportedEncodingException, QencodeException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("task_tokens[]", taskToken);
        String responseStr = api.Request(this.statusUrl, params);
        StatusResponse response = null;
        try {
            response = api.getMapper().readValue(
                    responseStr,
                    StatusResponse.class);
        } catch (Exception e) {
            throw new QencodeException(
                    "Unable to deserialize StartEncodeResponse as JSON", e);
        }

        //TODO: fallback to /v1/status
        Map<String, TranscodingTaskStatus> statuses = response.getStatuses();
        lastStatus = statuses.get(this.taskToken);
        return lastStatus;
    }
}