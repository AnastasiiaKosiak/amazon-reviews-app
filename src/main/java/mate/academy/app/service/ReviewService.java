package mate.academy.app.service;

import java.util.List;
import mate.academy.app.entity.Review;

public interface ReviewService {
    Review add(Review review);

    void addAll(List<Review> reviews);

    List<String> findMostUsedWords(int pageLimit);

    void deleteById(Long id);

    Review search(String name, String summary);
}
