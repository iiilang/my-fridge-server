package com.ilang.myfridge.model.fridge;

import com.ilang.myfridge.model.BaseTimeEntity;
import com.ilang.myfridge.model.user.User;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

  @Column(length = 10, nullable = false)
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

  @ManyToOne
  @JoinColumn(name = "userId")
  private User user;
}
