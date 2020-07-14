package mate.academy.app.service;

import java.util.List;
import mate.academy.app.entity.Review;

public interface ReviewService {
    void add(Review review);

    void addAll(List<Review> reviews);

    List<String> findMostUsedWords(int pageLimit);
}
