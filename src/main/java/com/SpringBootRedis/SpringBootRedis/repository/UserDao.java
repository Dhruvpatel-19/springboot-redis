package com.SpringBootRedis.SpringBootRedis.repository;

import com.SpringBootRedis.SpringBootRedis.model.User;

import java.util.List;

public interface UserDao {
    boolean saveUser(User user);

    List<User> fetchAllUsers();

    User fetchUserById(Long id);

    boolean deleteUser(Long id);
}
