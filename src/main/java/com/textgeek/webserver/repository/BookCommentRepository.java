package com.textgeek.webserver.repository;

import com.textgeek.webserver.model.BookComment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookCommentRepository extends JpaRepository<BookComment, Long> {

}