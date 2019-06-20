package com.az2x.cloud.provider.dao;

import com.az2x.cloud.entity.User;

import java.util.List;

public interface UserDao {

    public User getUserById(int id);

    public List<User> getUsers();

}
