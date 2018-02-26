/**
 * Copyright (C) 2013 Brightcove Inc. All Rights Reserved. No use, copying or distribution of this
 * work may be made except in accordance with a valid license agreement from Brightcove Inc. This
 * notice must be included on all copies, modifications and derivatives of this work.
 * 
 * Brightcove Inc MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE SOFTWARE,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT. BRIGHTCOVE SHALL NOT BE
 * LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS
 * SOFTWARE OR ITS DERIVATIVES.
 * 
 * "Brightcove" is a registered trademark of Brightcove Inc.
 */
package com.qencode.api.java.client;

import com.qencode.api.java.client.classes.TranscodingTask;
import com.qencode.api.java.client.helpers.QueryStringBuilder;
import com.qencode.api.java.client.response.AccessTokenResponse;
import com.qencode.api.java.client.response.CreateTaskResponse;
import com.qencode.api.java.client.response.QencodeApiResponse;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.PropertyNamingStrategy;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import static jdk.nashorn.internal.objects.NativeString.substring;

public class QencodeApiClient {

    public static final String API_URL = "https://api.qencode.com/v1";

    private String key;
    private String url;

    private String accessToken;
    public String getAccessToken() {
        return this.accessToken;
    }

    private RestTemplate rt;

    private ObjectMapper mapper;
    public ObjectMapper getMapper() {
        return mapper;
    }

    /**
     * Constructs a new <tt>QencodeApiClient</tt>.
     *
     * @param   api_key Qencode Project API Key
     * @throws  QencodeException if there's an error communicating Qencode API or API Key is not valid
     */
    public QencodeApiClient(String api_key) throws UnsupportedEncodingException, QencodeException {
        this.key = api_key;
        this.url = API_URL;
        this.rt = new RestTemplate();
        this.mapper = createObjectMapper();
        requestAccessToken();
    }
    public QencodeApiClient(String api_key, String url) throws UnsupportedEncodingException, QencodeException {
        this.key = api_key;
        this.url = API_URL;
        if (!isEmpty(url)) {
           this.url = url;
        }
        this.rt = new RestTemplate();
        this.mapper = createObjectMapper();
        requestAccessToken();
    }

    @SuppressWarnings("deprecation")
    private ObjectMapper createObjectMapper() {
        ObjectMapper m = new ObjectMapper();
        m.configure(SerializationConfig.Feature.WRITE_NULL_PROPERTIES, false);
        m.configure(SerializationConfig.Feature.WRITE_ENUMS_USING_TO_STRING, true);
        m.configure(DeserializationConfig.Feature.READ_ENUMS_USING_TO_STRING, true);
        m.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        m.setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);
        m.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
        m.setDateFormat(df);
        return m;
    }

    /**
     * gets Qencode Project API Key for this client instance
     */
    public String getApiKey() {
        return key;
    }

    /**
     * sets Qencode Project API Key for this client instance
     */
    public void setApiKey(String api_key) {
        this.key = api_key;
    }

    /**
     * gets API endpoint url
     */
    public String getApiUrl() {
        return url;
    }

    /**
     * sets API endpoint url
     */
    public void setApiUrl(String api_url) {
        this.url = api_url;
    }

    public RestTemplate getRestTemplate() {
        return rt;
    }

    public void setRestTemplate(RestTemplate rt) {
        this.rt = rt;
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        //headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        headers.add("User-Agent", "Qencode Java API SDK 1.0");
        return headers;
    }

    private void requestAccessToken() throws QencodeException, UnsupportedEncodingException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("api_key", key);
        String responseStr = Request("access_token", params);
        try {
            AccessTokenResponse response = mapper.readValue(
                responseStr,
                AccessTokenResponse.class);
            this.accessToken = response.getToken();
        } catch (Exception e) {
            throw new QencodeException(
                "Unable to deserialize Response as JSON", e);
        }
    }

    private String lastResponseRaw;
    /**
     * returns Last Response in raw string (JSON)
     */
    public String getLastResponseRaw() {
        return this.lastResponseRaw;
    }

    /**
     * Performs request to a specified API method
     * @param path API method path, e.g. "create_task"
     * @param parameters key-value pairs specifying method params
     * @return Method Response Raw JSON string
     * @throws QencodeException if there's an error communicating Qencode API or some params not valid
     * @throws UnsupportedEncodingException
     */
    public String Request(String path, Map<String, String> parameters) throws QencodeException, UnsupportedEncodingException {
        String queryParams = QueryStringBuilder.BuildQueryString(parameters);
        return this.Request(path, queryParams);
    }

    /**
     * Performs request to a specified API method
     * @param path API method path, e.g. "create_task"
     * @param parameters an URL-encoded params string, e.g. param1=value1&param2=value2...
     * @return Method Response Raw JSON string
     * @throws QencodeException if there's an error communicating Qencode API or some params not valid
     */
    public String Request(String path, String parameters) throws QencodeException {
        lastResponseRaw = null;
        String requestUrl = null;
        if (path.toLowerCase().indexOf("http") == 0)
        {
            requestUrl = path;
        }
        else
        {
            requestUrl = this.url + "/" + trim(path, '/');
        }

        try
        {
            lastResponseRaw = HttpPost(requestUrl, parameters);
        }
        catch (Exception e)
        {
            throw new QencodeException("Error executing request to url: " + requestUrl, e);
        }

        QencodeApiResponse response = null;
        try {
            response = mapper.readValue(
                    lastResponseRaw,
                    QencodeApiResponse.class);
        } catch (Exception e) {
            throw new QencodeException(
                    "Unable to deserialize Response as JSON",
                    e);
        }
        if (response == null || response.getError() == -1)
        {
            throw new QencodeException("Invalid API response: " + lastResponseRaw);
        }
        if (response.getError() != 0)
        {
            throw new QencodeException(response.getMessage());
        }

        return lastResponseRaw;
    }

    private String HttpPost(String url, String requestBody) throws QencodeException {
        HttpHeaders headers = getHeaders();
        @SuppressWarnings("rawtypes")
        HttpEntity entity = new HttpEntity<String>(requestBody, headers);

        ResponseEntity<String> response = null;
        try {
            response = rt.exchange(
                    url,
                    HttpMethod.POST,
                    entity,
                    String.class,
                    new HashMap<String, Object>());

        } catch (HttpClientErrorException hcee) {
            throw new QencodeException(hcee.getResponseBodyAsString(), hcee);
        }
        return response.getBody();
    }

    private static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    private static String trim(String s, char c) {
        int len = s.length();
        int st = 0;
        char[] val = s.toCharArray();

        while ((st < len) && (val[st] <= c)) {
            st++;
        }
        while ((st < len) && (val[len - 1] <= c)) {
            len--;
        }
        return ((st > 0) || (len < s.length())) ? substring(st, len) : s;
    }

    /**
     * Creates new transcoding task
     * @return TranscodingTask object
     * @throws UnsupportedEncodingException
     * @throws QencodeException if there's an error communicating Qencode API or access token    not valid
     */
    public TranscodingTask CreateTask() throws UnsupportedEncodingException, QencodeException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("token", accessToken);
        String responseStr = Request("create_task", params);
        CreateTaskResponse response = null;
        try {
            response = mapper.readValue(
                    responseStr,
                    CreateTaskResponse.class);
        } catch (Exception e) {
            throw new QencodeException(
                    "Unable to deserialize CreateTaskResponse as JSON", e);
        }
        return new TranscodingTask(this, response.getTaskToken());
    }

}
