package com.textgeek.webserver.controller;

import com.textgeek.webserver.model.Book;
import com.textgeek.webserver.model.Profile;
import com.textgeek.webserver.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @PostMapping("/profiles")
    public Profile addProfile(@RequestBody Profile profile) {
        System.out.println(profile);
        return profileRepository.save(profile);
    }

    @GetMapping("/profiles/{username}")
    public Profile getProfileByUsername(@PathVariable String username) {
        return profileRepository.findByUsername(username);
    }

    @PutMapping("/profiles/{username}")
    public Profile editProfile(@PathVariable String username, @RequestBody Profile profile){

        Profile userProfile = profileRepository.findByUsername(username);

        if(profile.getPassword()!= null){
            userProfile.setPassword(profile.getPassword());
        }
        if(profile.getFirst_name()!= null){
            userProfile.setFirst_name(profile.getFirst_name());
        }
        if(profile.getLast_name()!= null){
            userProfile.setLast_name(profile.getLast_name());
        }
        if(profile.getStreet_address()!= null){
            userProfile.setStreet_address(profile.getStreet_address());
        }
        if(profile.getStreet_address_2()!= null){
            userProfile.setStreet_address_2(profile.getStreet_address_2());
        }
        if(profile.getCity()!= null){
            userProfile.setCity(profile.getCity());
        }
        if(profile.getState()!= null){
            userProfile.setState(profile.getState());
        }
        if(profile.getZip_code()!= null){
            userProfile.setZip_code(profile.getZip_code());
        }
        profileRepository.save(userProfile);
        return userProfile;
    }

}