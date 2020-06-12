package com.game.spells;
public class IceSpell extends Spell {
    private double dmgRed;

    public double getDmgRed() {  //  getter(accesor) method to get the damage reduction created from the spell
        return dmgRed;
    }

    public void setDmgRed(double dmgRed) { // setter(mutator) method to set the damage reduction created from the spell
        this.dmgRed = dmgRed;
    }

}



