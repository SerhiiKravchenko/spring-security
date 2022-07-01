package com.epam.springsecurity.controllers;

import com.epam.springsecurity.models.User;
import com.epam.springsecurity.repositories.UserRepository;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    UserRepository userRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/info")
    @PreAuthorize("hasRole('ROLE_VIEW_INFO')")
    public String getInfo() {
        return "MVC application";
    }

    @GetMapping("/about")
    public String getAbout() {
        return "This is about MVC application";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_VIEW_ADMIN')")
    public String getAdmin() {
        return "This is admin page of MVC application";
    }

    @GetMapping("/blocked")
    public List<User> getBlockedUsers() {
        return userRepository.findByIsNonLockedFalse();
    }
}
