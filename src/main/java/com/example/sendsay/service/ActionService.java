package com.example.sendsay.service;

import com.example.sendsay.model.action.Action;
import com.example.sendsay.sendsay.SendsayClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionService {

    @Autowired
    private SendsayClient client;

    public String sendToSendsay(Action action) {
        return this.client.exchange(action);
    }

}
