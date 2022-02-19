package com.textgeek.webserver.controller;

import com.textgeek.webserver.model.WishList;
import com.textgeek.webserver.repository.WishListRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class WishListController {

    @Autowired
    private WishListRepository repository;

    @GetMapping("wishlists")
    public List<WishList> getWishLists() {
        return repository.findAll();
    }
}
