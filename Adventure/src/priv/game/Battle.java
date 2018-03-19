package priv.game;

public class Battle {
  Player p1 = null;
  Player p2 = null;
  Integer con = null;
  Battle(Player p1, Player p2) {
    this.p1 = p1;
    this.p2 = p2;
  }
  String start() {
    String str = "";
    con = 1;
    while (true) {
      if (con == 1) {
        str += "<" + p1.name + ">��<" + p2.name + ">���" + p2.subPower(p1.atk) + "�˺�\n";
        if (p2.isLose()) {
          str += "<" + p1.name + ">�����<" + p2.name + ">";
          p2.addPower(p2.getMaxPower());
          break;
        }
      } else {
        str += "<" + p2.name + ">��<" + p1.name + ">���" + p1.subPower(p2.atk) + "�˺�\n";
        if (p1.isLose()) {
          str += "<" + p2.name + ">�����<" + p1.name + ">\n";
          p1.subPoint(3);
          str += "�Դ���Ϣ���ж���-3������+" + p1.addPower(p2.getMaxPower());
          break;
        }
      }
      
      con = 3-con;
    }
    return str;
  }
}
