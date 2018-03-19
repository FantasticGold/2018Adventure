package priv.game;

public class Load {
  Integer gTime = null;
  String gPlace = null;
  Player gPlayer = null;
  
  Load(String n) {
    gTime = 0;
    gPlace = "����ѧԺ";
    gPlayer = new Player(n);
  }
  
  String getTime() {
    String ss = "";
    switch (gTime % 4) {
      case 0:
        ss = "��";
        break;
      case 1:
        ss = "��";
        break;
      case 2:
        ss = "��";
        break;
      case 3:
        ss = "��";
        break;
    }
    return "����" + (201 + gTime/4) + "�� " + ss;
  }
  
  void addTime() {
    ++gTime;
    gPlayer.rePoint();
  }
  
  String getPlace() {
    return gPlace;
  }
  
  void setPlace(String p) {
    gPlace = p;
  }
  
  Player getPlayer() {
    return gPlayer;
  }
   
  void setPlayer(Player p) {
    gPlayer = p;
  }
}
