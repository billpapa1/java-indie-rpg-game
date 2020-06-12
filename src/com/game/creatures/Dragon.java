package com.game.creatures;

public class Dragon extends Monster {

    private double minDmgPlus, maxDmgPlus;

    public Dragon(String name, String description, int maxHp, int maxAtt, int minAtt, int dexterity, int level) {
        super(name, description, maxHp, maxAtt, minAtt, dexterity, level);
    }

    public Dragon() {
        super();
    }

    public double getMinDmgPlus() {
        return minDmgPlus;
    }

    public void setMinDmgPlus(double minDamagePlus) {
        this.minDmgPlus = minDamagePlus;
    }

    public double getMaxDmgPlus() {
        return maxDmgPlus;
    }

    public void setMaxDmgplus(double maxDamagePlus) {
        this.maxDmgPlus = maxDamagePlus;
    }
}
