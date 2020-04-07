package com.example.sendsay.auth;

import com.example.sendsay.client.SendsayClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthInfo authInfo;

    public String getSession(){
        return authInfo.getSession();
    }

}
