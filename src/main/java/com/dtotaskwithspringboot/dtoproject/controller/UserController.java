package com.dtotaskwithspringboot.dtoproject.controller;

import com.dtotaskwithspringboot.dtoproject.dto.UserLocationDto;
import com.dtotaskwithspringboot.dtoproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users-location")
    public List<UserLocationDto> getAllUsersLocation() {
        return userService.getAllUsersLocation();
    }
}
