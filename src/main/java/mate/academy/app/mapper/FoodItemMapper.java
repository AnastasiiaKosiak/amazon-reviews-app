package mate.academy.app.mapper;

import mate.academy.app.entity.FoodItem;
import mate.academy.app.entity.dto.ReviewDto;
import org.springframework.stereotype.Component;

@Component
public class FoodItemMapper {
    public FoodItem convertFromDtoToFoodItem(ReviewDto dto) {
        FoodItem foodItem = new FoodItem();
        foodItem.setId(dto.getProductId());
        return foodItem;
    }
}
