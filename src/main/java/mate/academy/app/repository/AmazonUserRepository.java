package mate.academy.app.repository;

import mate.academy.app.entity.AmazonUser;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AmazonUserRepository extends JpaRepository<AmazonUser, String> {
    @Query(value = "SELECT u FROM amazon_user u ORDER BY SIZE(u.reviews) DESC")
    List<AmazonUser> findAll(PageRequest pageRequest);

    AmazonUser findByName(String name);
}
