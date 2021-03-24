package com.ilang.myfridge.controller.food;

import com.ilang.myfridge.dto.food.FoodDetailResponseDto;
import com.ilang.myfridge.dto.food.FoodSaveRequestDto;
import com.ilang.myfridge.service.food.FoodService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/food")
@AllArgsConstructor
public class FoodController {

  private final FoodService foodService;

  @GetMapping("/{foodId}")
  public FoodDetailResponseDto findByFoodId(@PathVariable Long foodId) {
    return FoodDetailResponseDto.from(foodService.findFoodDetail(foodId));
  }

  @PostMapping("/save")
  public Long saveFood(@RequestBody FoodSaveRequestDto foodRequest) {
    return foodService.saveFood(foodRequest);
  }
}
