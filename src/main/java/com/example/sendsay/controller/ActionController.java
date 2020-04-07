package com.example.sendsay.controller;

import com.example.sendsay.model.action.PingAction;
import com.example.sendsay.model.action.PongAction;
import com.example.sendsay.model.action.TrackGetAction;
import com.example.sendsay.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * API вызова команд
 */
@RestController
@RequestMapping("api/v1/action")
public class ActionController {

    @Autowired
    private ActionService service;

    /**
     * ping, не требующий авторизацию
     */
    @GetMapping("/ping")
    public Object ping() {
        PingAction action = new PingAction();
        return this.service.sendToSendsay(action);
    }

    /**
     * ping, требующий авторизацию
     */
    @GetMapping("/pong")
    public Object pong() {
        PongAction action = new PongAction();
        return this.service.sendToSendsay(action);
    }

    /**
     * Статус рассылки
     *
     * @param id идентификатор рассылки
     */
    @GetMapping("/trackGet")
    public Object trackGet(@RequestParam Long id) {
        TrackGetAction action = new TrackGetAction();
        action.setId(id);
        return this.service.sendToSendsay(action);
    }

}
