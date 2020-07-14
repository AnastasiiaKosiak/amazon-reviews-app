package mate.academy.app.service.impl;

import java.util.List;
import mate.academy.app.entity.FoodItem;
import mate.academy.app.repository.ItemRepository;
import mate.academy.app.service.FoodItemService;
import org.springframework.stereotype.Service;

@Service
public class FoodItemServiceImpl implements FoodItemService {
    private final ItemRepository itemRepository;

    public FoodItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void add(FoodItem foodItem) {
        itemRepository.save(foodItem);
    }

    @Override
    public void addAll(List<FoodItem> foodItems) {
        itemRepository.saveAll(foodItems);
    }
}
