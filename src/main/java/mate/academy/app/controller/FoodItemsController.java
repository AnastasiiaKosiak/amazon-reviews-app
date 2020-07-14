package mate.academy.app.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.app.entity.dto.FoodItemDto;
import mate.academy.app.mapper.FoodItemMapper;
import mate.academy.app.service.FoodItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class FoodItemsController {
    private final FoodItemMapper mapper;
    private final FoodItemService foodItemService;

    public FoodItemsController(FoodItemMapper mapper, FoodItemService foodItemService) {
        this.mapper = mapper;
        this.foodItemService = foodItemService;
    }

    @GetMapping
    public List<FoodItemDto> getMostCommentedFoodItems(@RequestParam int pageLimit, @RequestParam int offset) {
       return foodItemService.findMostCommentedItems(pageLimit, offset)
               .stream()
               .map(mapper::convertFromFoodItemToDto)
               .collect(Collectors.toList());
    }
}
