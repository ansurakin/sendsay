package com.example.sendsay.sendsay;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import java.time.Duration;
import java.util.Date;

@JsonSerialize(as = SendsaySession.class)
@Data
@Component
@ApplicationScope
public class SendsaySession {
    private static final long DEFAULT_DURATION_HOUR = 1;//время существования сессии, ч.

    private String session;//id сессии
    private Date dateBegin;//дата начала сессии
    private Date dateExpired;//дата окончания сессии

    public void setSession(String session) {
        this.session = session;
        Date now = new Date();
        this.dateBegin = now;
        this.dateExpired = Date.from(now.toInstant().plus(Duration.ofHours(DEFAULT_DURATION_HOUR)));
    }

    /**
     * Актуальна ли сессия
     */
    public Boolean isValid() {
        if (dateExpired == null) {
            return false;
        }
        return dateExpired.after(new Date());
    }
}
