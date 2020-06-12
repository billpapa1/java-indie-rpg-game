package com.game.creatures;

import com.game.Entity;
import com.game.RenderInfo;

import java.awt.*;
import java.util.jar.Attributes;

public abstract class Creature extends Entity {
    private String level;
    public String name;
    public int hp;
    public int minDamage;
    public int maxDamage;
    public boolean faint;

    public String description;
    public Attributes attr;


    public Creature() {
    }
    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    //public boolean getFaint() {
    //  return getFaint == true;
    //}
    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setHp(double hp) {
        this.hp = (int) hp;
    }


}



