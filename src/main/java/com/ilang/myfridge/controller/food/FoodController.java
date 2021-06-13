package com.ilang.myfridge.controller.food;

import com.ilang.myfridge.dto.food.FoodDetailResponseDto;
import com.ilang.myfridge.dto.food.FoodRequestDto;
import com.ilang.myfridge.dto.food.FoodResponseDto;
import com.ilang.myfridge.model.food.Food;
import com.ilang.myfridge.service.food.FoodService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/foods")
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class FoodController {

  private final FoodService foodService;

  @Operation(summary = "음식 정보 조회")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "Found Food Detail"),
        @ApiResponse(responseCode = "FO01", description = "Food Not Found")
      })
  @GetMapping("/{foodId}")
  public ResponseEntity<FoodDetailResponseDto> findByFoodId(@PathVariable Long foodId) {
    Food food = foodService.findFoodDetail(foodId);
    return ResponseEntity.ok(FoodDetailResponseDto.from(food));
  }

  @Operation(summary = "음식 목록 조회")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "Found Food List"),
        @ApiResponse(responseCode = "RE01", description = "Fridge Not Found")
      })
  @GetMapping("/list/{fridgeId}")
  public ResponseEntity<List<FoodResponseDto>> findByFridgeId(@PathVariable Long fridgeId) {
    List<Food> foodList = foodService.findFoodList(fridgeId);
    return ResponseEntity.ok(
        foodList.stream().map(FoodResponseDto::from).collect(Collectors.toList()));
  }

  @Operation(summary = "음식 저장")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "Food Saved"),
        @ApiResponse(responseCode = "RE01", description = "Fridge Not Found"),
        @ApiResponse(responseCode = "FO02", description = "Food Name Duplicated"),
        @ApiResponse(responseCode = "FO03", description = "Food Type Not Match")
      })
  @PostMapping("")
  public ResponseEntity<FoodResponseDto> saveFood(
      @RequestBody @Valid FoodRequestDto foodRequestDto) {

    Food food =
        foodService.saveFood(
            foodRequestDto.getFoodName(),
            foodRequestDto.getFoodType(),
            foodRequestDto.getFoodMemo(),
            foodRequestDto.getExpireAt(),
            foodRequestDto.getFridgeId());

    return ResponseEntity.ok(FoodResponseDto.from(food));
  }

  @Operation(summary = "음식 수정")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "Food Updated"),
        @ApiResponse(responseCode = "FO01", description = "Food Not Found"),
        @ApiResponse(responseCode = "FO02", description = "Food Name Duplicated"),
        @ApiResponse(responseCode = "FO03", description = "Food Type Not Match")
      })
  @PutMapping("/{foodId}")
  public ResponseEntity<FoodResponseDto> updateFood(
      @PathVariable Long foodId, @RequestBody @Valid FoodRequestDto foodRequestDto) {

    Food food =
        foodService.updateFood(
            foodId,
            foodRequestDto.getFoodName(),
            foodRequestDto.getFoodType(),
            foodRequestDto.getFoodMemo(),
            foodRequestDto.getExpireAt(),
            foodRequestDto.getFridgeId());

    return ResponseEntity.ok(FoodResponseDto.from(food));
  }

  @Operation(summary = "음식 삭제")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "204", description = "Food Deleted"),
        @ApiResponse(responseCode = "FO01", description = "Food Not Found")
      })
  @DeleteMapping("/{foodId}")
  public ResponseEntity deleteFood(@PathVariable Long foodId) {
    foodService.deleteFood(foodId);
    return ResponseEntity.noContent().build();
  }
}
