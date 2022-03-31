package com.textgeek.webserver.repository;

import com.textgeek.webserver.model.Book;
import com.textgeek.webserver.model.Profile;
import com.textgeek.webserver.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long>{

    List<ShoppingCart> findByProfile(Profile profile);

    /*public ShoppingCart findByProfileAndProduct(Profile profile, Book book);

    @Query(" Update ShoppingCart c set c.quantity = ?1 where c.book.id = ?2" + " AND c.profile.id = ?3")
    @Modifying
    public void UpdateQuantity(Integer quantity, Integer book_id,Integer profile_id);

    @Query("delete from ShoppingCart c where c.profile.id =?1 and c.book.id = ?2 ")
    @Modifying
    public void DeleteByProfileandBook(Integer profile_id, Integer book_id);*/
}
