package com.ilang.myfridge.service.fridge;

import com.ilang.myfridge.controller.exception.ErrorCode;
import com.ilang.myfridge.controller.exception.NotFoundException;
import com.ilang.myfridge.dto.fridge.FridgeListResponseDto;
import com.ilang.myfridge.model.fridge.Fridge;
import com.ilang.myfridge.model.fridge.FridgeType;
import com.ilang.myfridge.repository.fridge.FridgeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FridgeService {

    private final FridgeRepository fridgeRepository;

    @Transactional
    public Fridge findFridgeDetail(Long fridgeId) {
        Fridge fridge = fridgeRepository.findById(fridgeId).orElseThrow(
                () -> NotFoundException.of(ErrorCode.FRIDGE_NOT_FOUND));
        return fridge;
    }

    @Transactional
    public Fridge saveFridge(
            String fridgeName, FridgeType fridgeType, String fridgeMemo, String fridgeBasic, String fridgeIcon) {
        validateSameName(fridgeName);
        return fridgeRepository.save(Fridge.of(fridgeName, fridgeType, fridgeMemo, fridgeBasic, fridgeIcon));
    }

    private void validateSameName(String name) {
        if (fridgeRepository.findByFridgeName(name).isPresent()) {
            throw NotFoundException.of(ErrorCode.FRIDGE_NAME_DUPLICATED);
        }
    }

    @Transactional
    public void delete(Long id) {
        Fridge fridge = fridgeRepository.findById(id).orElseThrow(
                () -> NotFoundException.of(ErrorCode.FRIDGE_NOT_FOUND));
        fridgeRepository.delete(fridge);
    }

    @Transactional
    public List<FridgeListResponseDto> findAllDesc() {
        return fridgeRepository.findAllDesc().stream()
                .map(FridgeListResponseDto::from)
                .collect(Collectors.toList());
    }
}
