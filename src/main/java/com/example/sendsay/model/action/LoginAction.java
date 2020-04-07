package com.example.sendsay.model.action;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

/**
 * Авторизация по логину и паролю
 */
@Getter
@Setter
public class LoginAction extends Action {
    private String login = "x_1586171177508746";//общий логин
    private String sablogin = "x_1586171177508746";//личный логин
    private String passwd = "ne8Nothat";//пароль

    @Override
    public String getAction() {
        return "login";
    }

    @JsonIgnore
    @Override
    public Boolean isNeedAuth() {
        return false;
    }

}
