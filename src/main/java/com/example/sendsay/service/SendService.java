package com.example.sendsay.service;

import com.example.sendsay.client.SendsayClient;
import com.example.sendsay.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendService {

    @Autowired
    private SendsayClient client;

    public String send(Message message) {
        return client.exchange(message);
    }
}
