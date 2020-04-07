package com.example.sendsay.model.action;

import lombok.Getter;
import lombok.Setter;

/**
 * Проверка состояния асинхронного запроса
 */
@Getter
@Setter
public class TrackGetAction extends Action {

    private Long id; //номер трекера

    @Override
    public String getAction() {
        return "track.get";
    }

}
