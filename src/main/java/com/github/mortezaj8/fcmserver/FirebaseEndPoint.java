package com.github.mortezaj8.fcmserver;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * created by: Morteza
 * company: mobin
 * project name:  FCM Server
 * 19 March 2019
 **/
public interface FirebaseEndPoint {



    @POST("send")
    Call<FirebaseNotificationResponse> sendCustomerNotification(
            @Header( "Authorization" ) String serverKet,
            @Header( "Content-Type" ) String headerTwo,
            @Body FirebaseNotificationRequest request
    );





}
