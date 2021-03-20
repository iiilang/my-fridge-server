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

  public static FoodDetailResponseDto from(Food food) {
    FoodDetailResponseDto foodDetail = new FoodDetailResponseDto();
    foodDetail.id = food.getId();
    foodDetail.foodName = food.getFoodName();
    foodDetail.foodType = food.getFoodType();
    foodDetail.foodMemo = food.getFoodMemo();
    foodDetail.expireAt = food.getExpireAt();
    return foodDetail;
  }
}
