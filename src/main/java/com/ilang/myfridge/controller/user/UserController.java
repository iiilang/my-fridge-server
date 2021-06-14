package com.ilang.myfridge.controller.user;

import com.ilang.myfridge.dto.user.UserResponseDto;
import com.ilang.myfridge.dto.user.UserSaveRequestDto;
import com.ilang.myfridge.model.user.User;
import com.ilang.myfridge.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class UserController {

    private final UserService userService;

    @Operation(summary = "유저 저장")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "User Saved")
        })
    @PostMapping
    public ResponseEntity<UserResponseDto> saveUser(@RequestBody @Valid UserSaveRequestDto userSaveRequestDto) {
        User user = userService.saveUser(userSaveRequestDto.getUuid());
        return ResponseEntity.ok(UserResponseDto.from(user));
    }
}
