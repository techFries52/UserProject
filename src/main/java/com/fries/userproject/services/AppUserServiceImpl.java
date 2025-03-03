package com.fries.userproject.services;

import com.fries.userproject.models.AppUser;
import com.fries.userproject.repos.AppUserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService, UserDetailsService {

    private final AppUserRepo appUserRepo;
    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";

    public AppUserServiceImpl(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    @Override
    public AppUser getUserById(Long id) {
        return appUserRepo.findUserById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepo.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }
}
