package mate.academy.app.mapper;

import mate.academy.app.entity.FoodItem;
import mate.academy.app.entity.dto.FoodItemDto;
import mate.academy.app.entity.dto.ReviewDto;
import org.springframework.stereotype.Component;

@Component
public class FoodItemMapper {
    public FoodItem convertFromDtoToFoodItem(ReviewDto dto) {
        FoodItem foodItem = new FoodItem();
        foodItem.setId(dto.getProductId());
        return foodItem;
    }

    public FoodItemDto convertFromFoodItemToDto(FoodItem foodItem) {
        FoodItemDto dto = new FoodItemDto();
        dto.setId(foodItem.getId());
        return dto;
    }
}
