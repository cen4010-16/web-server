package com.textgeek.webserver.repository;

import com.textgeek.webserver.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

   // @Query("SELECT u FROM Profile u WHERE u.username = :username")
   public Profile findByUsername(String username);
}
