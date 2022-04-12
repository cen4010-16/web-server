package com.textgeek.webserver.controller;

import com.textgeek.webserver.dto.BookCommentDto;
import com.textgeek.webserver.model.BookComment;
import com.textgeek.webserver.repository.BookCommentRepository;
import com.textgeek.webserver.repository.BookRatingRepository;
import java.sql.Date;
import java.time.Instant;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
public class BookCommentController {

    private final BookCommentRepository commentRepository;
    private final BookRatingRepository bookRatingRepository;

    public BookCommentController(final BookCommentRepository commentRepository,
        final BookRatingRepository bookRatingRepository
    ) {
        this.commentRepository = commentRepository;
        this.bookRatingRepository = bookRatingRepository;
    }

    @GetMapping("comments")
    public List<BookComment> getBookComments() {
        return commentRepository.findAll();
    }

    @PostMapping("comments")
    public BookComment addComment(@RequestBody BookCommentDto commentDto) {
        var rating = bookRatingRepository.findById(commentDto.getRatingId()).orElseThrow();
        var comment = new BookComment();
        comment.setText(commentDto.getText());
        comment.setCreated(Date.from(Instant.now()));
        comment.setRating(rating);
        return commentRepository.save(comment);
    }


}
