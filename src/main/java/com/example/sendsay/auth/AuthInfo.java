package com.example.sendsay.auth;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import java.time.Duration;
import java.util.Date;

@Data
@Component
@ApplicationScope
public class AuthInfo {

    private String session;

    private Date dateValidUntil;

    public void setSession(String session) {
        this.session = session;
        this.dateValidUntil = Date.from(new Date().toInstant().plus(Duration.ofHours(1)));
    }

    public Boolean isValid(){
        if (dateValidUntil == null){
            return false;
        }
        return dateValidUntil.after(new Date());
    }
}
