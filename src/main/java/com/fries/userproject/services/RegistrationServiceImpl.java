package com.fries.userproject.services;

import com.fries.userproject.models.RegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Override
    public String register(RegistrationRequest request) {
        return "works";
    }
}
