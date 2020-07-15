package mate.academy.app.service;

import java.util.List;
import mate.academy.app.entity.FoodItem;

public interface FoodItemService {
    void add(FoodItem foodItem);

    void addAll(List<FoodItem> foodItems);

    List<FoodItem> findMostCommentedItems(int pageLimit, int offset);
}
