package com.gibblicious.gdi.Sample4.networking;

import com.google.gson.annotations.SerializedName;

public class Photo {

    @SerializedName("id")
    private String id;

    @SerializedName("owner")
    private String owner;

    @SerializedName("secret")
    private String secret;

    @SerializedName("server")
    private String server;

    @SerializedName("farm")
    private Integer farm;

    @SerializedName("title")
    private String title;

    @SerializedName("ispublic")
    private Integer ispublic;

    @SerializedName("isfriend")
    private Integer isfriend;

    @SerializedName("isfamily")
    private Integer isfamily;

    @SerializedName("url_m")
    private String urlM;

    @SerializedName("height_m")
    private String heightM;

    @SerializedName("width_m")
    private String widthM;

    public Integer getFarm() {
        return farm;
    }

    public String getServer() {
        return server;
    }

    public String getId() {
        return id;
    }

    public String getSecret() {
        return secret;
    }

}
