package com.game.creatures;

public class Exoskeleton extends Monster {


    public Exoskeleton(String name, String description, int maxHp, int maxAtt, int minAtt, int dexterity, int level) {
        super(name, description, maxHp, maxAtt, minAtt, dexterity, level);
    }
    private double extraDef;

    public Exoskeleton() {

    }

    public double getExtraDef(){
        return extraDef;
    }
    public void setExtraDef(double extraDef){
        this.extraDef=extraDef;
    }
}

