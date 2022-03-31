package com.textgeek.webserver.controller;


import com.textgeek.webserver.model.Profile;
import com.textgeek.webserver.model.ShoppingCart;
import com.textgeek.webserver.repository.ProfileRepository;
import com.textgeek.webserver.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Controller
//@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping("/shoppingcart/{userid}")
    public List<ShoppingCart> SeeShoppingCart(Model model,@PathVariable("userid") long user_id /*,@AuthenticationPrincipal Authentication authentication*/){

        Profile profile =
            profileRepository.getById(user_id);
        List<ShoppingCart> listShoppingCart = shoppingCartService.listShoppingCart(profile);

        model.addAttribute("listShoppingCart",listShoppingCart);

        return listShoppingCart;

    }

}
