package mate.academy.app.service;

import java.util.List;
import mate.academy.app.entity.dto.ReviewDto;

public interface CsvFileParserService {
    List<ReviewDto> parseFile(String path);
}
