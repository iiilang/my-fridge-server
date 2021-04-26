package com.ilang.myfridge.service.food;

import com.ilang.myfridge.controller.exception.ErrorCode;
import com.ilang.myfridge.controller.exception.NotFoundException;
import com.ilang.myfridge.model.food.Food;
import com.ilang.myfridge.model.food.FoodType;
import com.ilang.myfridge.model.fridge.Fridge;
import com.ilang.myfridge.repository.food.FoodRepository;
import com.ilang.myfridge.repository.fridge.FridgeRepository;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FoodService {

  private final FridgeRepository fridgeRepository;
  private final FoodRepository foodRepository;

  // todo findFood 테스트 코드 짜기 (단위 테스트 코드 짜는 거 공부하기)
  // todo slf4j를 이용한 로깅

  @Transactional(readOnly = true)
  public Food findFoodDetail(Long foodId) {

    Food food =
        foodRepository
            .findById(foodId)
            .orElseThrow(
                () ->
                    new NotFoundException(
                        ErrorCode.FOOD_NOT_FOUND.getErrorCode(),
                        ErrorCode.FOOD_NOT_FOUND.getErrorMessage()));

    return food;
  }

  @Transactional
  public Food saveFood(
      String foodName, FoodType foodType, String foodMemo, LocalDate expireAt, Long fridgeId) {

    Fridge fridge =
        fridgeRepository
            .findById(fridgeId)
            .orElseThrow(
                () ->
                    new NotFoundException(
                        ErrorCode.FRIDGE_NOT_FOUND.getErrorCode(),
                        ErrorCode.FRIDGE_NOT_FOUND.getErrorMessage()));

    return foodRepository.save(Food.of(foodName, foodType, foodMemo, expireAt, fridge));
  }
}
