package com.ilang.myfridge.controller.fridge;

import com.ilang.myfridge.dto.fridge.FridgeDetailResponseDto;
import com.ilang.myfridge.dto.fridge.FridgeListResponseDto;
import com.ilang.myfridge.dto.fridge.FridgeSaveRequestDto;
import com.ilang.myfridge.dto.fridge.FridgeSaveResponseDto;
import com.ilang.myfridge.model.fridge.Fridge;
import com.ilang.myfridge.service.fridge.FridgeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fridge")
@AllArgsConstructor
public class FridgeController {

    private final FridgeService fridgeService;

    @Operation(summary = "냉장고 id로 냉장고 상세 정보 조회")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "RE01", description = "Fridge Not Found")
            })
    @GetMapping("/{fridgeId}")
    public ResponseEntity<FridgeDetailResponseDto> findByFridgeId(@PathVariable Long fridgeId) {
        Fridge fridge = fridgeService.findFridgeDetail(fridgeId);
        return ResponseEntity.ok(FridgeDetailResponseDto.from(fridge));
    }

    @Operation(summary = "냉장고 저장")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "RE01", description = "Fridge Not Found")
        })
    @PostMapping("/save")
    public ResponseEntity<FridgeSaveResponseDto> saveFridge(@RequestBody @Valid FridgeSaveRequestDto fridgeSaveRequestDto) {
        Fridge fridge = fridgeService.saveFridge(
                fridgeSaveRequestDto.getFridgeName(),
                fridgeSaveRequestDto.getFridgeType(),
                fridgeSaveRequestDto.getFridgeMemo(),
                fridgeSaveRequestDto.getFridgeBasic(),
                fridgeSaveRequestDto.getFridgeIcon());
        return ResponseEntity.ok(FridgeSaveResponseDto.from(fridge));
    }

    @Operation(summary = "냉장고 목록조회")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "RE01", description = "Fridge Not Found")
            })
    @GetMapping("/list")
    public ResponseEntity<List<FridgeListResponseDto>> findAll() {
        List<FridgeListResponseDto> fridgeListResponses = fridgeService.findAllDesc();
        return ResponseEntity.ok(fridgeListResponses);
    }

    @Operation(summary = "냉장고 id로 삭제")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "RE01", description = "Fridge Not Found")
            })
    @DeleteMapping("/{fridgeId}")
    public ResponseEntity delete(@PathVariable Long fridgeId) {
        fridgeService.delete(fridgeId);
        return ResponseEntity.noContent().build();
    }
}
