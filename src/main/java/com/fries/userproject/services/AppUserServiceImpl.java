package com.fries.userproject.services;

import com.fries.userproject.models.AppUser;
import com.fries.userproject.models.AppUserPrincipal;
import com.fries.userproject.models.AppUserRole;
import com.fries.userproject.repos.AppUserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService, UserDetailsService {

    private final AppUserRepo appUserRepo;
    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);


    public AppUserServiceImpl(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }



    @Override
    public AppUser save(AppUser appUser) {
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        return appUserRepo.save(appUser);
    }

    @Override
    public AppUser findUserById(Long id) {
        return appUserRepo.findUserById(id);
    }

    @Override
    public AppUserPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser appUser = appUserRepo.findUserByUsername(username);
        AppUserPrincipal appUserPrincipal = new AppUserPrincipal(appUser);

        if(appUser != null){
            System.out.println("User is present");
        } else {
            System.out.println("User not present");
            throw new UsernameNotFoundException("User not found");
        }

        return appUserPrincipal;
    }
}
