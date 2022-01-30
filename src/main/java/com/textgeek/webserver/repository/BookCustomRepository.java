package com.textgeek.webserver.repository;

import com.textgeek.webserver.model.Book;
import java.util.List;
import java.util.Map;

public interface BookCustomRepository {

    List<Book> findAllWithParams(Map<String, String> allParams);
}
