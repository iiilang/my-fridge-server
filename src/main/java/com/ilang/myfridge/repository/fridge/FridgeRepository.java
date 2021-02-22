package com.ilang.myfridge.repository.fridge;

import com.ilang.myfridge.model.fridge.Fridge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FridgeRepository extends JpaRepository<Fridge, Long> {}
