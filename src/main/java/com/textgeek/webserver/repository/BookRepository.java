package com.textgeek.webserver.repository;

import com.textgeek.webserver.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BookRepository extends JpaRepository<Book, Long>, BookCustomRepository {

}