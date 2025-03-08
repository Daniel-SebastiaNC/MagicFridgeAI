package dev.java10x.MagicFridgeAI.controller.request;

import dev.java10x.MagicFridgeAI.enums.Category;

import java.time.LocalDate;

public record FoodItemRequest(String name,
                              Category category,
                              Integer quantity,
                              LocalDate validity) {
}
