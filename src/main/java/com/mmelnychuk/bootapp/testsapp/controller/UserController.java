package com.mmelnychuk.bootapp.testsapp.controller;

import com.mmelnychuk.bootapp.testsapp.dto.create.SignInUserDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.UserDTO;
import com.mmelnychuk.bootapp.testsapp.mapper.UserMapper;
import com.mmelnychuk.bootapp.testsapp.model.User;
import com.mmelnychuk.bootapp.testsapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;
  //  private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
        //this.userMapper = userMapper;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Collection<User>> getUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping(value = "signUp", produces = "application/json")
    public ResponseEntity<UserDTO> signUpUser(@RequestBody UserDTO user) {
       // userService.saveUser(userMapper.mapUser(user));
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping(value = "/signIn", produces = "application/json")
    public ResponseEntity<UserDTO> signInUser(@RequestBody SignInUserDTO userDTO) {
        try {
            UserDTO user = userService.getUserByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword());
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Throwable throwable) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
