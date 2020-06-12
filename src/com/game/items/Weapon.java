package com.game.items;

public class Weapon extends Item {
    public double damage;
    public boolean handsreq;

    public double getDamage(){
        return damage;
    }
    public void setDamage ( double damage){
        this.damage = damage;
    }
    public boolean getHandsReq(){
        return handsreq;
    }
    public void setHandsReq(int handsReq){
        this.handsreq=handsreq;
    }
}
