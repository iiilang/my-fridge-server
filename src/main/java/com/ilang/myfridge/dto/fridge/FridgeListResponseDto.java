package com.ilang.myfridge.dto.fridge;

import com.ilang.myfridge.model.fridge.Fridge;
import com.ilang.myfridge.model.fridge.FridgeType;

public class FridgeListResponseDto {
    private Long id;
    private String fridgeIcon;
    private String fridgeName;
    private FridgeType fridgeType;
    private String fridgeMemo;
    private String fridgeBasic;

    public FridgeListResponseDto(Fridge fridge) {
        this.id = id;
        this.fridgeIcon = fridge.getFridgeIcon();
        this.fridgeName = fridge.getFridgeName();
        this.fridgeType = fridge.getFridgeType();
        this.fridgeMemo = fridge.getFridgeMemo();
        this.fridgeBasic = fridge.getFridgeBasic();
    }
}
