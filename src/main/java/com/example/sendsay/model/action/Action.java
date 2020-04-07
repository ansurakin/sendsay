package com.example.sendsay.model.action;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Базовый класс описания команды для вызова API sendsay.
 */
@JsonPropertyOrder({"action"})
public abstract class Action {

    /**
     * Идентификатор команды
     */
    public abstract String getAction();

    /**
     * Нужна ли авторизация для данной команды
     */
    @JsonIgnore
    public Boolean isNeedAuth() {
        return true;
    }

}
