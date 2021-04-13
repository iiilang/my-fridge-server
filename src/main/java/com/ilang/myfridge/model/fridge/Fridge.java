package com.ilang.myfridge.model.fridge;

import com.ilang.myfridge.dto.fridge.FridgeSaveRequestDto;
import com.ilang.myfridge.model.BaseTimeEntity;
import com.ilang.myfridge.model.user.User;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Fridge extends BaseTimeEntity {
  public static Fridge from(FridgeSaveRequestDto fridgeSaveRequestDto) {
    Fridge fridge = new Fridge();

    fridge.fridgeName = fridgeSaveRequestDto.getFridgeName();
    fridge.fridgeIcon = fridgeSaveRequestDto.getFridgeIcon();
    fridge.fridgeBasic = fridgeSaveRequestDto.getFridgeBasic();
    fridge.fridgeType = fridgeSaveRequestDto.getFridgeType();
    fridge.user = new User(fridgeSaveRequestDto.getUserid());
    fridge.fridgeMemo = fridgeSaveRequestDto.getFridgeMemo();

    return fridge;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 30, nullable = false)
  private String fridgeIcon;

  @Column(length = 50, nullable = false)
  private String fridgeName;

  @Enumerated(EnumType.STRING)
  @Column(length = 10, nullable = false)
  private FridgeType fridgeType;

  @Column(columnDefinition = "text default null")
  private String fridgeMemo;

  @Column(length = 3, nullable = false)
  private String fridgeBasic;

  @ManyToOne(cascade= CascadeType.ALL)
  @JoinColumn(name = "userid")
  private User user;
}
