package com.game.creatures;


import com.game.Game;
import com.game.ImageLoader;
import com.game.RenderInfo;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
public class Monster extends Creature {
    public static final Random RAND = new Random();
    private double minDmg, maxDmg, defRate, avoidAtt, dmgRed, defRed, avoidSpell;
    private int dmgRedRounds, defRedRounds, avoidSpellRounds;
   // public BufferedImage monster;

    public Monster(String name, String description, int maxHp, int maxAtt, int minAtt, int dexterity, int level) {
    }

    public Monster() {
      // monster  = ImageLoader.loadImage("/images/monster.png");
    }

    @Override
    public void update(double delta) {

    }

    @Override
    public void render(Graphics2D g, RenderInfo renderInfo) {

        //g.drawImage(monster, (int) (Game.LEVEL_SCALE*x) , (int)(Game.LEVEL_SCALE*y) , (int)(monster.getWidth()* Game.LEVEL_SCALE)
             //   ,(int)(monster.getHeight()*Game.LEVEL_SCALE), null);
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










 /*   public static Monster newRandomMonster() {
        int random = RAND.nextInt(4) + 1;
        Monster monster = null;
        switch (random) {
            case 1:
                monster = newMonster();
                break;
            case 2:
                monster = newDragon();
                break;
            case 3:
                monster = newExoskeleton();
                break;
            case 4:
                monster = newSpirit();
        }
        return monster;
    }
    public static Monster newMonster() {
        return new Monster("Monster", "he has chances to damage your character , can lose hp , he might have a chance to avoid a hit",
                30, 10, 3, 5, 3);
    }
    public static Monster newDragon() {
        return new Monster("Dragon", "high amplitute of damage", 100, 30, 20, 2, 5);

    }
    public static Monster newExoskeleton() {
        return new Monster("Exoskeleton", "high defense , easy to block and withstand hits", 150, 8, 3, 8, 4);

    }
    public static Monster newSpirit() {
        return new Monster("Spirit", "High dexterity , easy to avoid most of the hits. might have some weaknesses", 100, 4, 2, 20, 4);

    }
    public String getDescription() {
        return description;
    }
    public String getName() {
        return name;
    }

    public String toString() {
        return name + " " + description;
    }
}
*/

