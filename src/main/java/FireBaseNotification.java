
import java.util.ArrayList;
import java.util.List;


/**
 * created by: Morteza
 * company: mobin
 * project name:  FCM Server
 * 19 March 2019
 **/
public class FireBaseNotification {


    protected static final String CUSTOMER_SERVER_KEY =
            "";









    protected void sendNotification(List<String> playerIds, String type, Object payload) {


        playerIds = fetchNoneNullItems(playerIds);
        if(playerIds.isEmpty()){
            return;
        }

        FireBaseNotificationRequest request = new FireBaseNotificationRequest(new FireBaseNotificationData(type.toString() , payload) , playerIds );
        FireBaseNotificationRunnable runnable = new FireBaseNotificationRunnable( request );

        (new Thread(runnable)).start();

    }

    protected void sendNotification(String playerId, String type, Object payload) {
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
