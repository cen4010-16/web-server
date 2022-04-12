package com.textgeek.webserver.controller;

import com.textgeek.webserver.dto.WishListBookDTO;
import com.textgeek.webserver.helper.CustomError;
import com.textgeek.webserver.model.Profile;
import com.textgeek.webserver.model.WishList;
import com.textgeek.webserver.repository.BookRepository;
import com.textgeek.webserver.repository.ProfileRepository;
import com.textgeek.webserver.repository.ShoppingCartRepository;
import com.textgeek.webserver.repository.WishListRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    private ProfileRepository profilerepository;
    @Autowired
    private ShoppingCartRepository shoppingcartrepository;

    @GetMapping("wishlists/{wishlist_id}")
    public ResponseEntity wishlistsUser(@PathVariable Long wishlist_id) {
        var wishList = wishListrepository.findById(wishlist_id);
        if (wishList.isEmpty()) {
            return new ResponseEntity<>(
                new CustomError("Wish List with ID: " + wishlist_id + " Not Found"),
                HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(wishList);
    }


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
        var shopping_cart = shoppingcartrepository.findByProfile(wishlist.getProfile());
        shopping_cart.getBook().add(book);
        wishListrepository.save(wishlist);
        shoppingcartrepository.save(shopping_cart);
    }

    @PostMapping("wishlists/{user_id}")
    public ResponseEntity CreateWishList(@PathVariable Long user_id,
        @RequestBody WishList wishList) {

        Profile profile = profilerepository.findById(user_id).orElseThrow();
        WishList w1 = wishListrepository.findByProfile(profile);
        if (w1 != null) {
            System.out.println("profile already has a Wish List");
            return new ResponseEntity<>(new CustomError("The user " + user_id
                + " already owns a wish list. Please add another user to the wish list"),
                HttpStatus.BAD_REQUEST);
        } else {
            System.out.println(wishList);
            wishList.setProfile(profile);
            WishList wishList1 = wishListrepository.save(wishList);
            return ResponseEntity.ok(wishList1);
        }


    }
}

