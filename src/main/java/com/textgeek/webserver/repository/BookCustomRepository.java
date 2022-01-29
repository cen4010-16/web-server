package com.textgeek.webserver.repository;

import com.textgeek.webserver.model.Book;
import java.util.Map;
import java.util.*;

public interface BookCustomRepository {
  List<Book> findAllWithParams(Map<String,String> allParams);
}
