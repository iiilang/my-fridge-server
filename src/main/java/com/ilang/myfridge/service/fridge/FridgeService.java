package com.ilang.myfridge.service.fridge;

import com.ilang.myfridge.controller.exception.ErrorCode;
import com.ilang.myfridge.controller.exception.NotFoundException;
import com.ilang.myfridge.dto.fridge.FridgeListResponseDto;
import com.ilang.myfridge.dto.fridge.FridgeSaveRequestDto;
import com.ilang.myfridge.model.fridge.Fridge;
import com.ilang.myfridge.repository.fridge.FridgeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class FridgeService {

    private final FridgeRepository fridgeRepository;

    @Transactional
    public Long saveFridge(FridgeSaveRequestDto fridgeSaveRequestDto) {
        validateSameName(fridgeSaveRequestDto.getFridgeName());
        return fridgeRepository.save(Fridge.from(fridgeSaveRequestDto)).getId();
    }

    private void validateSameName(String name) {
        fridgeRepository.findByName(name);
    }

    public Fridge findFridgeDetail(Long fridgeId) {
        return fridgeRepository.findById(fridgeId).orElseThrow(
                () -> new NotFoundException(
                        ErrorCode.FRIDGE_NOT_FOUND.getErrorCode(),
                        ErrorCode.FRIDGE_NOT_FOUND.getErrorMessage()));
    }

    @Transactional
    public void delete(Long id) {
        Fridge fridge = fridgeRepository.findById(id).orElseThrow(
                () -> new NotFoundException(
                        ErrorCode.FRIDGE_NOT_FOUND.getErrorCode(),
                        ErrorCode.FRIDGE_NOT_FOUND.getErrorMessage()));
        fridgeRepository.delete(fridge);
    }

    @Transactional
    public List<FridgeListResponseDto> findAllDesc() {
        return fridgeRepository.findAllDesc().stream()
                .map(FridgeListResponseDto::new)
                .collect(Collectors.toList());
    }
}
