package mate.academy.app.repository;

import java.util.List;
import mate.academy.app.entity.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query(value="SELECT u FROM User u ORDER BY SIZE(u.userReviews) DESC")
    List<User> findAll(PageRequest pageRequest);

    @Query(value = "SELECT u FROM User u LEFT JOIN FETCH u.roles Role WHERE u.name = :name")
    User findByName(@Param("name") String name);
}
