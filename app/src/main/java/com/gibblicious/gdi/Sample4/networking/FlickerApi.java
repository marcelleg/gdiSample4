package com.gibblicious.gdi.Sample4.networking;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.Call;
import retrofit2.http.QueryMap;

public interface FlickerApi {
    @GET("rest")
    Call<PhotoResponse> getPhotos(@QueryMap Map<String, String> query);
}
