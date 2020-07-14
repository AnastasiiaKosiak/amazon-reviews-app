package mate.academy.app.entity.dto;

import lombok.Data;

@Data
public class ReviewDto {
    private Long reviewId;
    private String userId;
    private String productId;
    private String profileName;
    private Integer helpfulnessNumerator;
    private Integer helpfulnessDenominator;
    private Integer score;
    private Long time;
    private String reviewSummary;
    private String reviewText;
}
