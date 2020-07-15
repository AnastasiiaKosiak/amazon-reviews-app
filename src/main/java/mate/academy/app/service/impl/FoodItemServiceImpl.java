package mate.academy.app.service.impl;

import java.util.List;
import mate.academy.app.entity.FoodItem;
import mate.academy.app.repository.FoodItemRepository;
import mate.academy.app.service.FoodItemService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class FoodItemServiceImpl implements FoodItemService {
    private final FoodItemRepository foodItemRepository;

    public FoodItemServiceImpl(FoodItemRepository itemRepository) {
        this.foodItemRepository = itemRepository;
    }

    @Override
    public void add(FoodItem foodItem) {
        foodItemRepository.save(foodItem);
    }

    @Override
    public void addAll(List<FoodItem> foodItems) {
        foodItemRepository.saveAll(foodItems);
    }

    @Override
    public List<FoodItem> findMostCommentedItems(int pageLimit, int offset) {
        PageRequest pageRequest = PageRequest.of(pageLimit, offset);
        return foodItemRepository.findAll(pageRequest);
    }
}
