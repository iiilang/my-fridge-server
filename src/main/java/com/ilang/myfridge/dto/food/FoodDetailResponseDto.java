package com.ilang.myfridge.dto.food;

import com.ilang.myfridge.model.food.Food;
import com.ilang.myfridge.model.food.FoodType;
import java.time.LocalDateTime;

public class FoodDetailResponseDto {

  private Long id;
  private String foodName;
  private FoodType foodType;
  private String foodMemo;
  private LocalDateTime expireAt;

  private FoodDetailResponseDto(
      Long id, String foodName, FoodType foodType, String foodMemo, LocalDateTime expireAt) {
    this.id = id;
    this.foodName = foodName;
    this.foodType = foodType;
    this.foodMemo = foodMemo;
    this.expireAt = expireAt;
  }

  public static FoodDetailResponseDto from(Food food) {
    return new FoodDetailResponseDto(
        food.getId(),
        food.getFoodMemo(),
        food.getFoodType(),
        food.getFoodMemo(),
        food.getExpireAt());
  }
}
