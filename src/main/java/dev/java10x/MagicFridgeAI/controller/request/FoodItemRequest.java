package dev.java10x.MagicFridgeAI.controller.request;

import dev.java10x.MagicFridgeAI.enums.Category;

import java.time.LocalDateTime;

public record FoodItemRequest(String name,
                              Category category,
                              Integer quantity,
                              LocalDateTime validity) {
}
