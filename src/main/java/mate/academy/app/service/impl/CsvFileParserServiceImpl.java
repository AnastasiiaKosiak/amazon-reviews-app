package mate.academy.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import mate.academy.app.entity.dto.ReviewDto;
import mate.academy.app.service.CsvFileParserService;
import mate.academy.app.service.FileReaderService;
import org.springframework.stereotype.Service;

@Service
public class CsvFileParserServiceImpl implements CsvFileParserService {
    private static final int REVIEW_ID_INDEX = 0;
    private static final int USER_ID_INDEX = 1;
    private static final int PRODUCT_ID_INDEX = 2;
    private static final int PROFILE_NAME_INDEX = 3;
    private static final int HELPFULNESS_NUM_INDEX = 4;
    private static final int HELPFULNESS_DENOMINATOR_INDEX = 5;
    private static final int SCORE_INDEX = 6;
    private static final int TIME_INDEX = 7;
    private static final int SUMMARY_INDEX = 8;
    private static final int TEXT_INDEX = 9;
    private final FileReaderService fileReaderService;

    public CsvFileParserServiceImpl(FileReaderService fileReaderService) {
        this.fileReaderService = fileReaderService;
    }

    @Override
    public List<ReviewDto> parseFile(String path) {
        List<String> fileContent = fileReaderService.readFromFile(path);
        List<ReviewDto> reviews = new ArrayList<>();
        for (int i = 1; i < fileContent.size(); i++) {
            String[] data = fileContent.get(i).split(",");
            reviews.add(formReviewDtoFromString(data));
        }
        return reviews;
    }

    private ReviewDto formReviewDtoFromString(String[] data) {
        ReviewDto review = new ReviewDto();
        review.setReviewId(Long.parseLong(data[REVIEW_ID_INDEX]));
        review.setUserId(data[USER_ID_INDEX]);
        review.setProductId(data[PRODUCT_ID_INDEX]);
        review.setProfileName(data[PROFILE_NAME_INDEX]);
        review.setHelpfulnessNumerator(Integer.parseInt(data[HELPFULNESS_NUM_INDEX]));
        review.setHelpfulnessDenominator(Integer.parseInt(data[HELPFULNESS_DENOMINATOR_INDEX]));
        review.setScore(Integer.parseInt(data[SCORE_INDEX]));
        review.setTime(Long.parseLong(data[TIME_INDEX]));
        review.setReviewSummary(data[SUMMARY_INDEX]);
        review.setReviewText(data[TEXT_INDEX]);
        return review;
    }
}
