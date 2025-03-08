package dev.java10x.MagicFridgeAI.controller.response;

import dev.java10x.MagicFridgeAI.enums.Category;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record FoodItemResponse(Long id,
                               String name,
                               Category category,
                               Integer quantity,
                               LocalDate validity) {
}
