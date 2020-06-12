package com.game.creatures;



public class Spirit extends Monster{

    public Spirit(String name, String description, int maxHp, int maxAtt, int minAtt, int dexterity, int level) {
        super(name, description, maxHp, maxAtt, minAtt, dexterity, level);
    }
    private double avoidPlus;

    public Spirit() {

    }

    public double  getAvoidPlus(){
        return avoidPlus;
    }
    public void setAvoidPlus(double avoidPlus){
        this.avoidPlus  =avoidPlus;
    }
}

