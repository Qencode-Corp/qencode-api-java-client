package com.qencode.api.java.client.classes;

import com.qencode.api.java.client.QencodeApiClient;
import com.qencode.api.java.client.QencodeException;
import com.qencode.api.java.client.response.StartEncodeResponse;
import com.qencode.api.java.client.response.StatusResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

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
     * Output path variables map
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
        params.put("task_token", taskToken);
        params.put("uri", uri);
        params.put("profiles", transcodingProfiles);
        if (transferMethod != null) {
            params.put("transfer_method", transferMethod);
        }
        if (payload != null) {
            params.put("payload", payload);
        }
        if (outputPathVariables != null) {
            params.put("output_path_variables", api.getMapper().writeValueAsString(outputPathVariables));
        }
        String responseStr = api.Request("start_encode", params);
        StartEncodeResponse response = null;
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

    /*
    public StartEncodeResponse StartCustom(CustomTranscodingParams taskParams, string payload = null)
        {
            var query = new Dictionary<string, CustomTranscodingParams>() { { "query", taskParams } };
            var query_json = JsonConvert.SerializeObject(query,
                Formatting.None,
                new JsonSerializerSettings { NullValueHandling = NullValueHandling.Ignore});

            var parameters = new Dictionary<string, string>
            {
                {"task_token", taskToken },
                {"query", query_json }
            };
            if (payload != null)
            {
                parameters.Add("payload", payload);
            }

            return _do_request("start_encode2", parameters);
        }

        private StartEncodeResponse _do_request(string methodName, Dictionary<string, string> parameters)
        {
            var response = api.Request<StartEncodeResponse>(methodName, parameters) as StartEncodeResponse;
            this.statusUrl = response.status_url;
            return response;
        }


    }
    * */

}
