package com.textgeek.webserver.controller;

import com.textgeek.webserver.dto.WishListBookDTO;
import com.textgeek.webserver.model.WishList;
import com.textgeek.webserver.repository.BookRepository;
import com.textgeek.webserver.repository.WishListRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class WishListController {

    @Autowired
    private WishListRepository wishListrepository;
    @Autowired
    private BookRepository bookrepository;


    @PostMapping("addtowishlist")
    public void addtowishlist(@RequestBody WishListBookDTO wishlistbookdto) {
        var book = bookrepository.findById(wishlistbookdto.getBookId()).orElseThrow();
        var wishlist = wishListrepository.findById(wishlistbookdto.getWishlistId()).orElseThrow();
        wishlist.getBook().add(book);
        wishListrepository.save(wishlist);

    }

    @GetMapping("wishlists")
    public List<WishList> getWishLists() {
        return wishListrepository.findAll();
    }


    @PostMapping("removefromwishlist")
    public void removefromwishlist(@RequestBody WishListBookDTO wishlistbookdto) {
        var book = bookrepository.findById(wishlistbookdto.getBookId()).orElseThrow();
        var wishlist = wishListrepository.findById(wishlistbookdto.getWishlistId()).orElseThrow();
        wishlist.getBook().remove(book);
        wishListrepository.save(wishlist);
    }


}

