package com.SpringBootRedis.SpringBootRedis.service;

import com.SpringBootRedis.SpringBootRedis.model.User;

import java.util.List;

public interface UserService {
    boolean saveUser(User user);

    List<User> fetchAllUsers();


    User fetchUserById(Long id);

    boolean deleteUser(Long id);
}
