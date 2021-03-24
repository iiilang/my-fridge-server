package com.ilang.myfridge.service.food;

import static com.ilang.myfridge.model.fridge.FridgeType.ROOM;

import com.ilang.myfridge.controller.exception.ErrorCode;
import com.ilang.myfridge.controller.exception.NotFoundException;
import com.ilang.myfridge.dto.food.FoodSaveRequestDto;
import com.ilang.myfridge.model.food.Food;
import com.ilang.myfridge.model.fridge.Fridge;
import com.ilang.myfridge.repository.food.FoodRepository;
import com.ilang.myfridge.repository.fridge.FridgeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class FoodService {

  private FridgeRepository fridgeRepository;
  private FoodRepository foodRepository;

  // todo findFood 테스트 코드 짜기 (단위 테스트 코드 짜는 거 공부하기)
  // todo swagger detail 적기
  // todo slf4j를 이용한 로깅

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
  public Long saveFood(FoodSaveRequestDto foodSaveRequestDto) {
    //    테스트용 코드 (추후 삭제 예정)
    //    Fridge savedFridge = new Fridge(1L, "1", "김치냉장고", ROOM, "yes");
    //    fridgeRepository.save(savedFridge);

    // TODO IllegalArgumentException 넣는 게 맞을까?
    Fridge fridge =
        fridgeRepository
            .findById(foodSaveRequestDto.getFridgeId())
            .orElseThrow(() -> new IllegalArgumentException());

    Food food = Food.of(foodSaveRequestDto, fridge);
    return foodRepository.save(food).getId();
  }
}
