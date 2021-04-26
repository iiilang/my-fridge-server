package com.ilang.myfridge.dto.food;

import com.ilang.myfridge.model.food.FoodType;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FoodSaveRequestDto {

  private String foodName;
  private FoodType foodType;
  private String foodMemo;
  private LocalDate expireAt;
  private Long fridgeId;

  //  public static FoodSaveRequestDto of(
  //      String foodName, FoodType foodType, String foodMemo, LocalDateTime expireAt, Long
  // fridgeId) {
  //    return new FoodSaveRequestDto(foodName, foodType, foodMemo, expireAt, fridgeId);
  //  }
}
