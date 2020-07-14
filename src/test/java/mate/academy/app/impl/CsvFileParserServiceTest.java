package mate.academy.app.impl;

import java.util.List;
import mate.academy.app.entity.dto.ReviewDto;
import mate.academy.app.service.CsvFileParserService;
import mate.academy.app.service.FileReaderService;
import mate.academy.app.service.impl.CsvFileParserServiceImpl;
import mate.academy.app.service.impl.FileReaderServiceImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CsvFileParserServiceTest {
    private final FileReaderService fileReader = new FileReaderServiceImpl();
    private final CsvFileParserService csvFileParserService =
            new CsvFileParserServiceImpl(fileReader);

    @Test
    void checkCsvFileParsing() {
        String path = "src/test/resources/reviews.csv";
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setReviewId(1L);
        reviewDto.setUserId("B001E4KFG0");
        reviewDto.setProductId("A3SGXH7AUHU8GW");
        reviewDto.setProfileName("delmartian");
        reviewDto.setHelpfulnessNumerator(1);
        reviewDto.setHelpfulnessDenominator(1);
        reviewDto.setScore(5);
        reviewDto.setTime(1303862400L);
        reviewDto.setReviewSummary("Good Quality Dog Food");
        reviewDto.setReviewText("I have bought several of the Vitality canned dog food products " +
                "and have found them all to be of good quality.");
        List<ReviewDto> expected = List.of(reviewDto);
        List<ReviewDto> actual = csvFileParserService.parseFile(path);
        assertEquals(expected, actual);
    }
}
