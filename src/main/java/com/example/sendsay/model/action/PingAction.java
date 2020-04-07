package com.example.sendsay.model.action;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PingAction extends Action {

    @Override
    public String getAction() {
        return "ping";
    }

    @JsonIgnore
    @Override
    public Boolean isNeedAuth() {
        return false;
    }

}
