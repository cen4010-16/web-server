package com.textgeek.webserver.controller;

import com.textgeek.webserver.model.Book;
import com.textgeek.webserver.model.CreditCard;
import com.textgeek.webserver.model.Profile;
import com.textgeek.webserver.repository.CreditCardRepository;
import com.textgeek.webserver.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class CreditCardController {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @PostMapping("/creditCards")
    public CreditCard addCreditCard(@RequestBody CreditCard creditCard) {
        System.out.println(creditCard);
        return creditCardRepository.save(creditCard);
    }

    @GetMapping("/creditCards/{username}")
    public CreditCard getCreditCardByUsername(@PathVariable String username) {
        return creditCardRepository.findByUsername(username);
    }
}
