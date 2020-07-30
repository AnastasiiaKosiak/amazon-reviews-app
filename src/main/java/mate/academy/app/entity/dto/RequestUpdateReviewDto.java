package mate.academy.app.entity.dto;

import lombok.Data;

@Data
public class RequestUpdateReviewDto {
    private String reviewSummary;
    private String reviewText;
}
