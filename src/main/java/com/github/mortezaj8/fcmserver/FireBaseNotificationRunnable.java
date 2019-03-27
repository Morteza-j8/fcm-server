package com.github.mortezaj8.fcmserver;

import retrofit2.Call;
import retrofit2.Response;

/**
 * created by: Morteza
 * company: mobin
 * project name:  FCM Server
 * 19 March 2019
 **/
public class FireBaseNotificationRunnable implements Runnable {



    private FireBaseNotificationRequest notificationRequest;

    public FireBaseNotificationRunnable(FireBaseNotificationRequest nofiticationRequest) {
        this.notificationRequest = nofiticationRequest;

    }

    public void run() {


        try {
            Call<FireBaseNotificationResponse> caller =
                    FirebaseRetrofitFactory.getInstance().getFirebaseEndPoint().sendCustomerNotification(notificationRequest);

            Response<FireBaseNotificationResponse> responseBody =
                    caller.execute();

            if(responseBody.isSuccessful()){
                FireBaseNotificationResponse response = responseBody.body();
                showLog(response, notificationRequest);

            }else{
                System.out.println( "Firebase Error Http Code: " + responseBody.code() );
            }

        }catch (Exception e){

        }



    }

    private static void showLog(FireBaseNotificationResponse response , FireBaseNotificationRequest request){
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