package priv.game;

import java.util.Random;

import javafx.util.*;

public class RandS {
  PerEvt [] events;
  RandS(PerEvt [] es) {
    events = es;
  }
  String getAns() {
    Integer [] nums = new Integer[events.length];
    nums[0] = events[0].num;
    for (int i = 1; i < events.length; ++i) {
      nums[i] = nums[i-1] + events[i].num;
    }
    
    int ans = new Random().nextInt(100);
    for (int i = 0; i < events.length; ++i) {
      if (ans < nums[i]) return events[i].str;
    }
    return "";
  }
}
