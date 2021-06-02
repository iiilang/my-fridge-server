package com.ilang.myfridge.service.food;

import com.ilang.myfridge.controller.exception.ErrorCode;
import com.ilang.myfridge.controller.exception.NotFoundException;
import com.ilang.myfridge.model.food.Food;
import com.ilang.myfridge.model.food.FoodType;
import com.ilang.myfridge.model.fridge.Fridge;
import com.ilang.myfridge.repository.food.FoodRepository;
import com.ilang.myfridge.repository.fridge.FridgeRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
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
            .orElseThrow(() -> NotFoundException.of(ErrorCode.FOOD_NOT_FOUND));

    return food;
  }

  @Transactional
  public List<Food> findFoodList(Long fridgeId) {

    Fridge fridge =
        fridgeRepository
            .findById(fridgeId)
            .orElseThrow(() -> NotFoundException.of(ErrorCode.FRIDGE_NOT_FOUND));

    return foodRepository.findAllByFridge(fridge);
  }

  @Transactional
  public Food saveFood(
      String foodName, FoodType foodType, String foodMemo, LocalDate expireAt, Long fridgeId) {

    Fridge fridge =
        fridgeRepository
            .findById(fridgeId)
            .orElseThrow(() -> NotFoundException.of(ErrorCode.FRIDGE_NOT_FOUND));

    if (foodNameExist(fridge, foodName)) {
      throw NotFoundException.of(ErrorCode.FOOD_NAME_DUPLICATED);
    }

    if (!foodType.typeMatch(fridge.getFridgeType())) {
      // todo NotFoundException 변경 필요
      throw NotFoundException.of(ErrorCode.TYPE_NOT_MATCH);
    }

    return foodRepository.save(Food.of(foodName, foodType, foodMemo, expireAt, fridge));
  }

  @Transactional
  public Food updateFood(
      Long foodId,
      String foodName,
      FoodType foodType,
      String foodMemo,
      LocalDate expireAt,
      Long fridgeId) {

    Food food =
        foodRepository
            .findById(foodId)
            .orElseThrow(() -> NotFoundException.of(ErrorCode.FOOD_NOT_FOUND));

    if (foodNameExist(food.getFridge(), foodId, foodName)) {
      throw NotFoundException.of(ErrorCode.FOOD_NAME_DUPLICATED);
    }

    Fridge fridge =
        fridgeRepository
            .findById(fridgeId)
            .orElseThrow(() -> NotFoundException.of(ErrorCode.FRIDGE_NOT_FOUND));

    if (!foodType.typeMatch(fridge.getFridgeType())) {
      throw NotFoundException.of(ErrorCode.TYPE_NOT_MATCH);
    }
    return food.update(foodName, foodType, foodMemo, expireAt, fridge);
  }

  @Transactional
  public void deleteFood(Long foodId) {
    foodRepository
        .findById(foodId)
        .orElseThrow(() -> NotFoundException.of(ErrorCode.FOOD_NOT_FOUND));
    foodRepository.deleteById(foodId);
  }

  private boolean foodNameExist(Fridge fridge, String foodName) {
    List<String> foodNameList =
        foodRepository.findAllByFridge(fridge).stream()
            .map(food -> food.getFoodName())
            .filter(food -> food.equals(foodName))
            .collect(Collectors.toList());

    return !(foodNameList.isEmpty());
  }

  private boolean foodNameExist(Fridge fridge, Long foodId, String foodName) {
    List<String> foodNameList =
        foodRepository.findAllByFridge(fridge).stream()
            .filter(food -> (!food.getId().equals(foodId)))
            .map(food -> food.getFoodName())
            .filter(food -> food.equals(foodName))
            .collect(Collectors.toList());

    return !(foodNameList.isEmpty());
  }
}
