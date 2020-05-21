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


    private String bucket;
    @JsonProperty("bucket")
    public String getBucket() {
        return bucket;
    }
    @JsonProperty("bucket")
    public void setBucket(String bucket) {
        this.bucket = bucket;
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


    private String key;
    @JsonProperty("key")
    public String getkey() {
        return key;
    }
    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    private String scheme;
    @JsonProperty("scheme")
    public String getScheme() {
        return scheme;
    }
    @JsonProperty("scheme")
    public void setScheme(String scheme) {
        this.scheme = scheme;
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


    private int port;
    @JsonProperty("port")
    public int getPort() {
        return port;
    }
    @JsonProperty("port")
    public void setPort(int port) {
        this.port = port;
    }

    
}
