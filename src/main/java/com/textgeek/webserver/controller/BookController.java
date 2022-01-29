package com.textgeek.webserver.controller;

import com.textgeek.webserver.model.Book;
import com.textgeek.webserver.service.BookService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("books")
    public List<Book> getBooks(@RequestParam Map<String, String> allParams) {
        return bookService.getBooks(allParams);
    }
}
