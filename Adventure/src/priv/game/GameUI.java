package priv.game;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameUI extends JPanel {
  final Color BG_COLOR = Color.BLACK;
  ActionListener al = null;

  final Font LB_FONT = new Font("Consola", Font.PLAIN, 30);
  final Color LB_COLOR = Color.WHITE;
  
  JLabel timeLb = null;
  JLabel placeLb = null;

  Integer TOP_WIDTH = null;
  Integer TOP_HEIGHT = null;
  Integer TOP_X = null;
  Integer TOP_Y = null;

  JTextArea infoTa = null;
  final Font INFO_FONT = new Font("Consola", Font.PLAIN, 25);
  final Color INFO_COLOR = Color.WHITE;
  Integer INFO_WIDTH = null;
  Integer INFO_HEIGHT = null;
  Integer INFO_X = null;
  Integer INFO_Y = null;

  final Font BTN_FONT = new Font("Consola", Font.PLAIN, 25);
  final Color BTN_COLOR = Color.WHITE;
  Integer BTN_WIDTH = null;
  Integer BTN_HEIGHT = null;
  Integer BTN_INTERVAL = null;
  
  final String STUDY = "上课";
  Integer STUDY_X = null;
  Integer STUDY_Y = null;
  final String THINK = "冥想";
  Integer THINK_X = null;
  Integer THINK_Y = null;
  final String EXPLORE = "探索";
  Integer EXPLORE_X = null;
  Integer EXPLORE_Y = null;
  final String CHALLENGE = "挑战";
  Integer CHALLENGE_X = null;
  Integer CHALLENGE_Y = null;
  
  JButton studyBtn = null;
  JButton thinkBtn = null;
  JButton exploreBtn = null;
  JButton challengeBtn = null;
  
  final String REST = "休息";
  Integer REST_X = null;
  Integer REST_Y = null;
  final String SKILL = "技能";
  Integer SKILL_X = null;
  Integer SKILL_Y = null;
  final String SAVE = "保存";
  Integer SAVE_X = null;
  Integer SAVE_Y = null;

  JButton restBtn = null;
  JButton skillBtn = null;
  JButton saveBtn = null;
   
  GameUI(Integer WIDTH, Integer HEIGHT, ActionListener a) {
    this.al = a;
    
    TOP_WIDTH = WIDTH;
    TOP_HEIGHT = HEIGHT * 1/14;
    TOP_X = 0;
    TOP_Y = 0;

    Integer INFO_WIDTH = WIDTH * 4/5;
    Integer INFO_HEIGHT = HEIGHT * 9/14;
    Integer INFO_X = (WIDTH - INFO_WIDTH) / 2;
    Integer INFO_Y = TOP_Y + TOP_HEIGHT;
    
    BTN_WIDTH = WIDTH * 1/7;
    BTN_HEIGHT = BTN_WIDTH * 1/2;
    BTN_INTERVAL = BTN_WIDTH * 1/5;
    
    Integer STUDY_X = (WIDTH - 4 * BTN_WIDTH - 3 * BTN_INTERVAL) / 2;
    Integer STUDY_Y = INFO_Y + INFO_HEIGHT + HEIGHT * 1/28;
    Integer THINK_X = STUDY_X + BTN_WIDTH + BTN_INTERVAL;
    Integer THINK_Y = STUDY_Y;
    Integer EXPLORE_X = THINK_X + BTN_WIDTH + BTN_INTERVAL;
    Integer EXPLORE_Y = STUDY_Y;
    Integer CHALLENGE_X = EXPLORE_X + BTN_WIDTH + BTN_INTERVAL;
    Integer CHALLENGE_Y = STUDY_Y;

    Integer REST_X = (WIDTH - 3 * BTN_WIDTH - 2 * BTN_INTERVAL) / 2;
    Integer REST_Y = STUDY_Y + HEIGHT * 1/14;
    Integer SKILL_X = REST_X + BTN_WIDTH + BTN_INTERVAL;
    Integer SKILL_Y = REST_Y;
    Integer SAVE_X = SKILL_X + BTN_WIDTH + BTN_INTERVAL;
    Integer SAVE_Y = REST_Y;

    timeLb = setLabel();
    placeLb = setLabel();
    
    JPanel top = new JPanel();
    top.setBackground(BG_COLOR);
    top.setBounds(TOP_X, TOP_Y, TOP_WIDTH, TOP_HEIGHT);
    top.add(timeLb);
    top.add(placeLb);

    infoTa = new JTextArea();
    infoTa.setLineWrap(true);
    infoTa.setEditable(false);
    infoTa.setFont(INFO_FONT);
    infoTa.setBackground(BG_COLOR);
    infoTa.setForeground(INFO_COLOR);
    JScrollPane infoSp = new JScrollPane(
        infoTa,
        ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
    infoSp.setBounds(INFO_X, INFO_Y, INFO_WIDTH, INFO_HEIGHT);
    
    studyBtn = setButton(STUDY);
    studyBtn.setBounds(STUDY_X, STUDY_Y, BTN_WIDTH, BTN_HEIGHT);
    thinkBtn = setButton(THINK);
    thinkBtn.setBounds(THINK_X, THINK_Y, BTN_WIDTH, BTN_HEIGHT);
    exploreBtn = setButton(EXPLORE);
    exploreBtn.setBounds(EXPLORE_X, EXPLORE_Y, BTN_WIDTH, BTN_HEIGHT);
    challengeBtn = setButton(CHALLENGE);
    challengeBtn.setBounds(CHALLENGE_X, CHALLENGE_Y, BTN_WIDTH, BTN_HEIGHT);
    
    restBtn = setButton(REST);
    restBtn.setBounds(REST_X, REST_Y, BTN_WIDTH, BTN_HEIGHT);
    skillBtn = setButton(SKILL);
    skillBtn.setBounds(SKILL_X, SKILL_Y, BTN_WIDTH, BTN_HEIGHT);
    saveBtn = setButton(SAVE);
    saveBtn.setBounds(SAVE_X, SAVE_Y, BTN_WIDTH, BTN_HEIGHT);

    this.setLayout(null);
    this.setBackground(BG_COLOR);
    
    this.add(top);
    this.add(infoSp);
    
    this.add(studyBtn);
    this.add(thinkBtn);
    this.add(exploreBtn);
    this.add(challengeBtn);
    
    this.add(restBtn);
    this.add(skillBtn);
    this.add(saveBtn);
  }
  
  public JLabel setLabel() {
    JLabel lb = new JLabel();
    
    lb.setFont(LB_FONT);
    lb.setForeground(LB_COLOR);
    lb.setHorizontalAlignment(JLabel.CENTER);
    lb.setVerticalAlignment(JLabel.CENTER);
    
    return lb;
  }
  
  public JButton setButton(String name) {
    JButton btn = new JButton(name);
    
    btn.setFont(BTN_FONT);
    btn.setBackground(BG_COLOR);
    btn.setForeground(BTN_COLOR);
    btn.setFocusable(false);
    btn.setHorizontalAlignment(JLabel.CENTER);
    btn.setVerticalAlignment(JLabel.CENTER);
    btn.addActionListener(al);
    
    return btn;
  }
  
  public void setTime(String tStr) {
    timeLb.setText(tStr);
  }
  
  public void setPlace(String gp) {
    placeLb.setText(gp);
  }
  
  public void showInfo(String s) {
    infoTa.append(s + '\n');
  }
}
