package com.ilang.myfridge.dto.food;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FoodSaveDto {

  private String foodName;
  private String foodType;
  private String foodMemo;
  private Long fridgeId;

  @Builder
  public FoodSaveDto(String foodName, String foodType, String foodMemo, Long fridgeId) {
    this.foodName = foodName;
    this.foodType = foodType;
    this.foodMemo = foodMemo;
    this.fridgeId = fridgeId;
  }
}
