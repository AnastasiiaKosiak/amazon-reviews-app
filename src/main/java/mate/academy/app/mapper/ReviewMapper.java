package mate.academy.app.mapper;

import mate.academy.app.entity.AmazonUser;
import mate.academy.app.entity.FoodItem;
import mate.academy.app.entity.Review;
import mate.academy.app.entity.User;
import mate.academy.app.entity.dto.RequestReviewDto;
import mate.academy.app.entity.dto.ResponseReviewDto;
import mate.academy.app.entity.dto.ReviewDto;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public Review convertFromDtoToReview(ReviewDto dto, FoodItem foodItem, AmazonUser user) {
        Review review = new Review();
        review.setReviewId(dto.getReviewId());
        review.setHelpfulnessDenominator(dto.getHelpfulnessDenominator());
        review.setHelpfulnessNumerator(dto.getHelpfulnessNumerator());
        review.setReviewSummary(dto.getReviewSummary());
        review.setReviewText(dto.getReviewText());
        review.setTime(dto.getTime());
        review.setAmazonUser(user);
        review.setItem(foodItem);
        return review;
    }

    public ResponseReviewDto convertFromReviewToDto(Review review) {
        ResponseReviewDto dto = new ResponseReviewDto();
        dto.setReviewSummary(review.getReviewSummary());
        dto.setReviewText(review.getReviewText());
        return dto;
    }

    public Review convertFromRequestDtoToReview(RequestReviewDto dto, User user, FoodItem foodItem) {
        Review review = new Review();
        review.setReviewText(dto.getReviewText());
        review.setReviewSummary(dto.getReviewSummary());
        review.setUser(user);
        review.setItem(foodItem);
        return review;
    }
}
