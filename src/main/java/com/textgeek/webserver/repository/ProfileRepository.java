package com.textgeek.webserver.repository;

import com.textgeek.webserver.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {


}
