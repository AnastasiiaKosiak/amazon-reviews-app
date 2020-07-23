package mate.academy.app.entity.dto;

import lombok.Data;

@Data
public class RequestReviewDto {
    private String foodItemId;
    private String reviewSummary;
    private String reviewText;
}
