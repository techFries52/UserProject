package com.fries.userproject.controllers;

import com.fries.userproject.models.AppUser;
import com.fries.userproject.models.AppUserPrincipal;
import com.fries.userproject.services.AppUserService;
import com.fries.userproject.services.AppUserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AppUserController {


    private final AppUserServiceImpl AppUserService;


    public AppUserController (AppUserServiceImpl service){
        this.AppUserService = service;
    }

    @GetMapping("/")
    public String greet(){
        return "hallo";
    }

    @GetMapping("/{username}")
    public ResponseEntity<AppUserPrincipal> findUserByUsername(@RequestParam("username") String username){
        return ResponseEntity.ok().body(AppUserService.loadUserByUsername(username));
    }

    @PostMapping("/register")
    public ResponseEntity<AppUser> addAppUser(@RequestBody AppUser appUser) {
        return ResponseEntity.ok().body(AppUserService.save(appUser));
    }

}
