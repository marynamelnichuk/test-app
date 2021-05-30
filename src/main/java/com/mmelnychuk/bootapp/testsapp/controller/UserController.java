package com.mmelnychuk.bootapp.testsapp.controller;

import com.mmelnychuk.bootapp.testsapp.dto.create.SignInUserDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.UserDTO;
import com.mmelnychuk.bootapp.testsapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "signUp", produces = "application/json")
    public ResponseEntity<UserDTO> signUpUser(@RequestBody UserDTO user) {
        UserDTO savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping(value = "signIn", produces = "application/json")
    public ResponseEntity<UserDTO> signInUser(@RequestBody SignInUserDTO userDTO) {
        try {
            UserDTO user = userService.getUserByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword());
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Throwable throwable) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
