package com.ilang.myfridge.controller.food;

import com.ilang.myfridge.dto.food.FoodDetailResponseDto;
import com.ilang.myfridge.dto.food.FoodSaveRequestDto;
import com.ilang.myfridge.model.food.Food;
import com.ilang.myfridge.service.food.FoodService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/food")
@RequiredArgsConstructor
public class FoodController {

  private final FoodService foodService;

  @Operation(summary = "음식 id로 음식 상세 정보 조회")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "OK"),
        @ApiResponse(responseCode = "2001", description = "Food Not Found")
      })
  @GetMapping("/{foodId}")
  public FoodDetailResponseDto findByFoodId(@PathVariable Long foodId) {
    Food food = foodService.findFoodDetail(foodId);
    return FoodDetailResponseDto.from(food);
  }

  @PostMapping("/save")
  public Long saveFood(@RequestBody FoodSaveRequestDto foodRequest) {
    return foodService.saveFood(foodRequest);
  }
}
