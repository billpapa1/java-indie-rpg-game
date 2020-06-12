package com.game.spells;

public class Spell { //super class for fire spell , ice spell and lighting spell
    private String name, minLevel;   // introduction of private integer variables
    private double price ,minDmg,maxDmg,magicEnergy; // introduction of private double variables

    public Spell(){  // constructor with no parameters , nor initialisations
    }
    public String getName(){  // accessor method to get the name of the spell
        return name;
    }
    public void setName(String name){  // mutator method to set the name of the spell
        this.name=name;
    }
    public String getMinLevel(){  //accessor method to get the minimum level able to act a spell
        return minLevel;
    }
    public void setMinLevel(String minLevel){ //mutator method to set the minimum level
        this.minLevel=minLevel;
    }
    public double getPrice(){ //accessor method to get the price of the spell
        return price;
    }
    public void setPrice(double price){ //mutator method to set the price of the spell
        this.price = price;
    }
    public double getMinDmg(){ //accesor method to get the minimum damage can be acted from the spells
        return minDmg;
    }
    public void setMinDmg(double minDmg){ //mutator method to set the minimum damage made from the spells
        this.minDmg=minDmg;
    }
    public double getMaxDmg(){ //accessor method to get the maximum damage made from the spells
        return maxDmg;
    }
    public void setMaxDmg(double maxDmg){ //mutator method to set the maximum damage made from the spells
        this.maxDmg=maxDmg;
    }
    public double getMagicEnergy() { //  accessor method to get the magic energy required for the spells
        return magicEnergy;
    }
    public void setMagicEnergy(double magicEnergy) { // mutator method to set the magic energy required for the spells
        this.magicEnergy = magicEnergy;
    }
}
