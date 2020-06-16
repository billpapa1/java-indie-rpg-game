package com.game.creatures;


import java.util.Scanner;

public class Player extends Character{
    public int numAtkUpgrades, numDefUpgrades;
    int  money  , rests , potions;
   public String[] atkUpgrades = {"  Strength  , agility "};
   public String[] defUpgrades = {"  dexterity   ,  Scale armor  "};
   public String[] swords = {"The mighty dragonblade sword"};
    public Player (String name){ // calling constructor of superclass
        super(name, 100, 0);
        this.numAtkUpgrades=0;
        this.numDefUpgrades=0;
        this.money = 5;
        this.rests = 1;
        this.potions =3;

        chooseTrait();
    }
    @Override
    public int attack() {
        return (int) (Math.random()*(xp/4 +numAtkUpgrades*3 +7 )+xp/10 +numAtkUpgrades*2 +numDefUpgrades+1 );
    }

    @Override
    public int defend() {
        return (int) (Math.random()*(xp/4 + numDefUpgrades*3 +7)+xp/10 + numDefUpgrades*2+numAtkUpgrades+1 );
    }
    public void chooseTrait(){
        GameLogic.clearConsole();
        GameLogic.printHeading("Choose a trait for your player");
        System.out.println("(1)"+atkUpgrades[numAtkUpgrades]);
        System.out.println("(2)"+defUpgrades[numDefUpgrades]);
        int input = GameLogic.readInt("->", 2);
        GameLogic.clearConsole();
        if (input ==1 ){
            GameLogic.printHeading("Your chose "+atkUpgrades[numAtkUpgrades]+"!");
            numAtkUpgrades++;
        }else{
            GameLogic.printHeading("You chose"+ defUpgrades[numDefUpgrades]+"!");
            numDefUpgrades++;
        }
        GameLogic   .anythingToContinue();

    }
}
