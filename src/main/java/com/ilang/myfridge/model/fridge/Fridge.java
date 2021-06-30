package com.ilang.myfridge.model.fridge;

import com.ilang.myfridge.model.BaseTimeEntity;
import com.ilang.myfridge.model.user.User;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Fridge extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 30, nullable = false)
  private String fridgeIcon;

  @Column(length = 50, nullable = false)
  private String fridgeName;

  @Enumerated(EnumType.STRING)
  @Column(length = 20, nullable = false)
  private FridgeType fridgeType;

  @Column(columnDefinition = "text default null")
  private String fridgeMemo;

  @Column(length = 3, nullable = false)
  private String fridgeBasic;

  @ManyToOne(cascade= CascadeType.ALL)
  @JoinColumn(name = "userid")
  private User user;

  public static Fridge of(String fridgeName, FridgeType fridgeType, String fridgeMemo, String fridgeBasic, String fridgeIcon, User user) {
    return new Fridge(null, fridgeIcon, fridgeName, fridgeType, fridgeMemo, fridgeBasic, user);
  }

  public Fridge update(String fridgeName, FridgeType fridgeType, String fridgeMemo, String fridgeBasic, String fridgeIcon) {
    this.fridgeName = fridgeName;
    this.fridgeType = fridgeType;
    this.fridgeMemo = fridgeMemo;
    this.fridgeBasic = fridgeBasic;
    this.fridgeIcon = fridgeIcon;
    return this;
  }
}
