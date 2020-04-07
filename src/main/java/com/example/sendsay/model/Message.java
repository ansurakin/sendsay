package com.example.sendsay.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Сообщение рассылки
 */
@Getter
@Setter
public class Message {
    private String html;//html-версия письма
    private String text;//текстовая версия письма
}
