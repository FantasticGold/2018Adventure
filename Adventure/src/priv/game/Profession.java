package priv.game;

public enum Profession {
  WARRIOR("սʿ"), ASSASSIN("�̿�"), MAGE("��ʦ");
  
  String name;
  
  Profession(String s) {
    name = s;
  }
  
  public String toString() {
    return name;
  }
}
