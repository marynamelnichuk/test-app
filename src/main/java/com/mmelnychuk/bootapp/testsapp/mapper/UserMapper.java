package com.mmelnychuk.bootapp.testsapp.mapper;

import com.mmelnychuk.bootapp.testsapp.dto.read.UserDTO;
import com.mmelnychuk.bootapp.testsapp.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper{

    public User mapUser(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setLastName(userDTO.getLastName());
        user.setFirstName(userDTO.getFirstName());
        return user;
    }

    public UserDTO mapToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setLastName(user.getLastName());
        userDTO.setFirstName(user.getFirstName());
        return userDTO;
    }
}
