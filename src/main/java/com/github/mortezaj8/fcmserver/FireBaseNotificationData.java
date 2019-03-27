package com.github.mortezaj8.fcmserver;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * created by: Morteza
 * company: mobin
 * project name:  FCM Server
 * 19 March 2019
 **/
public class FireBaseNotificationData {

    @JsonProperty("type")
    private String type;

    @JsonProperty("content")
    private String content;

    @JsonProperty("additional_data")
    private String additionalData;



    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }



    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }



    public String getAdditionalData() {
        return additionalData;
    }
    public void setAdditionalData(String additionalData) {
        this.additionalData = additionalData;
    }




    public FireBaseNotificationData(String type, Object content) {
        this.type = type;
        try {
            this.content = (new ObjectMapper()).writeValueAsString(content).replaceAll("\"" , "\\\"");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


}