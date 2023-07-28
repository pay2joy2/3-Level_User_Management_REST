package com.example.test.service;

import com.example.test.entity.User;

import java.util.List;

public interface UserService {
    List<User> fetchUserList();
    User addUser(User user);
    User getId(int id);
    void DeleteId(int id);
}
