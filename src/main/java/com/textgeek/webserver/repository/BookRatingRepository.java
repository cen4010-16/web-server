package com.textgeek.webserver.repository;

import com.textgeek.webserver.model.BookRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface BookRatingRepository extends JpaRepository<BookRating, Long> {
    @Query(
        value = "SELECT ROUND(AVG(rating), 1) FROM book_rating WHERE book_id = :book_id",
        nativeQuery = true
    )
    double findAverageRating(@Param("book_id") long bookId);
}