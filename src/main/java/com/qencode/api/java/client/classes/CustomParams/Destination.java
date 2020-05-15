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
     * Permissions, e.g. 'public-read'
     */
    private String permissions;

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

    /**
     * {@link Destination#permissions}
     */
    public String getPermissions() {
        return permissions;
    }

    /**
     * {@link Destination#permissions}
     */
    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }


}
