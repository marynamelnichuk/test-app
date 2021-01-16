package com.mmelnychuk.bootapp.testsapp.service;

import com.mmelnychuk.bootapp.testsapp.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void saveUser(User user);

}
