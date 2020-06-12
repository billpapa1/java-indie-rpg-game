package com.game.items;

public class Potion extends Item {
    public String property;
    public Double propertyPerc;

    public String getProperty(){
        return property;
    }
    public void setProperty(String property){
        this.property=property;
    }
    public double getPropertyperc(){
        return propertyPerc;
    }
    public void setPropertyPerc(double v){
        this.propertyPerc=propertyPerc;
    }


}
