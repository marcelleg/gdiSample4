package com.gibblicious.gdi.Sample4.networking;

import com.google.gson.annotations.SerializedName;

public class PhotoResponse {

    @SerializedName("photos")
    private Photos photos;

    public Photos getPhotos() {
        return photos;
    }

}
