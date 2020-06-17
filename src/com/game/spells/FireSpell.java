package com.game.spells;

public class FireSpell extends Spell{


    private double defRed;
    private double getDefRed(){  //getter (accessor) method to access-->
        //the defense reduction made from the fire spell
        return defRed;
    }
    public void setDefRed(double defRed){ // setter(mutator) method to manipulate the value
        // of the defense reduction made from the spell.
        this.defRed=defRed;
    }
}
