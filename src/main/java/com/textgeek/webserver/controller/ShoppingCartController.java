package com.textgeek.webserver.controller;

import com.textgeek.webserver.dto.ShoppingCartDTO;
import com.textgeek.webserver.model.ShoppingCart;
import com.textgeek.webserver.repository.BookRepository;
import com.textgeek.webserver.repository.ShoppingCartRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ShoppingCartController {
   private final ShoppingCartRepository shoppingCartRepository;

    private final BookRepository bookRepository;

    public ShoppingCartController(
        ShoppingCartRepository shoppingCartRepository, BookRepository bookRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.bookRepository = bookRepository;
    }

    @PostMapping("addshoppingcart")
    public void addShoppingCart(@RequestBody ShoppingCartDTO shoppingCartDTO){
    var book = bookRepository.findById(shoppingCartDTO.getBook_id()).orElseThrow();
    var shopping_cart = shoppingCartRepository.findById(shoppingCartDTO.getShopping_cart_id()).orElseThrow();
    shopping_cart.getBook().add(book);
    shoppingCartRepository.save(shopping_cart);
    }

    @GetMapping("shopping_cart")
    public List<ShoppingCart> getShoppingCart() {
        return shoppingCartRepository.findAll();
    }

    @PostMapping("removebookshoppingcart")
    public void removeBookShoppingCart(@RequestBody ShoppingCartDTO shoppingCartDTO){
        var book = bookRepository.findById(shoppingCartDTO.getBook_id()).orElseThrow();
        var shopping_cart = shoppingCartRepository.findById(shoppingCartDTO.getShopping_cart_id()).orElseThrow();
        shopping_cart.getBook().remove(book);
        shoppingCartRepository.save(shopping_cart);
    }

}
