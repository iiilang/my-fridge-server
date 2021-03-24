package com.ilang.myfridge.controller.food;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class FoodControllerTest {

  @LocalServerPort private int port;

//  @Test
//  public void 음식상세조회() throws Exception {
//    // given
//    String foodName = "가지";
//    String foodType = "ROOM";
//    Long fridgeId = 1L;
//
//    FoodRequestDto requestDto =
//        FoodRequestDto.builder().foodName(foodName).foodType(foodType).fridgeId(fridgeId).build();
//
//    String url = "http://localhost:" + port + "/api/v1/posts";
//
//    // when
//  }
}
