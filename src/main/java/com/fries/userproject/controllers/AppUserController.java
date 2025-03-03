package com.fries.userproject.controllers;

import com.fries.userproject.models.AppUser;
import com.fries.userproject.services.AppUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AppUserController {


    private final AppUserService AppUserService;


    public AppUserController (AppUserService service){
        this.AppUserService = service;
    }

    @PostMapping("users/{id}")
    public ResponseEntity<AppUser> getUserById(@RequestParam("id") Long id) {
        return ResponseEntity.ok().body(AppUserService.getUserById(id));
    }

}
