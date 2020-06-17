package com.game.creatures;

public abstract class Character {
    // the variables/ attributes the characters have
    public String name;
    public int maxHp , hp ,xp ;
    //constructor for character class
    public Character(String name , int maxHp , int xp){
        this.name=name;
        this.maxHp=maxHp;
        this.xp= xp;
        this.hp=maxHp;

    }

    public Character() {

    }

    // the methods , abilities the characters have
    public abstract int attack();
    public abstract int defend();
    public abstract void spells();



}
