package com.mmelnychuk.bootapp.testsapp.dto.create;

import com.mmelnychuk.bootapp.testsapp.dto.DTO;

public class SignInUserDTO implements DTO {

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
