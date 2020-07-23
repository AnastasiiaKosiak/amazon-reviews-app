package mate.academy.app.service;

import java.util.List;
import mate.academy.app.entity.FoodItem;

public interface FoodItemService {
    FoodItem add(FoodItem foodItem);

    void addAll(List<FoodItem> foodItems);

    List<FoodItem> findMostCommentedItems(int pageLimit, int offset);

    FoodItem findById(String id);
}
