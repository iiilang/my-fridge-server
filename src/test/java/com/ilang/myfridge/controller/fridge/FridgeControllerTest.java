package com.ilang.myfridge.controller.fridge;

import com.ilang.myfridge.dto.fridge.FridgeSaveRequestDto;
import com.ilang.myfridge.model.fridge.FridgeType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FridgeControllerTest {

    @LocalServerPort
    private int port;

    @Test
    public void 냉장고생성() {
        //given
        String fridgeName = "김치냉장고";
        String fridgeIcon = "아이콘1";
        String fridgeBasic = "true";
        FridgeType fridgeType = FridgeType.REFRE;

        //when
        FridgeSaveRequestDto fridgeSaveRequestDto =
            FridgeSaveRequestDto.builder().fridgeName(fridgeName).fridgeIcon(fridgeIcon).fridgeBasic(fridgeBasic).fridgeType(fridgeType).build();

        //then
    }
}
