package com.keepzing.security.controller;

import com.keepzing.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    @Secured("ROLE_ADMIN")
    public String hello(){
       return "hello, spring security!";
    }
}
