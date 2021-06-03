package com.ilang.myfridge.dto.fridge;

import com.ilang.myfridge.model.fridge.Fridge;
import com.ilang.myfridge.model.fridge.FridgeType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FridgeResponseDto {
    private Long fridgeId;
    private String fridgeIcon;
    private String fridgeName;
    private FridgeType fridgeType;
    private String fridgeMemo;
    private String fridgeBasic;

    public static FridgeResponseDto from(Fridge fridge) {
        return new FridgeResponseDto(
                fridge.getId(),
                fridge.getFridgeIcon(),
                fridge.getFridgeName(),
                fridge.getFridgeType(),
                fridge.getFridgeMemo(),
                fridge.getFridgeBasic());
    }
}
