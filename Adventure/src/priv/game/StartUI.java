package priv.game;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StartUI extends JPanel {
  final Color BG_COLOR = Color.BLACK;
  
  final String NAME = "光明圣塔";
  final Font NAME_FONT = new Font("Consola", Font.PLAIN, 100);
  final Color NAME_COLOR = Color.YELLOW;
  Integer NAME_WIDTH = null;
  Integer NAME_HEIGHT = null;
  Integer NAME_X = null;
  Integer NAME_Y = null;

  final Font BTN_FONT = new Font("Consola", Font.PLAIN, 40);
  final Color BTN_COLOR = Color.WHITE;
  Integer BTN_WIDTH = null;
  Integer BTN_HEIGHT = null;
  
  final String START = "开始游戏";
  Integer START_X = null;
  Integer START_Y = null;
  
  StartUI(Integer WIDTH, Integer HEIGHT, ActionListener al) {
    NAME_WIDTH = WIDTH;
    NAME_HEIGHT = HEIGHT * 3/5;
    NAME_X = 0;
    NAME_Y = 0;
    
    BTN_WIDTH = WIDTH * 1/3;
    BTN_HEIGHT = HEIGHT * 1/10;
    
    START_X = (WIDTH - BTN_WIDTH) / 2;
    START_Y = NAME_Y + NAME_HEIGHT;
    
    JLabel nameLb = new JLabel(NAME);
    nameLb.setFont(NAME_FONT);
    nameLb.setForeground(NAME_COLOR);
    nameLb.setBounds(NAME_X, NAME_Y, NAME_WIDTH, NAME_HEIGHT);
    nameLb.setHorizontalAlignment(JLabel.CENTER);
    nameLb.setVerticalAlignment(JLabel.CENTER);
    
    JButton startBtn = new JButton(START);
    startBtn.setFont(BTN_FONT);
    startBtn.setBackground(BG_COLOR);
    startBtn.setForeground(BTN_COLOR);
    startBtn.setFocusable(false);
    startBtn.setBounds(START_X, START_Y, BTN_WIDTH, BTN_HEIGHT);
    startBtn.setHorizontalAlignment(JLabel.CENTER);
    startBtn.setVerticalAlignment(JLabel.CENTER);
    startBtn.addActionListener(al);

    this.setLayout(null);
    this.setBackground(BG_COLOR);
    this.add(nameLb);
    this.add(startBtn);
  }
}
