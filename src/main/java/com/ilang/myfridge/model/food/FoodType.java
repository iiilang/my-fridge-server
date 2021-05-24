package com.ilang.myfridge.model.food;

import com.ilang.myfridge.model.fridge.FridgeType;

public enum FoodType {
  REFRIGERATED {
    public boolean typeMatch(FridgeType fridgeType) {
      return (fridgeType.equals(FridgeType.REFRIGERATOR));
    }
  },
  FROZEN {
    public boolean typeMatch(FridgeType fridgeType) {
      return (fridgeType.equals(FridgeType.REFRIGERATOR));
    }
  },
  ROOM {
    public boolean typeMatch(FridgeType fridgeType) {
      return (fridgeType.equals(FridgeType.ROOM));
    }
  };

  public abstract boolean typeMatch(FridgeType fridgeType);
}
