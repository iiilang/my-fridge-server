package com.ilang.myfridge.service.food;

import com.ilang.myfridge.controller.exception.ErrorCode;
import com.ilang.myfridge.controller.exception.NotFoundException;
import com.ilang.myfridge.dto.food.FoodDetailDto;
import com.ilang.myfridge.model.food.Food;
import com.ilang.myfridge.repository.food.FoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FoodService {

  private FoodRepository foodRepository;

  // todo 음식 저장 api 짜기
  // todo findFood 테스트 코드 짜기 (단위 테스트 코드 짜는 거 공부하기)
  // todo response 메시지 커스텀하기 (ResponseEntity 이용...? 아마...?)
  // todo 시큐리티 쪽 어떻게 할지 고민해봐야 함. X.
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

    // todo dto로 변경하는 건 controller에서
    return food;
  }
}
