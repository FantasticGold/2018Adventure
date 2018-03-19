package priv.game;

public enum Profession {
  WARRIOR("战士"), ASSASSIN("刺客"), MAGE("法师");
  
  String name;
  
  Profession(String s) {
    name = s;
  }
  
  public String toString() {
    return name;
  }
}
