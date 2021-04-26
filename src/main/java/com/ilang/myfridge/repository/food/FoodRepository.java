package com.ilang.myfridge.repository.food;

import com.ilang.myfridge.model.food.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {}
