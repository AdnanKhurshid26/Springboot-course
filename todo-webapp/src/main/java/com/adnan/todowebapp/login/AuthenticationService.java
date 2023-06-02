package com.adnan.todowebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String name,String password) {
        return name.equalsIgnoreCase("adnan") && password.equalsIgnoreCase("adnan");
    }
}
