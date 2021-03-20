package com.ilang.myfridge.model.food;

import com.ilang.myfridge.dto.food.FoodRequestDto;
import com.ilang.myfridge.model.BaseTimeEntity;
import com.ilang.myfridge.model.fridge.Fridge;
import com.ilang.myfridge.repository.food.FoodRepository;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
// (access = AccessLevel.PROTECTED)
@Entity
public class Food extends BaseTimeEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 50, nullable = false)
  private String foodName;

  @Enumerated(EnumType.STRING)
  @Column(length = 15, nullable = false)
  private FoodType foodType;

  @Column(columnDefinition = "text default null")
  private String foodMemo;

  @Column private LocalDateTime expireAt;

  @ManyToOne
  @JoinColumn(name = "fridgeId")
  private Fridge fridge;

  public static Food from(FoodRequestDto foodRequestDto) {
    Food food = new Food();
    food.foodName = foodRequestDto.getFoodName();
    food.foodMemo = foodRequestDto.getFoodMemo();
    food.foodType = foodRequestDto.getFoodType();
    return food;
  }
}