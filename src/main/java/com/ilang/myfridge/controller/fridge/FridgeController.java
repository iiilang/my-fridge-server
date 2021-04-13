package com.ilang.myfridge.controller.fridge;

import com.ilang.myfridge.dto.fridge.FridgeDetailResponseDto;
import com.ilang.myfridge.dto.fridge.FridgeSaveRequestDto;
import com.ilang.myfridge.service.fridge.FridgeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fridge")
@AllArgsConstructor
public class FridgeController {

    private final FridgeService fridgeService;

    @Operation(summary = "냉장고 id로 냉장고 상세 정보 조회")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "2001", description = "Fridge Not Found")
            })
    @GetMapping("/{fridgeId}")
    public FridgeDetailResponseDto findByFridgeId(@PathVariable Long fridgeId) {
        return FridgeDetailResponseDto.from(fridgeService.findFridgeDetail(fridgeId));
    }

    @PostMapping("/save")
    public Long saveFridge(@RequestBody FridgeSaveRequestDto fridgeSaveRequestDto) {
        return fridgeService.saveFridge(fridgeSaveRequestDto);
    }

    @DeleteMapping("/{fridgeId}")
    public Long delete(@PathVariable Long id) {
        fridgeService.delete(id);
        return id;
    }
}
