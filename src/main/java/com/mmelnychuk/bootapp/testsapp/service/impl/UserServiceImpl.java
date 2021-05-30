package com.mmelnychuk.bootapp.testsapp.service.impl;

import com.mmelnychuk.bootapp.testsapp.dto.read.UserDTO;
import com.mmelnychuk.bootapp.testsapp.exceptions.NotFoundException;
import com.mmelnychuk.bootapp.testsapp.mapper.UserMapper;
import com.mmelnychuk.bootapp.testsapp.model.User;
import com.mmelnychuk.bootapp.testsapp.repository.UserRepository;
import com.mmelnychuk.bootapp.testsapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO saveUser(UserDTO dto) {
        User user = userMapper.mapUser(dto);
        User savedUser = userRepository.save(user);
        return userMapper.mapToDto(savedUser);
    }

    @Override
    public UserDTO getUserByEmailAndPassword(String email, String password) throws NotFoundException {
        User user = userRepository.findByEmailAndPassword(email, password).orElseThrow(
                () -> new NotFoundException("User not found"));
        return userMapper.mapToDto(user);
    }

    @Override
    public User getUserByEmail(String email) throws NotFoundException {
        return userRepository.findByEmail(email).orElseThrow(
                () -> new NotFoundException("User not found"));
    }
}
