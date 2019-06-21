package com.az2x.cloud.api.provider.service.factory;

import com.az2x.cloud.api.provider.service.UserProviderService;
import com.az2x.cloud.entity.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserProviderFallbackFactory implements FallbackFactory<UserProviderService> {

    @Override
    public UserProviderService create(Throwable throwable) {
        return new UserProviderService() {
            @Override
            public List<User> getUsers() {
                List<User> list = new ArrayList<>();
                User tmp = new User();
                tmp.setId(1);
                tmp.setUsername("拉取信息失败");
                tmp.setPassword("error");
                list.add(tmp);
                return list;
            }

            @Override
            public User getUserById(int id) {
                User tmp = new User();
                tmp.setId(1);
                tmp.setUsername("拉取信息失败");
                tmp.setPassword("error");
                return tmp;
            }

            @Override
            public String getCheck() {
                return "服务器繁忙";
            }
        };
    }
}
