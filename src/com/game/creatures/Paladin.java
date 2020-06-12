package com.game.creatures;


public class Paladin extends Hero {

    double strengthInc, dexterityInc;

    public Paladin() {

    }

    public double getStrengthInc() {
        return strengthInc;
    }
    public void setStrengthInc(double strengthInc){
        this.strengthInc=strengthInc;
    }
    public double getDexterityInc(){
        return dexterityInc;
    }
    public void setDexterityInc(double dexterityInc){
        this.dexterityInc=dexterityInc;
    }
}
