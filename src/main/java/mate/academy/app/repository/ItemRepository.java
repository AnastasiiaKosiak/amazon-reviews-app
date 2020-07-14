package mate.academy.app.repository;

import mate.academy.app.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<FoodItem, Long> {
}
