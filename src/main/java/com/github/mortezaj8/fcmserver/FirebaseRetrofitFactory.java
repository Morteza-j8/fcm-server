package com.github.mortezaj8.fcmserver;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * created by: Morteza
 * company: mobin
 * project name:  FCM Server
 * 19 March 2019
 **/

public class FirebaseRetrofitFactory {
    private static final FirebaseRetrofitFactory INSTANCE = new FirebaseRetrofitFactory();
    private Retrofit retrofit;

    private FirebaseRetrofitFactory(){

    }

    public static FirebaseRetrofitFactory getInstance() {
        return INSTANCE;
    }

    public FirebaseEndPoint getFirebaseEndPoint(){
        if (retrofit == null) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://fcm.googleapis.com/fcm/")
                    .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                    .build();
        }

        return retrofit.create(FirebaseEndPoint.class);
    }
}
