package com.game.creatures;

import com.game.Entity;


import java.awt.*;
import java.util.jar.Attributes;

public abstract class Creature extends Entity {
    private String level;
    private String name;
    private int hp;

    public Creature() {}

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}