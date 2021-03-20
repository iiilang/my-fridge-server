package com.ilang.myfridge.dto.food;

import com.ilang.myfridge.model.food.Food;
import com.ilang.myfridge.model.food.FoodType;
import com.ilang.myfridge.model.fridge.Fridge;
import com.ilang.myfridge.repository.food.FoodRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FoodRequestDto {

  // AssertThat 넣기
  private String foodName;
  private FoodType foodType;
  private String foodMemo;
  private Fridge fridgeId;

  // todo fridge가 다 뜨는 거 어케 없앨까...
}
