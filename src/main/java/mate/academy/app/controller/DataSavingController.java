package mate.academy.app.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import mate.academy.app.entity.FoodItem;
import mate.academy.app.entity.Review;
import mate.academy.app.entity.User;
import mate.academy.app.entity.dto.ReviewDto;
import mate.academy.app.mapper.FoodItemMapper;
import mate.academy.app.mapper.ReviewMapper;
import mate.academy.app.mapper.UserMapper;
import mate.academy.app.service.CsvFileParserService;
import mate.academy.app.service.FoodItemService;
import mate.academy.app.service.ReviewService;
import mate.academy.app.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class DataSavingController {
    private static final String REVIEWS_FILE_PATH = "src/test/resources/reviews.csv";
    private final CsvFileParserService fileParser;
    private final ReviewMapper reviewMapper;
    private final UserMapper userMapper;
    private final FoodItemMapper itemMapper;
    private final ReviewService reviewService;
    private final UserService userService;
    private final FoodItemService foodItemService;

    @PostConstruct
    public void saveDataToDatabase() {
        List<ReviewDto> parsedReviews = fileParser.parseFile(REVIEWS_FILE_PATH);
        List<User> users = new ArrayList<>();
        List<FoodItem> items = new ArrayList<>();
        List<Review> reviews = new ArrayList<>();
        for (ReviewDto dto : parsedReviews) {
            User newUser = userMapper.convertFromDtoToUser(dto);
            users.add(newUser);
            FoodItem newFoodItem = itemMapper.convertFromDtoToFoodItem(dto);
            items.add(newFoodItem);
            Review newReview = reviewMapper.convertFromDtoToReview(dto, newFoodItem, newUser);
            reviews.add(newReview);
        }
        userService.addAll(users);
        foodItemService.addAll(items);
        reviewService.addAll(reviews);
    }
}
