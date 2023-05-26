package dev.yuri.dio.spring.security.jwt.controller;

import dev.yuri.dio.spring.security.jwt.model.User;
import dev.yuri.dio.spring.security.jwt.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void postUser(@RequestBody User user) {
        userService.createUser(user);
    }
}
