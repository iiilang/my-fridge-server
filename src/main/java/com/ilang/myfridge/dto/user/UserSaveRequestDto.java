package com.ilang.myfridge.dto.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserSaveRequestDto {

    @NotNull
    @Size(max = 40)
    private String uuid;
}
