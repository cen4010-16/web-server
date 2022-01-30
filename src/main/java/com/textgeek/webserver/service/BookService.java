package com.textgeek.webserver.service;

import com.textgeek.webserver.model.Book;
import com.textgeek.webserver.repository.BookRepository;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @PostConstruct
    public void initDB() {
        Random random = new Random();
        repository.deleteAll();
        List<Book> books1 = IntStream.rangeClosed(1, 100).mapToObj(i -> {
            Book book = new Book();
            book.setGenre("fantasy");
            book.setCopiesSold(random.ints(0, 5001)
                .findFirst()
                .getAsInt());
            return book;
        }).collect(
            Collectors.toList());
        List<Book> books2 = IntStream.rangeClosed(101, 200).mapToObj(i -> {
            Book book = new Book();
            book.setGenre("romance");
            book.setCopiesSold(random.ints(0, 5001)
                .findFirst()
                .getAsInt());
            return book;
        }).collect(
            Collectors.toList());
        repository.saveAll(books1);
        repository.saveAll(books2);
    }

    public List<Book> getBooks(Map<String, String> allParams) {
        return repository.findAllWithParams(allParams);
    }

}
