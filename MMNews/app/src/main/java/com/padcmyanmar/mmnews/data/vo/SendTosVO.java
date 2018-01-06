package com.padcmyanmar.mmnews.data.vo;

/**
 * Created by Ag Phone Khant on 17/12/2017.
 */

public class SendTosVO {
    private String sentToId;
    private String sentDate;
    private ActedUserVO actedUser;
    private ActedUserVO recivedUser;

    public String getSentToId() {
        return sentToId;
    }

    public String getSentDate() {
        return sentDate;
    }

    public ActedUserVO getActedUser() {
        return actedUser;
    }

    public ActedUserVO getRecivedUser() {
        return recivedUser;
    }
}
