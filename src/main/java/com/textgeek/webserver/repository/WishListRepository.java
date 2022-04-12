package com.textgeek.webserver.repository;

import com.textgeek.webserver.model.Profile;
import com.textgeek.webserver.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WishListRepository extends JpaRepository<WishList, Long> {

    WishList findByProfile(Profile profile);
}
