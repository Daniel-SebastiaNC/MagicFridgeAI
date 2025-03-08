package dev.java10x.MagicFridgeAI.controller;

import dev.java10x.MagicFridgeAI.controller.request.FoodItemRequest;
import dev.java10x.MagicFridgeAI.controller.response.FoodItemResponse;
import dev.java10x.MagicFridgeAI.mapper.FoodItemMapper;
import dev.java10x.MagicFridgeAI.model.FoodItem;
import dev.java10x.MagicFridgeAI.service.FoodItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
@RequiredArgsConstructor
public class FoodItemController {

    private final FoodItemService foodItemService;

    @PostMapping("/add")
    public ResponseEntity<FoodItemResponse> addFood(@RequestBody FoodItemRequest foodItemRequest){
        FoodItem saveFoodItem = foodItemService.addFood(foodItemRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(FoodItemMapper.toFoodItemResponse(saveFoodItem));

    }

    @GetMapping("/all")
    public ResponseEntity<List<FoodItemResponse>> getAllFood(){
        return ResponseEntity.ok(
                foodItemService.getAllFood()
                        .stream()
                        .map(FoodItemMapper::toFoodItemResponse)
                        .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodItemResponse> getFoodById(@PathVariable Long id){
        FoodItem foodById = foodItemService.getFoodById(id);
        return ResponseEntity.ok(FoodItemMapper.toFoodItemResponse(foodById));
    }

    @PutMapping("/alter/{id}")
    public ResponseEntity<FoodItemResponse> updateFoodById(@PathVariable Long id, @RequestBody FoodItemRequest foodItemRequest){
        FoodItem saveFoodItem = foodItemService.updateFoodById(id, foodItemRequest);

        return ResponseEntity.ok(FoodItemMapper.toFoodItemResponse(saveFoodItem));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFoodById(@PathVariable Long id){
        foodItemService.deleteFoodById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
