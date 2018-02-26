package com.qencode.api.java.client.classes;

import org.codehaus.jackson.annotate.JsonProperty;

public class StorageInfo {
    private String format;
    @JsonProperty("format")
    public String getFormat() {
        return format;
    }
    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    private String host;
    @JsonProperty("host")
    public String getHost() {
        return host;
    }
    @JsonProperty("host")
    public void setHost(String host) {
        this.host = host;
    }

    private String path;
    @JsonProperty("path")
    public String getPath() {
        return path;
    }
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    private String type;
    @JsonProperty("type")
    public String getType() {
        return type;
    }
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }
}
