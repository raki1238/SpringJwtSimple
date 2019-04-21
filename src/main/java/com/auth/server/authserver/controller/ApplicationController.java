package com.auth.server.authserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secured/app")
public class ApplicationController {

    @GetMapping
    public String verifyApplicationaccess(){
        return "Access Granted !!";
    }
}
