package com.ilang.myfridge.dto.fridge;

import com.ilang.myfridge.model.fridge.Fridge;
import com.ilang.myfridge.model.fridge.FridgeType;
import com.ilang.myfridge.model.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FridgeSaveRequestDto {

    private String userid;
    private String fridgeName;
    private String fridgeIcon;
    private String fridgeBasic;
    private FridgeType fridgeType;
    private String fridgeMemo;

    @Builder
    public FridgeSaveRequestDto(String userid, String fridgeName, String fridgeIcon, String fridgeBasic, FridgeType fridgeType, String fridgeMemo) {
        this.userid = userid;
        this.fridgeName = fridgeName;
        this.fridgeIcon = fridgeIcon;
        this.fridgeBasic = fridgeBasic;
        this.fridgeType = fridgeType;
        this.fridgeMemo = fridgeMemo;
    }
}
