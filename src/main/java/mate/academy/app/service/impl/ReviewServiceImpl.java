package mate.academy.app.service.impl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import mate.academy.app.entity.Review;
import mate.academy.app.repository.ReviewRepository;
import mate.academy.app.service.ReviewService;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private static final String NON_LETTER_REGEX = "[^a-z]+";

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void add(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void addAll(List<Review> reviews) {
        reviewRepository.saveAll(reviews);
    }

    @Override
    public List<String> findMostUsedWords(int pageLimit) {
        List<String> allReviews = reviewRepository.findAllReviews()
                .stream()
                .map(String::toLowerCase)
                .flatMap(text -> Arrays.stream(text.split(NON_LETTER_REGEX)))
                .collect(Collectors.toList());
        return processReviewTexts(allReviews, pageLimit);
    }

    private List<String> processReviewTexts(List<String> text, int limit) {
        Map<String, Integer> stringsCount = new HashMap<>();
        for (String word: text) {
            Integer count = stringsCount.get(word);
            if (count == null) {
                count = 0;
            }
            count++;
            stringsCount.put(word, count);
        }
        return stringsCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(limit)
                .collect(Collectors.toList());
    }
}
