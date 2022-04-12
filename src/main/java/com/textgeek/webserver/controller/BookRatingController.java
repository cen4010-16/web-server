package com.textgeek.webserver.controller;

import com.textgeek.webserver.dto.BookRatingDto;
import com.textgeek.webserver.model.BookRating;
import com.textgeek.webserver.repository.BookRatingRepository;
import com.textgeek.webserver.repository.BookRepository;
import com.textgeek.webserver.repository.ProfileRepository;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

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
    public double getBookRatings(@RequestParam long id) {
        return ratingRepository.findAverageRating(id);
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
}
