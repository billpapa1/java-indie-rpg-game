package com.game.creatures;
import com.game.Entity;
import com.game.Game;
import com.game.ImageLoader;
import com.game.RenderInfo;
import com.game.items.Armor;
import com.game.items.Potion;
import com.game.items.Weapon;
import com.game.spells.FireSpell;
import com.game.spells.IceSpell;
import com.game.spells.LightingSpell;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import static java.awt.event.KeyEvent.*;

public  class Hero extends Creature {


    public int magicPower, strength, dexterity, agility, money, experience;

    public List<Weapon> heroWeaponList = new ArrayList<>();
    public List<Potion> heroPotionList = new ArrayList<>();
    public List<Armor> heroArmorList = new ArrayList<>();
    public List<IceSpell> heroIceSpellList = new ArrayList<>();
    public List<FireSpell> heroFireSpellList = new ArrayList<>();
    public List<LightingSpell> heroLightingSpellList = new ArrayList<>();
    private List<Entity> entitiesList1 = new ArrayList<>();
    public BufferedImage player;
    public Armor armorEqquiped;
    public Weapon weaponEqquiped;
    private Boolean up = false, dw = false, lt = false, rt = false;


    public Hero() {
        player = ImageLoader.loadImage("/images/player.png");
    }


    public double getMagicPower() {
        return magicPower;
    }

    public void setMagicPower(int magicPower) {
        this.magicPower = magicPower;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int i) {
        this.agility = agility;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int i) {
        this.money = money;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int randomInt) {
        this.experience = experience;
    }

    //public boolean levelUp(){
    // return (getExperience(1+10*2)+1)%2==0);
    // }
    public Armor getArmoredEqquiped() {
        return armorEqquiped;
    }

    public void setArmorEqquiped(Armor armorEqquiped) {
        this.armorEqquiped = armorEqquiped;
    }

    public Weapon getWeaponEqquiped() {
        return weaponEqquiped;
    }

    public void setWeaponEqquiped(Weapon weaponEqquiped) {
        this.weaponEqquiped = weaponEqquiped;
    }

    public List<Weapon> getHeroWeaponList() {
        return heroWeaponList;
    }

    public List<Potion> getHeroPotionList() {
        return heroPotionList;
    }

    public List<Armor> getHeroArmorList() {
        return heroArmorList;
    }

    public List<FireSpell> getHeroFireSpellList() {
        return heroFireSpellList;
    }

    public List<IceSpell> getHeroIceSpellList() {
        return heroIceSpellList;
    }

    public List<LightingSpell> getHeroLightingSpellList() {
        return heroLightingSpellList;
    }


    public void render(Graphics2D g, RenderInfo renderInfo) {
        g.drawImage(player, (int) (Game.LEVEL_SCALE*x) , (int)(Game.LEVEL_SCALE*y) , (int)(player.getWidth()* Game.LEVEL_SCALE)
                ,(int)(player.getHeight()*Game.LEVEL_SCALE), null);

    }

    @Override
    public void update(double delta) {
        float speed = 64;
        if (Game.pressedKeys.contains(VK_W)) {  //MOVE FORWARD
            y -= speed * delta;
        }
        if (Game.pressedKeys.contains(VK_A)) {   // MOVE LEFT
            x -=speed * delta;       }
        if (Game.pressedKeys.contains(VK_D)) {   // MOVE RIGHT
            x +=speed * delta;
        }
        if (Game.pressedKeys.contains(VK_S)) {   // MOVE BACKWARDS , DOWN
            y +=speed * delta;
        }
    }
}
/*
     public void move(){
            if (up) {
                y -= speed;
            }
            if (dw) {
                y += speed;
            }
            if (lt) {
                x -= speed;
            }
            if (rt) {
                x += speed;
            }
        }*/



    //  public void keyTyped(KeyEvent e) {

    //   }


/*   public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == VK_W) {
            up = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            dw = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            rt = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            lt = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == VK_W) {
            up = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            dw = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            rt = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            lt = false;
        }

    }
}







/*
    public static Hero newWarrior () {
        return new Hero("Warrior", "signifant damage and quick", 10, 5, 25, 5);

    }
    public static Hero newSorcerer () {
        return new Hero("Sorcerer", "Fast and high dexterity", 20, 15, 25, 20);

    }
    public static Hero newPaladin () {
        return new Hero("Paladin", "high damage and dexterity", 40, 25, 40, 10);
    }


    public String getDescription () {
        return description;
    }

    public String getName () {
        return name;
    }
*/


