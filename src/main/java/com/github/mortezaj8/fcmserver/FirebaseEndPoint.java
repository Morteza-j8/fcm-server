package com.github.mortezaj8.fcmserver;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * created by: Morteza
 * company: mobin
 * project name:  FCM Server
 * 19 March 2019
 **/
public interface FirebaseEndPoint {


    @Headers({
            "Content-Type: application/json" ,
            "Authorization:key=" + FireBaseNotification.CUSTOMER_SERVER_KEY ,

    })
    @POST("send")
    Call<FireBaseNotificationResponse> sendCustomerNotification(
            @Body FireBaseNotificationRequest request
    );





}
