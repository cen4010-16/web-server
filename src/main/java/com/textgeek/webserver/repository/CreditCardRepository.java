package com.textgeek.webserver.repository;

import com.textgeek.webserver.model.CreditCard;
import com.textgeek.webserver.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

    public CreditCard findByUsername(String username);
}