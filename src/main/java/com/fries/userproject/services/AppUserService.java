package com.fries.userproject.services;

import com.fries.userproject.models.AppUser;

public interface AppUserService{

    AppUser findUserById(Long id);
    AppUser save(AppUser appUser);
}
