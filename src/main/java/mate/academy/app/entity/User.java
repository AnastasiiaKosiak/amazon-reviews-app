package mate.academy.app.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    private String id;
    private String name;
    @Column(name = "user_reviews")
    @OneToMany(mappedBy = "user")
    private List<Review> userReviews;
}
