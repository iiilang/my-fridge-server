package com.ilang.myfridge.service.fridge;

import com.ilang.myfridge.controller.exception.ErrorCode;
import com.ilang.myfridge.controller.exception.NotFoundException;
import com.ilang.myfridge.dto.fridge.FridgeResponseDto;
import com.ilang.myfridge.model.fridge.Fridge;
import com.ilang.myfridge.model.fridge.FridgeType;
import com.ilang.myfridge.model.user.User;
import com.ilang.myfridge.repository.fridge.FridgeRepository;
import com.ilang.myfridge.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FridgeService {

    private final FridgeRepository fridgeRepository;
    private final UserRepository userRepository;

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

        User user = userRepository.findById(userId)
                .orElseThrow(() -> NotFoundException.of(ErrorCode.USER_NOT_FOUND));

        if (fridgeNameExist(user, fridgeName)) {
            throw NotFoundException.of(ErrorCode.FRIDGE_NAME_DUPLICATED);
        }

        return fridgeRepository.save(Fridge.of(fridgeName, fridgeType, fridgeMemo, fridgeBasic, fridgeIcon, user));
    }

    @Transactional
    public Fridge updateFridge(
            Long fridgeId, String fridgeName, String fridgeIcon, String fridgeBasic, String fridgeMemo) {
        Fridge fridge = fridgeRepository
                .findById(fridgeId)
                .orElseThrow(() -> NotFoundException.of(ErrorCode.FRIDGE_NOT_FOUND));

        if (fridgeNameExist(fridge.getUser().getId(), fridgeId, fridgeName)) {
            throw NotFoundException.of(ErrorCode.FRIDGE_NAME_DUPLICATED);
        }

        return fridge.update(fridgeName, fridgeIcon, fridgeBasic, fridgeMemo);
    }

    @Transactional
    public void deleteFridge(Long id) {
      Fridge fridge =
          fridgeRepository
              .findById(id)
              .orElseThrow(() -> NotFoundException.of(ErrorCode.FRIDGE_NOT_FOUND));
      fridgeRepository.delete(fridge);
    }

    @Transactional
    public List<FridgeResponseDto> findFridgeList(Long userId) {
        return fridgeRepository.findAllByUserId(userId).stream()
                .map(FridgeResponseDto::from)
                .collect(Collectors.toList());
    }

    private boolean fridgeNameExist(User user, String fridgeName) {
        List<String> fridgeNames = fridgeRepository.findAllByUser(user).stream()
                .map(Fridge::getFridgeName)
                .filter(fridge -> fridge.equals(fridgeName))
                .collect(Collectors.toList());

        return !(fridgeNames.isEmpty());
    }

    private boolean fridgeNameExist(Long userId, Long fridgeId, String fridgeName) {
        List<String> fridgeNames = fridgeRepository.findAllByUserId(userId).stream()
                .filter(fridge -> !(fridgeId.equals(fridge.getId())))
                .map(Fridge::getFridgeName)
                .filter(fridge -> fridge.equals(fridgeName))
                .collect(Collectors.toList());

        return !(fridgeNames.isEmpty());
    }
}
