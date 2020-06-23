package com.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class popUpBox {
    JFrame window;
    Container con;
    JButton Button1, Button2, Button3, Button4;
    JTextArea intro, text;
    JPanel textPanel, ButtonPanel, introPanel, labelPanel;
    JLabel Label;
    ScreenHandler screenHandler = new ScreenHandler();
    Font NormalFont = new Font("Times New Roman", Font.PLAIN, 30);

    public static void main(String[] args) {
        new popUpBox();

    }

    public popUpBox() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();

        //title label
        labelPanel = new JPanel();
        labelPanel.setBounds(100, 100, 600, 150);
        labelPanel.setBackground(Color.BLACK);
        Label = new JLabel("INTERACTION");
        Label.setForeground(Color.WHITE);
        Label.setFont(NormalFont);
        //creating the button panel
        ButtonPanel = new JPanel();
        ButtonPanel.setBounds(300, 400, 200, 100);
        ButtonPanel.setBackground(Color.BLACK);


        textPanel = new JPanel();
        textPanel.setBounds(300, 250, 200, 100);
        textPanel.setBackground(Color.BLACK);


        //BUTTON 1
        Button1 = new JButton("FIGHT ");
        Button1.setBackground(Color.BLACK);
        Button1.setForeground(Color.WHITE);
        Button1.setFont(NormalFont);
        Button1.addActionListener(screenHandler);
        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               text= new JTextArea("YOU DECIDED TO FIGHT THE GOBLIN");
            }
        });

        //BUTTON 2
        Button2 = new JButton("TALK TO HIM ");
        Button2.setBackground(Color.RED);
        Button2.setForeground(Color.WHITE);
        Button2.setFont(NormalFont);
        Button2.setFocusPainted(false);


        //BUTTON 3
        Button3 = new JButton("LEAVE ");
        Button3.setBackground(Color.RED);
        Button3.setForeground(Color.WHITE);
        Button3.setFont(NormalFont);
        Button3.setFocusPainted(false);

        //TEXT - INTRO
        text = new JTextArea("You came across an ugly Goblin, what are you going to do? ");
        text.setBackground(Color.BLACK);
        text.setForeground(Color.WHITE);
        text.setFont(NormalFont);
        ButtonPanel.add(Button1);
        ButtonPanel.add(Button2);
        ButtonPanel.add(Button3);
        ButtonPanel.add(Button4);
        labelPanel.add(Label);
        textPanel.add(text);
        con.add(labelPanel);
        con.add(ButtonPanel);
        con.add(textPanel);


    }

    public void gameScreen() {

        introPanel.setVisible(false);
        ButtonPanel.setVisible(false);
        introPanel = new JPanel();
        introPanel.setBounds(100, 100, 600, 250);
        introPanel.setBackground(Color.BLACK);
        con.add(introPanel);

        intro = new JTextArea("YOU COME ACROSS A MIGHTY GOBLIN ");
        intro = new JTextArea(("THE FIGHT IS INEVITABLE , YOUR DECISION MUST BE SHARP......  "));
        intro.setBounds(65, 125, 350, 250);
        intro.setBackground(Color.BLACK);
        intro.setForeground(Color.WHITE);
        intro.setFont(NormalFont);
        intro.setLineWrap(true);
    }

    public class ScreenHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gameScreen();
            //  System.exit(0);

        }

    }
}



