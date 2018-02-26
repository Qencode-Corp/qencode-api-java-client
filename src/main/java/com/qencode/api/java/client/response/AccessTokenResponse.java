package com.qencode.api.java.client.response;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Date;

public class AccessTokenResponse extends QencodeApiResponse {
    private String token;
    
    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
    }

    private Date expire;

    @JsonProperty("expire")
    public Date getExpire() {
        return expire;
    }

    @JsonProperty("expire")
    public void setExpire(Date expire) {
        this.expire = expire;
    }
}
