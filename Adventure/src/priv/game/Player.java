package priv.game;

public class Player {
  final Integer THINK = 40;
  
  String name = null;
  Integer maxPower = null;
  Integer power = null;
  Integer atk = null;
  Integer def = null;
  Integer maxPoint = null;
  Integer point = null;
  Profession pro = null;
  
  Integer primStu = null;
  
  Player(String n) {
    name = n;
    maxPower = 100;
    power = 100;
    atk = 12;
    def = 1;
    maxPoint = 15;
    point = 15;
    
    primStu = 0;
  }
  
  String getName() {
    return name;
  }
  
  Integer getMaxPower() {
    return maxPower;
  }
  
  void addMaxPower(Integer p) {
    maxPower += p;
  }
  
  Integer getPower() {
    return power;
  }
  
  int addPower(Integer p) {
    power += p;
    if (power <= maxPower) return p;
    int t = power - maxPower;
    power -= t;
    return p-t;
  }
  
  int subPower(Integer p) {
    p = p * (100 - def) / 100;
    power -= p;
    if (power >= 0) return p;
    int t = power;
    power = 0;
    return p+t;
  }
  
  Boolean isLose() {
    return power <= 0;
  }

  Integer getAtk() {
    return atk;
  }
  
  void addAtk(Integer a) {
    atk += a;
  }

  Integer getDef() {
    return def;
  }
  
  void addDef(Integer d) {
    def += d;
  }
  
  Integer getMaxPoint() {
    return maxPoint;
  }
  
  Integer getPoint() {
    return point;
  }
  
  Boolean subPoint() {
    if (point > 0) {
      --point;
      return true;
    }
    return false;
  }
  
  void subPoint(Integer n) {
    point -= n;
    point = Math.max(point, 0);
  }
  
  void rePoint() {
    point = maxPoint;
  }
  
  int getPrimStu() {
    return primStu;
  }
  
  int think() {
    return addPower(maxPower * THINK/100);
  }
  
  int study() {
    ++primStu;
    return getPrimStu();
  }
}
