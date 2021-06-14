package com.ilang.myfridge.repository.user;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.ilang.myfridge.model.user.User;
import com.ilang.myfridge.repository.user.UserRepository;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserRepositoryTest {

  @Autowired UserRepository userRepository;

  @Test
  public void 유저정보저장_불러오기() {
    // given
    String uuid = "abcdefghijklmnop";

    userRepository.save(User.builder().uuid(uuid).build());

    // when
    List<User> userLists = userRepository.findAll();

    // then
    User user = userLists.get(0);
    assertThat(user.getUuid()).isEqualTo(uuid);
  }
}
