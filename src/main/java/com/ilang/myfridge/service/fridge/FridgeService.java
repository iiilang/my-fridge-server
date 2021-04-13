package com.ilang.myfridge.service.fridge;

import com.ilang.myfridge.controller.exception.ErrorCode;
import com.ilang.myfridge.controller.exception.NotFoundException;
import com.ilang.myfridge.dto.fridge.FridgeSaveRequestDto;
import com.ilang.myfridge.model.fridge.Fridge;
import com.ilang.myfridge.repository.fridge.FridgeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class FridgeService {

    private final FridgeRepository fridgeRepository;

    @Transactional
    public Long saveFridge(FridgeSaveRequestDto fridgeSaveRequestDto) {
        return fridgeRepository.save(Fridge.from(fridgeSaveRequestDto)).getId();
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
}
