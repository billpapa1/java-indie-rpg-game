package com.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.Color;

//import java.util.Scanner;


class Menu {

    public static final Random RAND = new Random();
    JFrame window;
    Container con;
    JPanel titleNamePanel, textPanel, startButtonPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelNumber;
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainArea , mainArea1;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 60);
    Font NormalFont = new Font("Times New Roman", Font.PLAIN, 30);
    Font ItalicFont = new Font ("Times New Roman" , Font.ITALIC , 40);
    Font ItalicFont1 = new Font ("Times New Roman", Font.ITALIC,30);
    int playerHP;
    String weapon;   private boolean isRunning = false;
    ScreenHandler titleScreenHandler = new ScreenHandler();

    public static void main(String[] args) {
        new Menu();
    }

    public Menu() {

        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.BLACK);
        titleNameLabel = new JLabel("Monster Hunters");
        titleNameLabel.setForeground(Color.WHITE);

        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.BLACK);


        startButton = new JButton("Enter");
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(NormalFont);
        startButton.addActionListener(titleScreenHandler);
        startButton.setFocusPainted(false);


        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        con.add(titleNamePanel);
        con.add(startButtonPanel);
    }

    public void gameScreen() {


        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        textPanel = new JPanel();
        textPanel.setBounds(100, 100, 600, 250);
        textPanel.setBackground(Color.BLACK);
        con.add(textPanel);

        mainArea = new JTextArea("WELCOME TO THE");
        mainArea1= new JTextArea ((" WORLD OF MORIA "));
        mainArea.setBounds(65, 125, 350, 250);
        mainArea.setBackground(Color.BLACK);
        mainArea.setForeground(Color.WHITE);
        mainArea.setFont(ItalicFont);
        mainArea.setLineWrap(true);
        textPanel.add(mainArea);
        mainArea1.setBounds(85, 150,310,250);
        mainArea1.setBackground((Color.ORANGE.BLACK));
        mainArea1.setForeground(Color.WHITE);
        mainArea1.setFont(ItalicFont1);
        mainArea1.setLineWrap(true);
        textPanel.add(mainArea1);



        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 400, 150);
        choiceButtonPanel.setBackground(Color.RED);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        con.add(choiceButtonPanel);


        choice1 = new JButton("START GAME  ");
        choice1.setBackground(Color.BLACK);
        choice1.setForeground(Color.WHITE);
        choice1.setFont(NormalFont);
        choice1.setFocusPainted(false);
        choiceButtonPanel.add(choice1);
        choice2 = new JButton(" ");
        choice2.setBackground(Color.BLACK);
        choice2.setForeground(Color.WHITE);
        choice2.setFont(NormalFont);
        choice2.setFocusPainted(false);
        choiceButtonPanel.add(choice2);
        choice3 = new JButton("Choice 3 ");
        choice3.setBackground(Color.BLACK);
        choice3.setForeground(Color.WHITE);
        choice3.setFont(NormalFont);
        choice3.setFocusPainted(false);
        choiceButtonPanel.add(choice3);
        choice4 = new JButton("EXIT ");
        choice4.setBackground(Color.BLACK);
        choice4.setForeground(Color.WHITE);
        choice4.setFont(NormalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            System.exit(0);
            }
        });



            choiceButtonPanel.add(choice4);

            playerPanel = new JPanel();
            playerPanel.setBounds(100, 15, 600, 50);
            playerPanel.setBackground(Color.BLACK);
            playerPanel.setLayout(new GridLayout(1, 4));
            con.add(playerPanel);
            hpLabel = new JLabel("");
            hpLabel.setFont(NormalFont);
            hpLabel.setForeground(Color.white);
            playerPanel.add(hpLabel);
            hpLabelNumber = new JLabel(" ");
            hpLabelNumber.setFont(NormalFont);
            hpLabelNumber.setForeground(Color.WHITE);
            playerPanel.add(hpLabelNumber);
            weaponLabelNumber = new JLabel();
            weaponLabelNumber.setFont(NormalFont);
            weaponLabelNumber.setForeground(Color.WHITE);





        }
    public void run() {
        double lastTime = 0;

      gameScreen();
      new Menu();


        while(isRunning) {
            double elapsedTime = (System.nanoTime() - lastTime) / 1000000000.0;

            if(elapsedTime >= 1 / 60.0) {
                gameScreen();
                new Menu();
                lastTime = System.nanoTime();
            }
        }
    }

        public class ScreenHandler implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameScreen();
              //  System.exit(0);

            }

        }
    }

