package com.example.sendsay.client;

import com.example.sendsay.auth.AuthInfo;
import com.example.sendsay.auth.AuthRequest;
import com.example.sendsay.auth.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class SendsayClient {

    @Autowired
    private AuthInfo authInfo;

    private static final String BASE_URL = "https://api.sendsay.ru/general/api/v100/json/x_1586171177508746";

    private RestTemplate restTemplate;

    private HttpHeaders headers;

    public SendsayClient() {
        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
    }

    @PostConstruct
    public void init(){
        setAuthInfo();
        headers.add("Authorization", "sendsay session=" + authInfo.getSession());
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    }

    private void setAuthInfo() {
        if (!authInfo.isValid()){
            this.authInfo.setSession(auth().getSession());
        }
    }

    public AuthResponse auth() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<AuthRequest> request = new HttpEntity<>(getAuthRequest(), headers);
        ResponseEntity<AuthResponse> response
                = restTemplate.exchange(BASE_URL, HttpMethod.POST, request, AuthResponse.class);
        return response.getBody();
    }

    public String exchange(Object body) {
        setAuthInfo();
        HttpEntity<Object> request = new HttpEntity<>(body, headers);
        ResponseEntity<String> response
                = restTemplate.exchange(BASE_URL, HttpMethod.POST, request, String.class);
        return response.getBody();
    }

    private AuthRequest getAuthRequest(){
        return new AuthRequest("x_1586171177508746", "x_1586171177508746", "ne8Nothat");
    }

}
