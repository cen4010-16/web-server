
package com.textgeek.webserver.controller;

public class ShoppingCartRestController {
}

/*import com.textgeek.webserver.model.Profile;
import com.textgeek.webserver.service.ShoppingCartService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingCartRestController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    //@Autowired
    //private ProfileService profileservices;

    @PostMapping("/shoppingcart/add/{book_id}/{quantity}")

    //@Override
    public String addBookToShoppingCart(@PathVariable("book_id") Integer book_id, @PathVariable("quantity") Integer quantity/*, @AuthenticationPrincipal Authentication authentication ) {
        /*if(authentication == null|| authentication instanceof AnonymousAuthentificationToken){
            return "Please log in to add the product to the ShoppingCart";
        }
        //Profile profile = profileservices.getCurrnetlyLoggedInCustumer(authentication);

        Integer addQuantity = ShoppingCartService.addBook(book_id, quantity, profile);
        return addQuantity + " items were added to the ShoppingCart";
    }

    @PostMapping("/shoppingcart/remove/{book_id}/{quantity}")

    //@Override
    public String RemoveBookFromShoppingCart(@PathVariable("book_id") Integer book_id, @PathVariable("quantity") Integer quantity/*, @AuthenticationPrincipal Authentication authentication ) {
        /*if(authentication == null|| authentication instanceof AnonymousAuthentificationToken){
            return "Please log in to update product to the ShoppingCart";
        }
        Profile profile = profileservices.getCurrnetlyLoggedInCustumer(/*authentication);

        Integer addQuantity = ShoppingCartService.RemoveBook(book_id,profile);
        return " Booked removed from the ShoppingCart";
    }
}*/
