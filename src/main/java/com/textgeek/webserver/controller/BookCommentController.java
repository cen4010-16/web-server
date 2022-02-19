package com.textgeek.webserver.controller;

import com.textgeek.webserver.dto.BookCommentDto;
import com.textgeek.webserver.model.BookComment;
import com.textgeek.webserver.repository.BookCommentRepository;
import com.textgeek.webserver.repository.BookRepository;
import com.textgeek.webserver.repository.ProfileRepository;
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
    private final BookRepository bookRepository;
    private final ProfileRepository profileRepository;

    public BookCommentController(final BookCommentRepository commentRepository,
        final BookRepository bookRepository,
        final ProfileRepository profileRepository
    ) {
        this.commentRepository = commentRepository;
        this.bookRepository = bookRepository;
        this.profileRepository = profileRepository;
    }

    @GetMapping("comments")
    public List<BookComment> getBookComments() {
        return commentRepository.findAll();
    }

    @PostMapping("comments")
    public BookComment addComment(@RequestBody BookCommentDto commentDto) {
        // TODO: PROPER ERROR HANDLING
        var book = bookRepository.findById(commentDto.getBookId()).orElseThrow();
        var profile = profileRepository.findById(commentDto.getProfileId()).orElseThrow();
        var comment = new BookComment();
        comment.setBook(book);
        comment.setProfile(profile);
        comment.setText(commentDto.getText());
        comment.setCreated(Date.from(Instant.now()));
        return commentRepository.save(comment);
    }
}
