package com.textgeek.webserver.controller;

import com.textgeek.webserver.dto.BookRatingDto;
import com.textgeek.webserver.model.Book;
import com.textgeek.webserver.model.BookRating;
import com.textgeek.webserver.repository.BookRatingRepository;
import com.textgeek.webserver.repository.BookRepository;
import com.textgeek.webserver.repository.ProfileRepository;
import java.sql.Date;
import java.time.Instant;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
public class BookRatingController {

    private final BookRatingRepository ratingRepository;
    private final BookRepository bookRepository;
    private final ProfileRepository profileRepository;

    public BookRatingController(final BookRatingRepository ratingRepository,
                                final BookRepository bookRepository,
                                final ProfileRepository profileRepository
    ) {
        this.ratingRepository = ratingRepository;
        this.bookRepository = bookRepository;
        this.profileRepository = profileRepository;
    }

    @GetMapping("ratings")
    public List<BookRating> getBookRatings() {
        return ratingRepository.findAll();
    }

    @GetMapping("ratings/average")
    @ResponseBody
    public Book getBookRatings(@RequestParam long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    @PostMapping("ratings")
    public BookRating addBookRating(@RequestBody BookRatingDto ratingDto) {
        var book = bookRepository.findById(ratingDto.getBookId()).orElseThrow();
        var profile = profileRepository.findById(ratingDto.getProfileId()).orElseThrow();
        var rating = new BookRating();
        rating.setBook(book);
        rating.setProfile(profile);
        rating.setRating(ratingDto.getRating());
        rating.setCreated(Date.from(Instant.now()));
        return ratingRepository.save(rating);
    }

    @GetMapping("ratings/sorted")
    @ResponseBody
    public List<BookRating> getSortedRatings() {
        return ratingRepository.findAll(Sort.by(Direction.DESC, "rating"));
    }
}
