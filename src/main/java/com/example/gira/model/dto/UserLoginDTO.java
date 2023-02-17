package com.example.gira.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserLoginDTO {
    private long id;

    @NotBlank
    @Size(min = 3,max = 20,message = "Email length must be between 3 and 20 characters!")
    @Email(message = "Invalid email!")
    private String email;

    @NotBlank
    @Size(min = 3,max = 20,message = "Password length must be between 3 and 20 characters!")
    private String password;

    public UserLoginDTO() {
    }

    public long getId() {
        return id;
    }

    public UserLoginDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return email;
    }

    public UserLoginDTO setUsername(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
