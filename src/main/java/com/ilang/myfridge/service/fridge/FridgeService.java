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
        Fridge fridge = fridgeRepository
                .findById(fridgeId)
                .orElseThrow(() -> NotFoundException.of(ErrorCode.FRIDGE_NOT_FOUND));

        return fridge;
    }

    @Transactional
    public Fridge saveFridge(
            Long userId, String fridgeName, FridgeType fridgeType, String fridgeMemo, String fridgeBasic, String fridgeIcon) {
        if (fridgeNameExist(userId, fridgeName)) {
            throw NotFoundException.of(ErrorCode.FRIDGE_NAME_DUPLICATED);
        }

        return fridgeRepository.save(Fridge.of(fridgeName, fridgeType, fridgeMemo, fridgeBasic, fridgeIcon));
    }

    private void validateSameName(String name) {
        if (fridgeRepository.findByFridgeName(name).isPresent()) {
            throw NotFoundException.of(ErrorCode.FRIDGE_NAME_DUPLICATED);
        }
    }

    @Transactional
    public void deleteFridge(Long id) {
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

    private boolean fridgeNameExist(Long userId, String fridgeName) {
        List<String> fridgeNames = fridgeRepository.findAllByUserId(userId).stream()
                .map(Fridge::getFridgeName)
                .filter(fridge -> fridge.equals(fridgeName))
                .collect(Collectors.toList());

        return !(fridgeNames.isEmpty());
    }

    private boolean fridgeNameExist(Long userId, Long fridgeId, String fridgeName) {
        List<String> fridgeNames = fridgeRepository.findAllByUserId(userId).stream()
                .filter(fridge -> !(fridge.equals(fridgeId)))
                .map(Fridge::getFridgeName)
                .filter(fridge -> fridge.equals(fridgeName))
                .collect(Collectors.toList());

        return !(fridgeNames.isEmpty());
    }
}
