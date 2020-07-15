package mate.academy.app.controller;

import java.util.List;
import mate.academy.app.service.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {
    private final ReviewService reviewService;

    public ReviewsController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/popular-words")
    List<String> getMostUserWordsFromReviews(@RequestParam int pageLimit) {
        return reviewService.findMostUsedWords(pageLimit);
    }
}
