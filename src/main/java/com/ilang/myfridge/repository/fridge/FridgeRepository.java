package com.ilang.myfridge.repository.fridge;

import com.ilang.myfridge.model.fridge.Fridge;
import com.ilang.myfridge.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FridgeRepository extends JpaRepository<Fridge, Long> {
    List<Fridge> findAllByUser(User user);

    List<Fridge> findAllByUserId(Long userId);
}
