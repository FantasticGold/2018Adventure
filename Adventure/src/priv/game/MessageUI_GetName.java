package priv.game;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MessageUI_GetName extends JPanel {
  final Color BG_COLOR = Color.BLACK;
  
  final String STORY = "��ңԶ��ʱ���У���һ��������ͳ�ε�����" +
      "��ǧ��ǰ��һ��ʱ���ѷ�����ˣ���������ȱ�������������ϡ�" +
      "����Ļ����ǳ��ʺ�����������Ǻܿ��ͳ����������򣬰�Ψһ�Ĵ�½����Ϊ���´�½��" +
      "һǧ��ǰ����һ��ʱ���ѷ�����ˣ��߿�޴��Ĺ�����������´�½�ϡ�" +
      "��ЩĹ�������˺ڰ���Ϣ���κ�����մȾ�˺ڰ���Ϣ�󶼻��ɺڰ����" +
      "���źڰ���Ϣ����ɢ��������´�½�����ڰ�����ռ���ˡ�" +
      "�Һ�ʱ���ѷ컹������һ���������������������Ĺ�����Ϣ�����˺ڰ���Ϣ����ɢ������Χ���Ÿ����ػ����ļ�԰��" +
      "������������ǰ���ЩĹ����Ϊħ�Ʊ����Ѻڰ������Ϊħ�壬����������������ĸ�����Ϊ����ʥ����" +
      "����߸������ħ��ӵ�в�����������ǻۣ�������ͨ��ħ�Ʊ����ǿ���ʵ���������Գ�ħ����" +
      "ħ����Ҫ���״�����࣬һǧ�������Ϸ���ս���������������սʿ���̿����˺ͷ�ʦЭ�ᣬ��ǿ�ֿ���ħ������֡���";
  final Font STORY_FONT = new Font("Consola", Font.PLAIN, 25);
  final Color STORY_COLOR = Color.WHITE;
  Integer STORY_WIDTH = null;
  Integer STORY_HEIGHT = null;
  Integer STORY_X = null;
  Integer STORY_Y = null;
  
  final String HINT = "�������������";
  JTextField nameTf = null;

  final String NAME = "ССG";
  final Font NAME_FONT = new Font("Consola", Font.PLAIN, 30);
  final Color NAME_COLOR = Color.WHITE;
  Integer NAME_WIDTH = null;
  Integer NAME_HEIGHT = null;
  Integer NAME_X = null;
  Integer NAME_Y = null;
  
  final String CHECK = "ȷ��";
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
