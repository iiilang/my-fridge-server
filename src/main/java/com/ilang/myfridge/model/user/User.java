package com.ilang.myfridge.model.user;

import com.ilang.myfridge.model.BaseTimeEntity;
import com.ilang.myfridge.model.fridge.Fridge;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 40, nullable = false)
  private String uuid;

  @OneToMany(mappedBy = "user")
  private List<Fridge> fridgeList;

  private User(String uuid) {
    this.uuid = uuid;
  }

  public static User from(String uuid) {
    return new User(uuid);
  }
}
