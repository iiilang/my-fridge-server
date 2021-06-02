package com.ilang.myfridge.dto.fridge;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FridgeUpdateRequestDto {

    @NotEmpty private String fridgeName;
    @NotNull private String fridgeIcon;
    @NotNull private String fridgeBasic;
    private String fridgeMemo;
}
