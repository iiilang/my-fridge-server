package com.ilang.myfridge.model.food;

import com.ilang.myfridge.model.BaseTimeEntity;
import com.ilang.myfridge.model.fridge.Fridge;
import java.time.LocalDate;
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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Entity
public class Food extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 50, nullable = false)
  private String foodName;

  @Enumerated(EnumType.STRING)
  @Column(length = 20, nullable = false)
  private FoodType foodType;

  @Column(columnDefinition = "text default null")
  private String foodMemo;

  @Column private LocalDate expireAt;

  @ManyToOne
  @JoinColumn(name = "fridgeId")
  private Fridge fridge;

  public static Food of(
      String foodName, FoodType foodType, String foodMemo, LocalDate expireAt, Fridge fridge) {
    return new Food(null, foodName, foodType, foodMemo, expireAt, fridge);
  }

  public Food update(String foodName, FoodType foodType, String foodMemo, LocalDate expireAt) {
    this.foodName = foodName;
    this.foodType = foodType;
    this.foodMemo = foodMemo;
    this.expireAt = expireAt;
    return this;
  }
}
