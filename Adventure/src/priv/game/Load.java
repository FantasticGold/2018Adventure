package priv.game;

public class Load {
  Integer gTime = null;
  String gPlace = null;
  Player gPlayer = null;
  
  Load(String n) {
    gTime = 0;
    gPlace = "极星学院";
    gPlayer = new Player(n);
  }
  
  String getTime() {
    String ss = "";
    switch (gTime % 4) {
      case 0:
        ss = "春";
        break;
      case 1:
        ss = "夏";
        break;
      case 2:
        ss = "秋";
        break;
      case 3:
        ss = "冬";
        break;
    }
    return "星历" + (201 + gTime/4) + "年 " + ss;
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
