package com.github.mortezaj8.fcmserver;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * created by: Morteza
 * company: mobin
 * project name:  FCM Server
 * 19 March 2019
 **/
public class FireBaseNotificationResponse {

    //json format response
    /*
    { "multicast_id": 108,
      "success": 1,
      "failure": 0,
      "canonical_ids": 0,
      "results": [
        { "message_id": "1:0408" },
        { "error": "Unavailable" },
        { "error": "InvalidRegistration" },
        { "message_id": "1:1516" },
        { "message_id": "1:2342", "registration_id": "32" },
        { "error": "NotRegistered"}
      ]

    }
     */
    @JsonProperty("multicast_id")
    private long multicastId;
    @JsonProperty("success")
    private long success;
    @JsonProperty("failure")
    private long failure;
    @JsonProperty("canonical_ids")
    private long canonicalIds;
    @JsonProperty("results")
    private List<FireBaseNotificationResponseResult> results;



    public long getMulticastId() {
        return multicastId;
    }
    public void setMulticastId(long multicastId) {
        this.multicastId = multicastId;
    }



    public long getSuccess() {
        return success;
    }
    public void setSuccess(long success) {
        this.success = success;
    }



    public long getFailure() {
        return failure;
    }
    public void setFailure(long failure) {
        this.failure = failure;
    }




    public long getCanonicalIds() {
        return canonicalIds;
    }
    public void setCanonicalIds(long canonicalIds) {
        this.canonicalIds = canonicalIds;
    }


    public List<FireBaseNotificationResponseResult> getResults() {
        return results;
    }
    public void setResults(List<FireBaseNotificationResponseResult> results) {
        this.results = results;
    }
}

