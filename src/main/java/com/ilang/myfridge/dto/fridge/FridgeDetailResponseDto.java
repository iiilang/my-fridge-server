package com.ilang.myfridge.dto.fridge;

import com.ilang.myfridge.model.fridge.Fridge;
import com.ilang.myfridge.model.fridge.FridgeType;

public class FridgeDetailResponseDto {

    private Long id;
    private String fridgeIcon;
    private String fridgeName;
    private FridgeType fridgeType;
    private String fridgeBasic;
    private String fridgeMemo;

    public FridgeDetailResponseDto(Long id, String fridgeIcon, String fridgeName, FridgeType fridgeType, String fridgeBasic, String fridgeMemo) {
        this.id = id;
        this.fridgeIcon = fridgeIcon;
        this.fridgeName = fridgeName;
        this.fridgeType = fridgeType;
        this.fridgeBasic = fridgeBasic;
        this.fridgeMemo = fridgeMemo;
    }

    public static FridgeDetailResponseDto from(Fridge fridge) {
        return new FridgeDetailResponseDto(
            fridge.getId(),
            fridge.getFridgeIcon(),
            fridge.getFridgeName(),
            fridge.getFridgeType(),
            fridge.getFridgeBasic(),
            fridge.getFridgeMemo());
    }
}
