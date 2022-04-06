package com.textgeek.webserver.controller;

import com.textgeek.webserver.dto.ShoppingCartDTO;
import com.textgeek.webserver.model.Profile;
import com.textgeek.webserver.model.ShoppingCart;
import com.textgeek.webserver.repository.BookRepository;
import com.textgeek.webserver.repository.ProfileRepository;
import com.textgeek.webserver.repository.ShoppingCartRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class ShoppingCartController {
   private final ShoppingCartRepository shoppingCartRepository;

    private final BookRepository bookRepository;

    private final ProfileRepository profileRepository;

    public ShoppingCartController(
        ShoppingCartRepository shoppingCartRepository, BookRepository bookRepository, ProfileRepository profileRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.bookRepository = bookRepository;
        this.profileRepository = profileRepository;
    }

    @GetMapping("shoppingcart/{shopping_cart_id}")
    public ResponseEntity BooksOnShoppingCart(@PathVariable Long shopping_cart_id)
    {
        var shoppingCart = shoppingCartRepository.findById(shopping_cart_id);
        if(shoppingCart.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
        return ResponseEntity.ok(shoppingCart);
    }

    @PostMapping("shoppingcart/{user_id}")
    public ResponseEntity CreateShoppingCart( @PathVariable Long user_id, ShoppingCart shoppingCart){

        Profile profile = profileRepository.findById(user_id).orElseThrow();
        ShoppingCart s1 = shoppingCartRepository.findByProfile(profile);
        if(s1!=null){
            System.out.println("profile already has a shopping cart");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            shoppingCart.setProfile(profile);
            ShoppingCart shoppingCart1 = shoppingCartRepository.save(shoppingCart);
            return ResponseEntity.ok(shoppingCart1);
        }


    }

    @PostMapping("addshoppingcart")
    public void addShoppingCart(@RequestBody ShoppingCartDTO shoppingCartDTO){
    var book = bookRepository.findById(shoppingCartDTO.getBook_id()).orElseThrow();
    var shopping_cart = shoppingCartRepository.findById(shoppingCartDTO.getShopping_cart_id()).orElseThrow();
    shopping_cart.getBook().add(book);
    shoppingCartRepository.save(shopping_cart);
    }

    @GetMapping("shoppingcart")
    public List<ShoppingCart> getShoppingCart() {
        return shoppingCartRepository.findAll();
    }





    @DeleteMapping("removebookshoppingcart")
    public void removeBookShoppingCart(@RequestBody ShoppingCartDTO shoppingCartDTO){
        var book = bookRepository.findById(shoppingCartDTO.getBook_id()).orElseThrow();
        var shopping_cart = shoppingCartRepository.findById(shoppingCartDTO.getShopping_cart_id()).orElseThrow();
        shopping_cart.getBook().remove(book);
        shoppingCartRepository.save(shopping_cart);
    }

}
