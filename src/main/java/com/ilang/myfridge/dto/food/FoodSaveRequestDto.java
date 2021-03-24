package com.ilang.myfridge.dto.food;

import com.ilang.myfridge.model.food.FoodType;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FoodSaveRequestDto {

  // TODO AssertThat 넣기 -> 에러 처리
  private String foodName;
  private FoodType foodType;
  private String foodMemo;
  private LocalDateTime expireAt;
  private Long fridgeId;
}
