package com.example.sendsay.sendsay;

import com.example.sendsay.model.action.Action;
import com.example.sendsay.model.action.LoginAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class SendsayClient {

    private static final String BASE_URL = "https://api.sendsay.ru/general/api/v100/json/x_1586171177508746";

    private String login = "x_1586171177508746";//общий логин
    private String sablogin = "x_1586171177508746";//личный логин
    private String passwd = "ne8Nothat";//пароль

    @Autowired
    private SendsaySession sendsaySession;

    private RestTemplate restTemplate = new RestTemplate();

    private HttpHeaders headers = new HttpHeaders();

    @PostConstruct
    public void init() {
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "");
        updateHeader();
    }

    public AuthResponse auth() {
        LoginAction action = new LoginAction();
        action.setLogin(this.login);
        action.setSablogin(this.sablogin);
        action.setPasswd(this.passwd);

        HttpEntity<LoginAction> request = new HttpEntity<>(action, headers);
        ResponseEntity<AuthResponse> response
                = restTemplate.exchange(BASE_URL, HttpMethod.POST, request, AuthResponse.class);

        this.sendsaySession.setSession(response.getBody().getSession());
        this.headers.set("Authorization", "sendsay session=" + this.sendsaySession.getSession());

        return response.getBody();
    }

    public String exchange(Action action) {
        updateHeader();
        HttpEntity<Object> request = new HttpEntity<>(action, headers);
        ResponseEntity<String> response
                = restTemplate.exchange(BASE_URL, HttpMethod.POST, request, String.class);
        return response.getBody();
    }

    private void updateHeader() {
        if (!sendsaySession.isValid()) {
            auth();
        }
    }

}
