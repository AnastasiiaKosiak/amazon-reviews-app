package mate.academy.app.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
@Entity(name = "amazon_user")
public class AmazonUser {
    @Id
    private String id;
    private String name;
    @OneToMany(mappedBy = "amazonUser")
    private List<Review> reviews;
}
