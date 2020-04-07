package com.example.sendsay.controller;

import com.example.sendsay.model.Message;
import com.example.sendsay.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/send")
public class SendController {

    @Autowired
    private SendService service;

    @PostMapping
    public String send(@RequestBody Message message){
        return this.service.send(message);
    }

}
