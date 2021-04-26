package com.ilang.myfridge.dto.food;

import com.ilang.myfridge.model.food.Food;
import com.ilang.myfridge.model.food.FoodType;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FoodSaveResponseDto {

  private Long foodId;
  private String foodName;
  private FoodType foodType;
  private String foodMemo;
  private LocalDate expireAt;
  private Long fridgeId;

  public static FoodSaveResponseDto from(Food food) {
    return new FoodSaveResponseDto(
        food.getId(),
        food.getFoodName(),
        food.getFoodType(),
        food.getFoodMemo(),
        food.getExpireAt(),
        food.getFridge().getId());
  }
}
