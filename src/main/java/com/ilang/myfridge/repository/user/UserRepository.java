package com.ilang.myfridge.repository.user;

import com.ilang.myfridge.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
