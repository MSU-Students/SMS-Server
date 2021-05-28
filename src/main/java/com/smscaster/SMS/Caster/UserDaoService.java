package com.smscaster.SMS.Caster;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
    public User findOne(String name) {
        User firstUser = new User();
        firstUser.setName(name);
        firstUser.setContact("09123456789");
        return firstUser;
        
    }
}
