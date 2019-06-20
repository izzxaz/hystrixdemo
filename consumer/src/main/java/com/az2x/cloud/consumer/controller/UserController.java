package com.az2x.cloud.consumer.controller;

import com.az2x.cloud.api.provider.service.UserProviderService;
import com.az2x.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserProviderService userProviderService;
    /*private RestTemplate restTemplate;
    private String remote = "http://provider";*/

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUsers() {
        return userProviderService.getUsers();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable("id") int id) {
        return userProviderService.getUserById(id);
    }

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    @ResponseBody
    public String getCheck() {
        return userProviderService.getCheck();
    }
}
