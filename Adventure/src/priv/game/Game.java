package priv.game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Game implements Runnable {
  final Integer HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height * 6/7;
  final Integer WIDTH = HEIGHT * 7/9;
  
  Load gLoad = null;
  JFrame gFrame = null;
  ActionListener al = null;
  
  StartUI sui = null;
  MessageUI_GetName mui_GetName = null;
  GameUI gui = null;
  
  Enemies ens = null;
  
  Game() {
    gFrame = new JFrame();
    gFrame.setSize(WIDTH, HEIGHT);
    gFrame.setTitle("����ʥ��");
    gFrame.setLocationRelativeTo(null);
    gFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    al = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        checkButton(e.getActionCommand());
      }
    };
    sui = new StartUI(WIDTH, HEIGHT, al);
    mui_GetName = new MessageUI_GetName(WIDTH, HEIGHT, al);
    gui = new GameUI(WIDTH, HEIGHT, al);
    
    ens = new Enemies();
    
    gFrame.setContentPane(sui);
    new Thread(this).start();
  }
  
  public void run() {
    while (true) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      gFrame.setVisible(true);
    }
  }
  
  public void checkButton(String btn) {
    if (gFrame.getContentPane() == sui) {
      if (btn == sui.START) gFrame.setContentPane(mui_GetName);
    } else if (gFrame.getContentPane() == mui_GetName) {
      if (btn == mui_GetName.CHECK) {
        gLoad = new Load(mui_GetName.nameTf.getText());
        gui.thinkBtn.setToolTipText("�ָ�" + gLoad.getPlayer().THINK + "%�������");
        gui.studyBtn.setToolTipText("����15�ÿβ��ܱ�ҵŶ��");
        gui.setTime(gLoad.getTime());
        gui.setPlace(gLoad.getPlace());
        gFrame.setContentPane(gui);

        gui.showInfo("<" + gLoad.getPlayer().getName() + ">");
        gui.showInfo("�ж�����" + gLoad.getPlayer().getPoint() + "/" + gLoad.getPlayer().getMaxPoint() +
            "\n������" + gLoad.getPlayer().getPower() + "/" + gLoad.getPlayer().getMaxPower() +
            "\n������" + gLoad.getPlayer().getAtk() + "\n������" + gLoad.getPlayer().getDef() + "%\n");
      }
    } else if (gFrame.getContentPane() == gui) {
      if (btn == gui.SAVE) gFrame.setContentPane(sui);
      else if (btn == gui.SKILL) {
        
      } else if (btn == gui.REST) {
        gLoad.addTime();
        gui.setTime(gLoad.getTime());
        gui.showInfo(gLoad.getTime() + "\n");
      } else if (!gLoad.getPlayer().subPoint()) {
        gui.showInfo("���Ѿ�û���ж����ˣ���Ϣһ�°ɣ�\n");
      } else {
        gui.showInfo("<" + gLoad.getPlayer().getName() + ">ִ��[" + btn + "]");
        
        if (btn == gui.STUDY) {
          int primStuNum = gLoad.getPlayer().study();
          String primStuStr = "�ú�ѧϰ���������ϣ�";
          if (primStuNum == 5) {
            gLoad.getPlayer().addMaxPower(20);
            primStuStr = "�������+20";
          } else if (primStuNum == 10) {
            gLoad.getPlayer().addAtk(5);
            primStuStr = "����+5";
          } else if (primStuNum == 15) {
            gLoad.getPlayer().addDef(2);
            primStuStr = "����+2%";
          } else if (primStuNum > 15) {
            PerEvt [] stuEvt = {
              new PerEvt("2", 40),
              new PerEvt("4", 30)
            };
            RandS stuRan = new RandS(stuEvt);
            String stuAns = stuRan.getAns();
            if (stuAns == "2") {
              gLoad.getPlayer().addMaxPower(2);
              primStuStr = "�������+2";
            } else if (stuAns == "4") {
              gLoad.getPlayer().addMaxPower(4);
              primStuStr = "�������+4";
            }
          }
          gui.showInfo("��" + primStuNum + "�ÿΣ�" + primStuStr);
        } else if (btn == gui.THINK) {
          gui.showInfo("˼��������+" + gLoad.getPlayer().think() + "����");
        } else if (btn == gui.EXPLORE) {
        } else if (btn == gui.CHALLENGE) {
          gui.showInfo(new Battle(gLoad.getPlayer(), ens.primStu).start());
        }
        
        gui.showInfo("�ж�����" + gLoad.getPlayer().getPoint() + "/" + gLoad.getPlayer().getMaxPoint() +
            "\n������" + gLoad.getPlayer().getPower() + "/" + gLoad.getPlayer().getMaxPower() +
            "\n������" + gLoad.getPlayer().getAtk() + "\n������" + gLoad.getPlayer().getDef() + "%\n");
      }
    }
  }

  public static void main(String [] args) {
    new Game();
  }
}
