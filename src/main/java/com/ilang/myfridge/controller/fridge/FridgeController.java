package com.ilang.myfridge.controller.fridge;

import com.ilang.myfridge.dto.fridge.*;
import com.ilang.myfridge.model.fridge.Fridge;
import com.ilang.myfridge.service.fridge.FridgeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fridges")
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class FridgeController {

    private final FridgeService fridgeService;

    @Operation(summary = "냉장고 정보 조회")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Found Fridge Detail"),
                    @ApiResponse(responseCode = "RE01", description = "Fridge Not Found")
            })
    @GetMapping("/{fridgeId}")
    public ResponseEntity<FridgeDetailResponseDto> findByFridgeId(@PathVariable Long fridgeId) {
        Fridge fridge = fridgeService.findFridgeDetail(fridgeId);
        return ResponseEntity.ok(FridgeDetailResponseDto.from(fridge));
    }

    @Operation(summary = "냉장고 목록 조회")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Found Food List"),
                    @ApiResponse(responseCode = "RE01", description = "User Not Found")
            })
    @GetMapping("/list/{userId}")
    public ResponseEntity<List<FridgeResponseDto>> findByUserId(@PathVariable Long userId) {
        List<FridgeResponseDto> fridgeListResponses = fridgeService.findFridgeList(userId);
        return ResponseEntity.ok(fridgeListResponses);
    }

    @Operation(summary = "냉장고 저장")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "Fridge Saved"),
            @ApiResponse(responseCode = "RE01", description = "Fridge Not Found"),
            @ApiResponse(responseCode = "RE02", description = "Fridge Name Duplicated")
        })
    @PostMapping
    public ResponseEntity<FridgeSaveResponseDto> saveFridge(@RequestBody @Valid FridgeSaveRequestDto fridgeSaveRequestDto) {
        Fridge fridge = fridgeService.saveFridge(
                fridgeSaveRequestDto.getUserId(),
                fridgeSaveRequestDto.getFridgeName(),
                fridgeSaveRequestDto.getFridgeType(),
                fridgeSaveRequestDto.getFridgeMemo(),
                fridgeSaveRequestDto.isFridgeBasic(),
                fridgeSaveRequestDto.getFridgeIcon());
        return ResponseEntity.ok(FridgeSaveResponseDto.from(fridge));
    }

    @Operation(summary = "냉장고 수정")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "Fridge Updated"),
            @ApiResponse(responseCode = "RE01", description = "Fridge Not Found"),
            @ApiResponse(responseCode = "RE02", description = "Fridge Name Duplicated")
        })
    @PutMapping("/{fridgeId}")
    public ResponseEntity<FridgeDetailResponseDto> updateFridge(@PathVariable Long fridgeId, @RequestBody @Valid FridgeUpdateRequestDto fridgeUpdateRequestDto) {
        Fridge fridge = fridgeService.updateFridge(
                            fridgeId,
                            fridgeUpdateRequestDto.getFridgeName(),
                            fridgeUpdateRequestDto.getFridgeType(),
                            fridgeUpdateRequestDto.getFridgeMemo(),
                            fridgeUpdateRequestDto.isFridgeBasic(),
                            fridgeUpdateRequestDto.getFridgeIcon());
        return ResponseEntity.ok(FridgeDetailResponseDto.from(fridge));
    }

    @Operation(summary = "냉장고 삭제")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Fridge Deleted"),
                    @ApiResponse(responseCode = "RE01", description = "Fridge Not Found")
            })
    @DeleteMapping("/{fridgeId}")
    public ResponseEntity<Void> delete(@PathVariable Long fridgeId) {
        fridgeService.deleteFridge(fridgeId);
        return ResponseEntity.noContent().build();
    }
}
