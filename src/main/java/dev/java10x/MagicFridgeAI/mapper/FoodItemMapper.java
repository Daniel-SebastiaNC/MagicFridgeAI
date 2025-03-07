package dev.java10x.MagicFridgeAI.mapper;

import dev.java10x.MagicFridgeAI.controller.request.FoodItemRequest;
import dev.java10x.MagicFridgeAI.controller.response.FoodItemResponse;
import dev.java10x.MagicFridgeAI.model.FoodItem;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FoodItemMapper {

    public static FoodItem toFoodItem(FoodItemRequest foodItemRequest){
        return FoodItem.builder()
                .name(foodItemRequest.name())
                .category(foodItemRequest.category())
                .quantity(foodItemRequest.quantity())
                .validity(foodItemRequest.validity())
                .build();
    }

    public static FoodItemResponse toFoodItemResponse(FoodItem foodItem){
        return FoodItemResponse.builder()
                .id(foodItem.getId())
                .name(foodItem.getName())
                .category(foodItem.getCategory())
                .quantity(foodItem.getQuantity())
                .validity(foodItem.getValidity())
                .build();
    }
}
