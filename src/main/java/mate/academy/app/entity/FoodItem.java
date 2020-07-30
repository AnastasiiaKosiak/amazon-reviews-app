package mate.academy.app.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "food_item")
public class FoodItem {
    @Id
    private String id;
    @Column(name = "item_reviews")
    @OneToMany(mappedBy = "item")
    private List<Review> itemReviews;
}
