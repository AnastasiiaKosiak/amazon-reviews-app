package mate.academy.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "review")
@Data
public class Review {
    @Id
    @Column(name = "review_id")
    private Long reviewId;
    @ManyToOne
    private User user;
    @ManyToOne
    private FoodItem item;
    @Column(name = "helpfulness_num")
    private Integer helpfulnessNumerator;
    @Column(name = "help_denom")
    private Integer helpfulnessDenominator;
    private Integer score;
    private Long time;
    @Column(name = "summary")
    private String reviewSummary;
    @Column(length = 50000, columnDefinition = "text")
    private String reviewText;
}
