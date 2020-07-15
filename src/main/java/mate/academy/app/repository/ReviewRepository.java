package mate.academy.app.repository;

import java.util.List;
import mate.academy.app.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, String> {
    @Query(value = "SELECT r.reviewText FROM Review r")
    List<String> findAllReviews();
}
