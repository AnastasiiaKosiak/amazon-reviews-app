package mate.academy.app.mapper;

import mate.academy.app.entity.FoodItem;
import mate.academy.app.entity.Review;
import mate.academy.app.entity.User;
import mate.academy.app.entity.dto.ReviewDto;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public Review convertFromDtoToReview(ReviewDto dto, FoodItem foodItem, User user) {
        Review review = new Review();
        review.setReviewId(dto.getReviewId());
        review.setHelpfulnessDenominator(dto.getHelpfulnessDenominator());
        review.setHelpfulnessNumerator(dto.getHelpfulnessNumerator());
        review.setReviewSummary(dto.getReviewSummary());
        review.setReviewText(dto.getReviewText());
        review.setTime(dto.getTime());
        review.setUser(user);
        review.setItem(foodItem);
        return review;
    }
}
