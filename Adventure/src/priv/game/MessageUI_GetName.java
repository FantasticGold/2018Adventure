package priv.game;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MessageUI_GetName extends JPanel {
  final Color BG_COLOR = Color.BLACK;
  
  final String STORY = "在遥远的时空中，有一个被人类统治的星球。" +
      "两千年前，一道时空裂缝出现了，人类的祖先被带到这个星球上。" +
      "这里的环境非常适合人类生活，他们很快就统治了这个星球，把唯一的大陆命名为星月大陆。" +
      "一千年前，又一道时空裂缝出现了，七块巨大的墓碑出现在星月大陆上。" +
      "这些墓碑带来了黑暗气息，任何生物沾染了黑暗气息后都会变成黑暗生物。" +
      "随着黑暗气息的扩散，半个星月大陆都被黑暗生物占领了。" +
      "幸好时空裂缝还带来了一座高塔，这座高塔发出的光明气息抑制了黑暗气息的扩散，人类围绕着高塔守护最后的家园。" +
      "存活下来的人们把这些墓碑称为魔纹碑，把黑暗生物称为魔族，把这座拯救了人类的高塔称为光明圣塔。" +
      "最初七个变异的魔族拥有不亚于人类的智慧，还可以通过魔纹碑获得强大的实力，他们自称魔王。" +
      "魔王想要彻底打败人类，一千年来不断发动战争，而人类成立了战士神殿、刺客联盟和法师协会，顽强抵抗着魔族的入侵……";
  final Font STORY_FONT = new Font("Consola", Font.PLAIN, 25);
  final Color STORY_COLOR = Color.WHITE;
  Integer STORY_WIDTH = null;
  Integer STORY_HEIGHT = null;
  Integer STORY_X = null;
  Integer STORY_Y = null;
  
  final String HINT = "请输入你的名字";
  JTextField nameTf = null;

  final String NAME = "小小G";
  final Font NAME_FONT = new Font("Consola", Font.PLAIN, 30);
  final Color NAME_COLOR = Color.WHITE;
  Integer NAME_WIDTH = null;
  Integer NAME_HEIGHT = null;
  Integer NAME_X = null;
  Integer NAME_Y = null;
  
  final String CHECK = "确认";
  final Font CHECK_FONT = new Font("Consola", Font.PLAIN, 30);
  final Color CHECK_COLOR = Color.WHITE;
  Integer CHECK_WIDTH = null;
  Integer CHECK_HEIGHT = null;
  Integer CHECK_X = null;
  Integer CHECK_Y = null;
  
  MessageUI_GetName(Integer WIDTH, Integer HEIGHT, ActionListener al) {
    STORY_WIDTH = WIDTH * 4/5;
    STORY_HEIGHT = STORY_WIDTH * 9/8;
    NAME_WIDTH = WIDTH * 2/5;
    NAME_HEIGHT = NAME_WIDTH  * 1/5;
    CHECK_HEIGHT = NAME_HEIGHT;
    CHECK_WIDTH = CHECK_HEIGHT * 2/1;
    
    STORY_X = (WIDTH - STORY_WIDTH) / 2;
    STORY_Y = (HEIGHT - STORY_HEIGHT - NAME_HEIGHT) / 3;
    NAME_X = (WIDTH - NAME_WIDTH - CHECK_WIDTH) / 2;
    NAME_Y = STORY_HEIGHT + STORY_Y;
    CHECK_X = NAME_WIDTH + NAME_X + CHECK_WIDTH * 1/5;
    CHECK_Y = NAME_Y;
    
    JTextArea storyTa = new JTextArea(STORY);
    storyTa.setFont(STORY_FONT);
    storyTa.setBackground(BG_COLOR);
    storyTa.setForeground(STORY_COLOR);
    storyTa.setLineWrap(true);
    storyTa.setBounds(STORY_X, STORY_Y, STORY_WIDTH, STORY_HEIGHT);

    nameTf = new JTextField(NAME);
    nameTf.setFont(NAME_FONT);
    nameTf.setBackground(BG_COLOR);
    nameTf.setForeground(NAME_COLOR);
    nameTf.setCursor(null);
    nameTf.setBounds(NAME_X, NAME_Y, NAME_WIDTH, NAME_HEIGHT);
    nameTf.setToolTipText(HINT);
    
    JButton checkBtn = new JButton(CHECK);
    checkBtn.setFont(CHECK_FONT);
    checkBtn.setBackground(BG_COLOR);
    checkBtn.setForeground(CHECK_COLOR);
    checkBtn.setFocusable(false);
    checkBtn.setBounds(CHECK_X, CHECK_Y, CHECK_WIDTH, CHECK_HEIGHT);
    checkBtn.setHorizontalAlignment(JLabel.CENTER);
    checkBtn.setVerticalAlignment(JLabel.CENTER);
    checkBtn.addActionListener(al);
    
    this.setLayout(null);
    this.setBackground(BG_COLOR);
    this.add(storyTa);
    this.add(nameTf);
    this.add(checkBtn);
  }
}
