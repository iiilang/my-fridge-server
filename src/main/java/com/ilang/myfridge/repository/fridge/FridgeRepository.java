package com.ilang.myfridge.repository.fridge;

import com.ilang.myfridge.model.fridge.Fridge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FridgeRepository extends JpaRepository<Fridge, Long> {

    List<Fridge> findAllDesc();

    Optional<Fridge> findByFridgeName(String name);
}
