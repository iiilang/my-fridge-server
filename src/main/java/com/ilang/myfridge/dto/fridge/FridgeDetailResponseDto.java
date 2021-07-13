package com.ilang.myfridge.dto.fridge;

import com.ilang.myfridge.model.fridge.Fridge;
import com.ilang.myfridge.model.fridge.FridgeType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FridgeDetailResponseDto {

    private Long fridgeId;
    private String fridgeIcon;
    private String fridgeName;
    private FridgeType fridgeType;
    private boolean fridgeBasic;
    private String fridgeMemo;

    public static FridgeDetailResponseDto from(Fridge fridge) {
        return new FridgeDetailResponseDto(
            fridge.getId(),
            fridge.getFridgeIcon(),
            fridge.getFridgeName(),
            fridge.getFridgeType(),
            fridge.isFridgeBasic(),
            fridge.getFridgeMemo());
    }
}
