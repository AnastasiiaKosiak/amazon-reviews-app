package mate.academy.app.repository;

import java.util.List;
import mate.academy.app.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query(value = "SELECT r.reviewText FROM Review r")
    List<String> findAllReviews();

    void deleteById(Long id);

    @Query("from Review r where r.reviewSummary = :summary and r.amazonUser.name = :name")
    Review findByUserNameAndSummary(@Param("name") String name,
                                     @Param("summary") String reviewSummary);
}
