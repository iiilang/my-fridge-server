package com.ilang.myfridge.controller.food;

import com.ilang.myfridge.dto.food.FoodDetailDto;
import com.ilang.myfridge.service.food.FoodService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/food")
@AllArgsConstructor
public class FoodController {

  private final FoodService foodService;

  @GetMapping("/{foodId}")
  public FoodDetailDto findByFoodId(@PathVariable Long foodId) {
    return FoodDetailDto.of(foodService.findFoodDetail(foodId));
  }
}
