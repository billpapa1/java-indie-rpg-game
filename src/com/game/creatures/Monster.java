package com.game.creatures;


import com.game.Game;
import com.game.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
public class Monster extends Creature {
    public static final Random RAND = new Random();
    private double minDmg, maxDmg, defRate, avoidAtt, dmgRed, defRed, avoidSpell;
    private int dmgRedRounds, defRedRounds, avoidSpellRounds;
    public BufferedImage enemy;

    public Monster(String name, String description, int maxHp, int maxAtt, int minAtt, int dexterity, int level) {
    }

    public Monster() {
        enemy = ImageLoader.loadImage("/images/enemy.png");
    }

    @Override
    public void update(double delta) {

    }

    @Override
    public void render(Graphics2D g) {

        g.drawImage(enemy, (int) (Game.LEVEL_SCALE*100) , (int)(Game.LEVEL_SCALE*100) , (int)(enemy.getWidth()* Game.LEVEL_SCALE)
                ,(int)(enemy.getHeight()*Game.LEVEL_SCALE), null);

    }

    public double getDmgRed() {
        return dmgRed;
    }

    public void setDmgRed(double dmgRed) {
        this.dmgRed = dmgRed;
    }

    public double getDefRed() {
        return defRed;
    }

    public void setDefRed(double defRed) {
        this.defRed = defRed;
    }

    public double getAvoidSpell() {
        return avoidSpell;
    }

    public void setAvoidSpell(double avoidSpell) {
        this.avoidSpell = avoidSpell;
    }

    public double getMinDmg() {
        return minDmg;
    }

    public void setMinDmg(double minDmg) {
        this.minDmg = minDmg;
    }

    public double getMaxDmg() {
        return maxDmg;
    }

    public void setMaxDmg(double maxDmg) {
        this.maxDmg = maxDmg;
    }

    public double getDefRate() {
        return defRate;
    }

    public void setDefRate(double defRate) {
        this.defRate = defRate;
    }

    public double getAvoidAtt() {
        return avoidAtt;
    }

    public void setAvoidAtt(double avoidAtt) {
        this.avoidAtt = avoidAtt;
    }

    public int getDmgRedRounds() {
        return dmgRedRounds;
    }

    public void setDmgRedRounds(int dmgRedRounds) {
        this.dmgRedRounds = dmgRedRounds;
    }

    public int getDefRedRounds() {
        return defRedRounds;
    }

    public void setDefRedRounds(int defRedRounds) {
        this.defRedRounds = defRedRounds;
    }

    public int getAvoidSpellRounds() {
        return avoidSpellRounds;
    }

    public void setAvoidSpellRounds(int avoidSpellRounds) {
        this.avoidSpellRounds = avoidSpellRounds;
    }


}









