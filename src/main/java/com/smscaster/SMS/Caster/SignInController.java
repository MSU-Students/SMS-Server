package com.smscaster.SMS.Caster;

import org.springframework.beans.factory.annotation.Autowired;

public class SignInController {
    @Autowired
    private UserDaoService daoService;
    
    public void Login(String username, String password) {
        User user = daoService.findOne(username);
        if (user.getContact().equals(password)) {
            
        }
    }
}
