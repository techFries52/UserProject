package com.fries.userproject.controllers;

import com.fries.userproject.models.RegistrationRequest;
import com.fries.userproject.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
@AllArgsConstructor
public class RegistratonController {

    private RegistrationService registrationService;

    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }
}
