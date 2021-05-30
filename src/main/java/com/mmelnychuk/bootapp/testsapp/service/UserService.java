package com.mmelnychuk.bootapp.testsapp.service;

import com.mmelnychuk.bootapp.testsapp.dto.read.UserDTO;
import com.mmelnychuk.bootapp.testsapp.exceptions.NotFoundException;
import com.mmelnychuk.bootapp.testsapp.model.User;

public interface UserService {

    UserDTO saveUser(UserDTO user);

    UserDTO getUserByEmailAndPassword(String email, String password) throws Throwable;

    User getUserByEmail(String email) throws NotFoundException;
}
