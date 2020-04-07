package com.example.sendsay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MailLetter {

    /**
     * Тема письма
     * -- обязательно не пусто
     */
    private String subject = "My Title";

    /**
     * Имя отправителя
     */
    @JsonProperty("from.name")
    private String fromName = "Alexander";

    /**
     * Адрес отправителя (email)
     */
    @JsonProperty("from.email")
    private String fromEmail = "A.Surakin@alfacapital.ru";

    /**
     * Сообщение
     */
    private Message message;

}
