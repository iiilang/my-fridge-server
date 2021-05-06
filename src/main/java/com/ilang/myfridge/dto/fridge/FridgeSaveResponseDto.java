package com.ilang.myfridge.dto.fridge;

import com.ilang.myfridge.model.fridge.Fridge;
import com.ilang.myfridge.model.fridge.FridgeType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FridgeSaveResponseDto {

    private Long userid;
    private String fridgeName;
    private String fridgeIcon;
    private String fridgeBasic;
    private FridgeType fridgeType;
    private String fridgeMemo;

    public static FridgeSaveResponseDto from(Fridge fridge) {
        return new FridgeSaveResponseDto(
            fridge.getId(),
            fridge.getFridgeName(),
            fridge.getFridgeIcon(),
            fridge.getFridgeBasic(),
            fridge.getFridgeType(),
            fridge.getFridgeMemo());
    }
}
