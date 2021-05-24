package com.ilang.myfridge.dto.food;

import com.ilang.myfridge.model.food.FoodType;
import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FoodUpdateRequestDto {

  @NotEmpty private String foodName;
  @NotNull private FoodType foodType;
  private String foodMemo;
  @NotNull private LocalDate expireAt;
}
