package com.github.mortezaj8.fcmserver;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * created by: Morteza
 * company: mobin
 * project name:  FCM Server
 * 19 March 2019
 **/
public class FireBaseNotificationRequest {




    @JsonProperty("data")
    private FireBaseNotificationData data;


    @JsonProperty("registration_ids")
    private List<String> registrationIds;

    //title for sending same title send to client (when client offline) , just send last
    @JsonProperty("collapse_key")
    private String collapseKey;


    //second
    @JsonProperty("time_to_live")
    private long timeToLive;







    public FireBaseNotificationRequest(FireBaseNotificationData data, List<String> registrationIds) {
        this.data = data;
        this.registrationIds = registrationIds;
    }

    public FireBaseNotificationRequest(FireBaseNotificationData data, List<String> registrationIds, String collapseKey , long timeToLive) {
        this.data = data;
        this.registrationIds = registrationIds;
        this.collapseKey = collapseKey;
        this.timeToLive = timeToLive;
    }

    public FireBaseNotificationRequest(FireBaseNotificationData data, List<String> registrationIds, long timeToLive) {
        this.data = data;
        this.registrationIds = registrationIds;
        this.timeToLive = timeToLive;
    }








    public FireBaseNotificationData getData() {
        return data;
    }
    public void setData(FireBaseNotificationData data) {
        this.data = data;
    }


    public List<String> getRegistrationIds() {
        return registrationIds;
    }
    public void setRegistrationIds(List<String> registrationIds) {
        this.registrationIds = registrationIds;
    }


    public String getCollapseKey() {
        return collapseKey;
    }
    public void setCollapseKey(String collapseKey) {
        this.collapseKey = collapseKey;
    }



    public long getTimeToLive() {
        return timeToLive;
    }
    public void setTimeToLive(long timeToLive) {
        this.timeToLive = timeToLive;
    }









}
