package mate.academy.app.repository;

import java.util.List;
import mate.academy.app.entity.FoodItem;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, String> {
    @Query(value = "SELECT item FROM food_item item ORDER BY SIZE(item.itemReviews) DESC ")
    List<FoodItem> findAll(PageRequest pageRequest);
}
