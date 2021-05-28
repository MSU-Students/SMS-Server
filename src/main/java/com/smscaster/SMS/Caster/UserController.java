package com.smscaster.SMS.Caster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserDaoService userService;
    
    @GetMapping("/user")                                    
    public User[] findAll() {
        User firstUser = new User();
        firstUser.setName("MOSSEM");
        firstUser.setContact("09123456789");
        User[] users = {firstUser, firstUser};
        return users;
    }
    @GetMapping("/user/{id}")
    public User findOne(@PathVariable(name = "id") String name) {
        return userService.findOne(name);
    }
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User[] createUser(@RequestBody User user) {
        User[] users = {user};
        return users;
    }
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public User update(@RequestBody User user, @PathVariable("id") String id) {
        user.setContact("1234");
        return user;
    }
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public User[] delete(@PathVariable("id") String id) {
        User[] users = {};
        System.out.print("Deleting...." + id);
        return users;
    }
}
