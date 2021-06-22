package com.ilang.myfridge.dto.user;

import com.ilang.myfridge.model.user.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponseDto {

    private Long id;
    private String uuid;

    public static UserResponseDto from(User user) {
        return new UserResponseDto(
            user.getId(),
            user.getUuid());
    }
}
