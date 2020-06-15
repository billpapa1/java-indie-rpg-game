package com.game.creatures;


import java.util.Scanner;

public class Player extends Character{
    public int numAtkUpgrades, numDefUpgrades;
   public String[] attributes = {"Strength , dexterity , agility "};

    public Player (String name , int maxHp , int hp ){
        super(name, 100, 0);
        this.numAtkUpgrades=0;
        this.numDefUpgrades=0;
        chooseTrait();
    }

    public Player(String name) {
        super();
    }

    @Override
    public int attack() {
        return (int) (Math.random()*(xp/4 +numAtkUpgrades*3 +3 )+xp/10 +numAtkUpgrades*2 +numDefUpgrades+1 );
    }

    @Override
    public int defend() {
        return (int) (Math.random()*(xp/4 + numDefUpgrades*3 +3 )+xp/10 + numDefUpgrades*2+numAtkUpgrades+1 );
    }
    public void chooseTrait(){
        GameLogic.clearConsole();
        GameLogic.printHeading("Choose a trait for your player");
        System.out.println("(1)"+attributes[numAtkUpgrades]);
        System.out.println("(2)"+attributes[numDefUpgrades]);
        int input = GameLogic.readInt("->", 2);
        GameLogic.clearConsole();
        if (input ==1 ){
            GameLogic.printHeading("Your chose "+attributes[numAtkUpgrades]+"!");
            numAtkUpgrades++;
        }else{
            GameLogic.printHeading("You chose"+ attributes[numDefUpgrades]+"!");
            numDefUpgrades++;
        }
        GameLogic   .anythingToContinue();

    }
}
