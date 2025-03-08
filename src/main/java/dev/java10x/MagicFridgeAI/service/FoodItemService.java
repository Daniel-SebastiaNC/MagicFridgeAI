package dev.java10x.MagicFridgeAI.service;

import dev.java10x.MagicFridgeAI.controller.request.FoodItemRequest;
import dev.java10x.MagicFridgeAI.mapper.FoodItemMapper;
import dev.java10x.MagicFridgeAI.model.FoodItem;
import dev.java10x.MagicFridgeAI.repository.FoodItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodItemService {

    private final FoodItemRepository foodItemRepository;

    public FoodItem addFood(FoodItemRequest foodItemRequest) {
        FoodItem foodItem = FoodItemMapper.toFoodItem(foodItemRequest);

        return foodItemRepository.save(foodItem);
    }

    public List<FoodItem> getAllFood() {
        return foodItemRepository.findAll();
    }

    public FoodItem getFoodById(Long id) {
        return foodItemRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public FoodItem updateFoodById(Long id, FoodItemRequest foodItemRequest) {
        FoodItem foodById = this.getFoodById(id);
        foodById.setName(foodItemRequest.name());
        foodById.setCategory(foodItemRequest.category());
        foodById.setQuantity(foodItemRequest.quantity());
        foodById.setValidity(foodItemRequest.validity());

        return foodItemRepository.save(foodById);
    }

    public void deleteFoodById(Long id) {
        FoodItem foodById = this.getFoodById(id);
        foodItemRepository.delete(foodById);
    }
}
