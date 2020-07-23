package mate.academy.app.controller;

import java.util.List;

import lombok.AllArgsConstructor;
import mate.academy.app.entity.FoodItem;
import mate.academy.app.entity.Review;
import mate.academy.app.entity.User;
import mate.academy.app.entity.dto.RequestDeleteReviewDto;
import mate.academy.app.entity.dto.RequestReviewDto;
import mate.academy.app.entity.dto.RequestUpdateReviewDto;
import mate.academy.app.entity.dto.ResponseReviewDto;
import mate.academy.app.mapper.ReviewMapper;
import mate.academy.app.service.FoodItemService;
import mate.academy.app.service.ReviewService;
import mate.academy.app.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
@AllArgsConstructor

public class ReviewsController {
    private final ReviewService reviewService;
    private final UserService userService;
    private final FoodItemService foodItemService;
    private final ReviewMapper reviewMapper;

    @GetMapping("/popular-words")
    List<String> getMostUsedWordsFromReviews(@RequestParam int pageLimit) {
        return reviewService.findMostUsedWords(pageLimit);
    }

    @DeleteMapping("/delete")
    public void deleteReview(@RequestBody RequestDeleteReviewDto dto) {
        reviewService.deleteById(dto.getReviewId());
    }

    @PostMapping("/add")
    public ResponseReviewDto addReview(@RequestBody RequestReviewDto dto,
                                       Authentication authentication) {
        User user = userService.findByName(authentication.getName());
        FoodItem foodItem = foodItemService.findById(dto.getFoodItemId());
        Review review = reviewMapper.convertFromRequestDtoToReview(dto, user, foodItem);
        return reviewMapper.convertFromReviewToDto(reviewService.add(review));
    }

    @PutMapping("/update")
    public ResponseReviewDto updateReview(@RequestBody RequestUpdateReviewDto dto,
                                          Authentication authentication) {
        Review updatedReview = reviewService.search(authentication.getName(),
                dto.getReviewSummary());
        updatedReview.setReviewText(dto.getReviewText());
        return reviewMapper.convertFromReviewToDto(reviewService.add(updatedReview));
    }
}
