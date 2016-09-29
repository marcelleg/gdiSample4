package com.gibblicious.gdi.Sample4.networking;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class Photos {

    @SerializedName("page")
    private Integer page;

    @SerializedName("pages")
    private String pages;

    @SerializedName("perpage")
    private Integer perpage;

    @SerializedName("total")
    private String total;

    @SerializedName("photo")
    private List<Photo> photo = new ArrayList<>();

    public List<Photo> getPhoto() {
        return photo;
    }

}
