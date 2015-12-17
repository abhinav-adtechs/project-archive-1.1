package com.archive.jordiie.onboardingscreen;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by jordiie on 15/12/15.
 */
public interface APIsetup {

    @GET("/api/v2/system")
    void system(Callback<SystemResponse> callback);

    @FormUrlEncoded
    @POST("/api/v2/{campus}/login")
    void login(@Path("campus") String campus, @Field("regno") String regno, @Field("dob") String dob, @Field("mobile") String mobile, Callback<LoginResponse> callback);

    @FormUrlEncoded
    @POST("/api/v2/{campus}/refresh")
    void refresh(@Path("campus") String campus, @Field("regno") String regno, @Field("dob") String dob, @Field("mobile") String mobile, Callback<RefreshResponse> callback);

}
