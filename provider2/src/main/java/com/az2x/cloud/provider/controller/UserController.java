package com.az2x.cloud.provider.controller;


import com.az2x.cloud.entity.User;
import com.az2x.cloud.provider.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") int id) {
        return userDao.getUserById(id);
    }

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public String getCheck() {
        return "provider2";
    }


}
