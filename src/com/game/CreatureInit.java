/*package com.game;

import com.game.creatures.*;


import java.util.Random;
import java.util.Scanner;

public class CreatureInit {
    private static int NoSorcerers = 0, NoWarriors = 0, NoPaladins = 0, NoDragons = 0, NoExoskeletons = 0, NoSpirits = 0;
    private static String[] levels = {"easy", "intermediate", "legendary", "immortal"};


    public static int getNoHero() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Select your characters you would like to start your adventure with"); // each character has been assigned with a number
        int NoHero = scanner1.nextInt();
        return NoHero;
    }

    public static Hero getHero(int i) {
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Select the type of hero you would like to begin with" + i + "your choices are warrior[1] , sorcerer [2] and Paladin [3].");
        int heroType = scanner2.nextInt();

        Hero hero = new Hero();
        if (heroType == 0) {
            hero = new Warrior();
            hero.setName("Warrior" + Integer.toString(NoWarriors));
            hero.setAgility(50);
            hero.setDexterity(50);
            hero.setStrength(50);
            hero.setExperience(getRandomNumberInRange(1,4));
            ((Warrior) hero).setAgilityInc(1.25);
            hero.setAgility((int) (((Warrior) hero).getAgilityInc() * hero.getAgility()));
            ((Warrior) hero).setStrengthInc(1.25);
            hero.setStrength((int) (hero.getStrength() * ((Warrior) hero).getStrengthInc()));


            NoWarriors++;
        } else if (heroType == 1) {
            hero = new Sorcerer();
            hero.setName("Sorcerer" + Integer.toString(NoSorcerers));
            hero.setAgility(50);
            hero.setDexterity(50);
            hero.setStrength(50);
            hero.setExperience(getRandomNumberInRange(1,4));
            ((Sorcerer) hero).setDexterityInc(1.25);
            hero.setDexterity((int) (((Sorcerer) hero).getDexterityInc() * hero.getDexterity()));
            ((Sorcerer) hero).setAgilityInc(1.25);
            hero.setAgility((int) (((Sorcerer) hero).getAgilityInc() * hero.getAgility()));
            NoSorcerers++;
        } else {
            hero = new Paladin();
            hero.setName("Paladin" + Integer.toString(NoPaladins));
            hero.setAgility(50);
            hero.setDexterity(50);
            hero.setStrength(50);
            hero.setExperience(getRandomNumberInRange(1,4));
            ((Paladin) hero).setStrengthInc(1.25);
            hero.setStrength((int) (((Paladin) hero).getStrengthInc() * hero.getStrength()));
            ((Paladin) hero).setDexterityInc(1.25);
            hero.setDexterity((int) (((Paladin) hero).getDexterityInc() * hero.getDexterity()));
            NoPaladins++;
        }
        if (hero.getExperience() <= 2) {
            hero.setLevel(levels[0]);
        } else if (hero.getExperience() <= 4) {
            hero.setLevel(levels[1]);
        } else if (hero.getExperience() < 6) {
            hero.setLevel(levels[2]);
        } else {
            hero.setLevel(levels[3]);
        }
        hero.setMoney(100);
        hero.setHp(100);
        hero.setMagicPower(50);
        return hero;
    }

    private final int NoMonsters = getNoHero() * 2;

    public static Monster getMonster() {
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Select the type of the Monster");
        int monsterType = scanner4.nextInt();

        Monster monster = new Monster();
        if (monsterType == 0) {
            monster = new Dragon();
            monster.setName("Dragon" + Integer.toString(NoDragons));
            monster.setLevel(levels[getRandomNumberInRange(0,3)]);
            monster.setMinDmg(15);
            monster.setMaxDmg(45);
            monster.setDefRate(23);

            monster.setAvoidAtt(getRandomDoubleInRange(0,1));
            ((Dragon)monster).setMinDmgPlus(1.25);
            monster.setMinDmg(monster.getMinDmg()*monster.getMinDmg());
            ((Dragon)monster).setMaxDmgplus(1.25);
            monster.setMaxDmg(((Dragon)monster).getMaxDmgPlus() * monster.getMaxDmg());
            NoDragons++;
        }
        else if (monsterType ==1 ) {
            monster = new Exoskeleton();
            monster.setName("Exoskeleton" + Integer.toString(NoExoskeletons));
            monster.setLevel(levels[getRandomNumberInRange(0,3)]);
            monster.setMinDmg(15);
            monster.setMaxDmg(45);
            monster.setDefRate(23);
            monster.setAvoidAtt(getRandomDoubleInRange(0,1));
            ((Exoskeleton) monster).setExtraDef(1.25);
            monster.setDefRate(((Exoskeleton) monster).getExtraDef() * monster.getDefRate());
            NoExoskeletons++;
        }else if (monsterType == 2) {
            monster = new Spirit();
            monster.setName("Spirit" + Integer.toString(NoSpirits));
            monster.setLevel(levels[getRandomNumberInRange(0,3)]);
            monster.setMinDmg(15);
            monster.setMaxDmg(45);
            monster.setDefRate(23);
            monster.setAvoidAtt(getRandomDoubleInRange(0,1));
            ((Spirit) monster).setAvoidPlus(((Spirit) monster).getAvoidPlus() * monster.getAvoidAtt());
            NoSpirits++;
        }
        monster.setHp(80);
        monster.setAvoidSpell(0);
        monster.setDefRed(0);
        monster.setDmgRed(0);
        monster.setAvoidSpellRounds(0);
        monster.setDefRedRounds(0);
        monster.setDmgRedRounds(0);
        return monster;
    }
    private static int getRandomNumberInRange(int min , int max){
        Random r = new Random();
        return r.nextInt((max-min)+1)+min;
    }
    private static double getRandomDoubleInRange(double min , double max) {
        Random s = new Random();
        double k=  s.nextDouble() * (max-min) +min;
        return k;
    }
}





*/