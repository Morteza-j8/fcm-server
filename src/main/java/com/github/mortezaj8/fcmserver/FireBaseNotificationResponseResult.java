package com.github.mortezaj8.fcmserver;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * created by: Morteza
 * company: mobin
 * project name:  FCM Server
 * 19 March 2019
 **/


public class FireBaseNotificationResponseResult {

    @JsonProperty("message_id")
    private String messageId;

    @JsonProperty("error")
    private String error;



    public String getMessageId() {
        return messageId;
    }
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }



    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }

}
