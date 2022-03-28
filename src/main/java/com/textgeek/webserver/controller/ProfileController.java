package com.textgeek.webserver.controller;

import com.textgeek.webserver.model.Profile;
import com.textgeek.webserver.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
}
