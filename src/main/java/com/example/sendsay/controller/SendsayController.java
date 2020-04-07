package com.example.sendsay.controller;

import com.example.sendsay.sendsay.AuthResponse;
import com.example.sendsay.sendsay.SendsayClient;
import com.example.sendsay.sendsay.SendsaySession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Общие методы работы с sendsay
 */
@RestController
@RequestMapping("api/v1/sendsay")
public class SendsayController {

    @Autowired
    private SendsaySession sendsaySession;

    @Autowired
    private SendsayClient sendsayClient;

    /**
     * Информация о сессии
     */
    @GetMapping("/session")
    public SendsaySession session() {
        return this.sendsaySession;
    }

    /**
     * Получить новую сессию
     */
    @GetMapping("/login")
    public AuthResponse login() {
        return this.sendsayClient.auth();
    }

}
