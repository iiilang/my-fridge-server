package com.ilang.myfridge.dto.fridge;

import com.ilang.myfridge.model.fridge.Fridge;
import com.ilang.myfridge.model.fridge.FridgeType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FridgeSaveResponseDto {

    private Long fridgeId;
    private String fridgeName;
    private String fridgeIcon;
    private boolean fridgeBasic;
    private FridgeType fridgeType;
    private String fridgeMemo;

    public static FridgeSaveResponseDto from(Fridge fridge) {
        return new FridgeSaveResponseDto(
            fridge.getId(),
            fridge.getFridgeName(),
            fridge.getFridgeIcon(),
            fridge.isFridgeBasic(),
            fridge.getFridgeType(),
            fridge.getFridgeMemo());
    }
}
