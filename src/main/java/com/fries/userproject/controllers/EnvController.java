package com.fries.userproject.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvController {


    private final Environment env;

    public EnvController(Environment env) {
        this.env = env;
    }

    @GetMapping("/db_user")
    public String getDbUser() {
        return env.getProperty("USER_PROJECT.DB.USER");
    }

    @GetMapping("/db_pass")
    public String getDbPass() {
        return env.getProperty("USER_PROJECT.DB.PASSWRD");
    }
}
