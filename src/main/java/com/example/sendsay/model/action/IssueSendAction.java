package com.example.sendsay.model.action;

import com.example.sendsay.model.MailLetter;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Отправка рассылки
 */
@Getter
@Setter
public class IssueSendAction extends Action {

    /**
     * набор произвольных меток выпуска позволяющих фильтровать/классифицировать
     * от 0 до 8 строк не длиннее 128 символов
     * необязательно
     */
    private String label = "My label " + new Date();

    /**
     * параметры содержимого выпуска
     */
    private MailLetter letter = new MailLetter();

    /**
     * id группы
     */
    private String group;

    /**
     * Когда выпустить
     * (now - сейчас | later - отложенный | delay - задержаный | save - отложить на хранение | test - тестовый)
     */
    private String sendwhen = "now";

    @Override
    public String getAction() {
        return "issue.send";
    }

}
