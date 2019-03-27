package com.github.mortezaj8.fcmserver;

import java.util.ArrayList;
import java.util.List;


/**
 * created by: Morteza
 * company: mobin
 * project name:  FCM Server
 * 19 March 2019
 **/
public abstract class FirebaseNotification {




    protected abstract String getFirebaseRemoteToken();





    public void sendNotification(List<String> playerIds, String type, Object payload) {


        playerIds = fetchNoneNullItems(playerIds);
        if(playerIds.isEmpty()){
            return;
        }

        FirebaseNotificationRequest request = new FirebaseNotificationRequest(new FirebaseNotificationData(type.toString() , payload) , playerIds );
        FirebaseNotificationRunnable runnable = new FirebaseNotificationRunnable( request , getFirebaseRemoteToken() );

        (new Thread(runnable)).start();

    }


    public void sendNotification(String playerId, String type, Object payload) {
        List<String> lisIds = new ArrayList<String>();
        lisIds.add(playerId);
        sendNotification(lisIds , type , payload );
    }


    protected List < String > fetchNoneNullItems(List < String > playerIds) {

        if(playerIds == null){
            return null;
        }

        List<String> ids = new ArrayList < String >(  );

        for(String e : playerIds){
            if(!isNullOrEmpty( e )){
                ids.add( e );
            }
        }
        return ids;
    }



    protected boolean isNullOrEmpty(String e) {
        return e == null || e.length() == 0;
    }





}
