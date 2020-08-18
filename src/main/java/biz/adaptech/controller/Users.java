package biz.adaptech.controller;

import biz.adaptech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/users")
public class Users {
    private final UserService userService;

    @Autowired
    public Users(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/token")
    public String userLogin(@RequestBody String uid) {
        return this.userService.generateToken(uid);
    }
}

