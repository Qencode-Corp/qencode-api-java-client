package com.qencode.api.java.client.classes.CustomParams;

public class Destination {
    /**
     * Destination bucket url, e.g. s3://example.com/bucket
     */
    private String url;

    /**
     * Access key
     */
    private String key;

    /**
     * Access secret
     */
    private String secret;

    /**
     * {@link Destination#url}
     */
    public String getUrl() {
        return url;
    }

    /**
     * {@link Destination#url}
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * {@link Destination#key}
     */
    public String getKey() {
        return key;
    }

    /**
     * {@link Destination#key}
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * {@link Destination#secret}
     */
    public String getSecret() {
        return secret;
    }

    /**
     * {@link Destination#secret}
     */
    public void setSecret(String secret) {
        this.secret = secret;
    }
}