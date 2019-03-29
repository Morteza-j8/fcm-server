package com.github.mortezaj8.fcmserver;

import retrofit2.Call;
import retrofit2.Response;

/**
 * created by: Morteza
 * company: mobin
 * project name:  FCM Server
 * 19 March 2019
 **/
public class FirebaseNotificationRunnable implements Runnable {



    private final FirebaseNotificationRequest notificationRequest;

    private final String firebaseServerToken;


    public FirebaseNotificationRunnable(FirebaseNotificationRequest notificationRequest, String firebaseServerToken) {
        this.notificationRequest = notificationRequest;
        this.firebaseServerToken = "key=" + firebaseServerToken;

    }

    public void run() {


        try {
            Call<FirebaseNotificationResponse> caller =
                    FirebaseRetrofitFactory.getInstance().getFirebaseEndPoint().sendCustomerNotification(
                            firebaseServerToken,
                            "application/json",
                            notificationRequest

                    );

            Response<FirebaseNotificationResponse> responseBody =
                    caller.execute();

            if(responseBody.isSuccessful()){
                FirebaseNotificationResponse response = responseBody.body();
                showLog(response, notificationRequest);

            }else{
                System.out.println( "Firebase Error Http Code: " + responseBody.code() );
            }

        }catch (Exception e){
            e.printStackTrace();
        }



    }



    private static void showLog(FirebaseNotificationResponse response , FirebaseNotificationRequest request){
        StringBuilder builder = new StringBuilder();
        builder.append("\n+-------------------------------------------------------+\n");
        builder.append(String.format("|      success: %20d                    |\n",response.getSuccess()));
        builder.append("|                                                       |\n");
        builder.append(String.format("|      failure: %20d                    |\n",response.getFailure()));
        builder.append("|                                                       |\n");
        builder.append(String.format("|      type   : %25s               |\n",request.getData().getType()));
        builder.append("+-------------------------------------------------------+\n");

        builder.append("notification send to registered Ids: ");
        for(String reg : request.getRegistrationIds()){
            builder.append(String.format("\n\t%s",reg));
        }
        builder.append("\n\n");

        System.out.println(builder.toString());


    }
}