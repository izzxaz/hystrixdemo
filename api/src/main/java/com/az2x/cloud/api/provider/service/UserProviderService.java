package com.az2x.cloud.api.provider.service;

import com.az2x.cloud.api.provider.service.factory.UserProviderFallbackFactory;
import com.az2x.cloud.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//与provider中的spring.application.name保持一致
@FeignClient(value = "provider", fallbackFactory = UserProviderFallbackFactory.class)
public interface UserProviderService {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> getUsers();

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") int id);

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public String getCheck();

}
