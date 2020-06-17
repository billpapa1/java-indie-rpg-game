package com.game.creatures;


import com.game.spells.FireSpell;
import com.game.spells.Spell;

import java.util.Scanner;

public class Player extends Character{
    public int numAtkUpgrades, numDefUpgrades;
    int  money  , rests , potions;
   private String[] atkUpgrades = {"  Strength  , agility "};
   private String[] defUpgrades = {"  dexterity   ,  Scale armor  "};
   private final String[] swords = {"The mighty dragonblade sword"};
    private Object FireSpell;

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

    @Override
    public void spells() {
      //  FireSpell =
    }

    public int getNumAtkUpgrades() {
        return numAtkUpgrades;
    }

    public void setNumAtkUpgrades(int numAtkUpgrades) {
        this.numAtkUpgrades = numAtkUpgrades;
    }

    public int getNumDefUpgrades() {
        return numDefUpgrades;
    }

    public void setNumDefUpgrades(int numDefUpgrades) {
        this.numDefUpgrades = numDefUpgrades;
    }

    public String[] getAtkUpgrades() {
        return atkUpgrades;
    }

    public void setAtkUpgrades(String[] atkUpgrades) {
        this.atkUpgrades = atkUpgrades;
    }

    public String[] getDefUpgrades() {
        return defUpgrades;
    }

    public void setDefUpgrades(String[] defUpgrades) {
        this.defUpgrades = defUpgrades;
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
        GameLogic.anythingToContinue();

    }

    public String[] getSwords() {
        return swords;
    }
}
