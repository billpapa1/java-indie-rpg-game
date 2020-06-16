package com.game;

import com.game.creatures.Hero;
import com.game.items.Armor;
import com.game.items.Potion;
//import com.game.items.Show;
import com.game.items.Weapon;
import com.game.spells.FireSpell;
import com.game.spells.IceSpell;
import com.game.spells.LightingSpell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Market {

    private String [] levels = {"easy", "intermediate", "legendary", "immortal"};
    private String [] features = {"healthPower", "magicPower", "strength", "dexterity", "agility"};
    private List <Weapon> weaponList;
    private List<Potion> potionList;
    private List<Armor>armorList;
    private List<IceSpell>iceSpellList;
    private List<FireSpell>fireSpellList;
    private List<LightingSpell>lightingSpellList;

    public Market(int NoHeroes) {

        this.weaponList=weaponList(NoHeroes);
        this.armorList=armorList(NoHeroes);
        this.potionList=potionList(NoHeroes);
        this.iceSpellList=iceSpellList(NoHeroes);
        this.fireSpellList=fireSpellList(NoHeroes);
        this.lightingSpellList=lightingSpellList(NoHeroes);

    }
    public List<Weapon> weaponList(int NoHeroes){
           List<Weapon> weaponList =new ArrayList<>();
                 for (int i = 0; i <2*NoHeroes  ; i++) {
                         String weaponName = "weapon"+Integer.toString(i);
                         Weapon weapon = new Weapon();
                         weapon.setName(weaponName);
                         weapon.setPrice ((int) ((i*0.1+1)*15));
                         weapon.setHandsReq(getRandomNumberInRange(1,2));
                         weapon.setMinLevel(levels[getRandomNumberInRange(0,3)]);
                         weapon.setDamage((i*0.10+1)*15);
                         weaponList.add(weapon);
                 }
             return weaponList;
     }
     public List<Armor> armorList(int NoHeroes){

         List<Armor> armorList= new ArrayList<>();
                for (int i = 0; i<2*NoHeroes; i++) {
                      String armorName = "armor"+Integer.toString(i);
                      Armor  armor = new Armor();
                      armor.setName(armorName);
                      armor.setPrice((int) ((i*0.2+1)*15));
                      armor.setMinLevel(levels[getRandomNumberInRange(0,3)]);
                      armor.setDmgRed ((i*0.10+1)*15);
                      armorList.add(armor);
                 }
        return armorList;
    }
    public List<Potion> potionList(int NoHeroes) {
                List<Potion> potionList =new ArrayList<>();
                    for (int i = 0; i <2*NoHeroes ; i++) {
                            String potionName = "potion" + Integer.toString(i);
                            Potion potion = new Potion();
                            potion.setName(potionName);
                            potion.setPrice((int) ((i * 0.16 + 1) * 15));
                            potion.setMinLevel(levels[getRandomNumberInRange(0, 3)]);
                            potion.setProperty(features[getRandomNumberInRange(0,4)]);
                            potion.setPropertyPerc((i * 30 + 25) * 0.01);
                            potionList.add(potion);
        }
        return potionList;
            
        }

    public List<IceSpell> iceSpellList(int noHeroes) {
        List<IceSpell> IceSpellList =new ArrayList<>();
        for (int i = 0; i <2; i++) {
            String IceSpellName = "Ice Spell" + Integer.toString(i);
            IceSpell iceSpell = new IceSpell();
            iceSpell.setName(IceSpellName);
            iceSpell.setPrice((i * 0.16 + 1) * 15);

            iceSpell.setMinLevel(levels[getRandomNumberInRange(0, 3)]);
            iceSpell.setMinDmg((i * 0.13 + 1) * 12);
            iceSpell.setMaxDmg((i * 0.12 + 1) * 20);
            iceSpell.setMagicEnergy((i * 0.11 + 1) * 11);
            iceSpell.setDmgRed((i * 0.08 + 1) * 6);
            iceSpellList.add(iceSpell);
        }
        return IceSpellList;

    }
    public List<FireSpell> fireSpellList(int noHeroes) {
        List<FireSpell> fireSpellList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            String fireSpellName = "Fire Spell Spell" + Integer.toString(i);
            FireSpell fireSpell = new FireSpell();
            fireSpell.setName(fireSpellName);
            fireSpell.setPrice((i * 0.16 + 1) * 15);

            fireSpell.setMinLevel(levels[getRandomNumberInRange(0, 3)]);
            fireSpell.setMinDmg((i * 0.13 + 1) * 12);
            fireSpell.setMaxDmg((i * 0.12 + 1) * 20);
            fireSpell.setMagicEnergy((i * 0.11 + 1) * 11);
            fireSpell.setDefRed((i * 0.08 + 1) * 6);
            fireSpellList.add(fireSpell);
        }
        return fireSpellList;
    }
    public List<LightingSpell> lightingSpellList(int noHeroes) {
        List<LightingSpell> LightingSpellList =new ArrayList<>();
        for (int i = 0; i <2; i++) {
            String lightingSpellName = "lighting Spell" + Integer.toString(i);
            LightingSpell lightingSpell = new LightingSpell();
            lightingSpell.setName(lightingSpellName);
            lightingSpell.setPrice((i * 0.16 + 1) * 15);

            lightingSpell.setMinLevel(levels[getRandomNumberInRange(0, 3)]);
            lightingSpell.setMinDmg((i * 0.13 + 1) * 12);
            lightingSpell.setMaxDmg((i * 0.12 + 1) * 20);
            lightingSpell.setMagicEnergy((i * 0.11 + 1) * 11);
            lightingSpell.setAvoidAtt(getRandomNumberInRange(0,3));
            lightingSpellList.add(lightingSpell);
        }
        return lightingSpellList;

    }



    public void MarketSales(Hero hero){  //method for market sales
        Scanner scanner= new Scanner(System.in); // introduction to the shop
        System.out.println("We welcome you in our shop , here you can buy weaponry , armor kit and spells which can assist you in your sacred quest");
        int yesOrNo= scanner.nextInt();
        switch (yesOrNo){
            case 1:
                    break;
            case 2: //question about buying  or selling an item
                System.out.println("Would you like to buy something or sell?");
                int BuyOrSell = scanner.nextInt();

            switch (BuyOrSell){
                case 1: //buy phase
                    Scanner scanner1 =new Scanner(System.in); //question regarding the target of the sale
                    System.out.println("What would you like to buy then? ");
                    int itemOrSpell = scanner1.nextInt();
                    switch (itemOrSpell){
                      //  case 1: Show.showItems(weaponList,armorList,potionList);
                   //    Scanner scanner2 = new Scanner(System.in);
                    //    System.out.println("So ,are you going to be any items !?");
                    //    int buyItem=scanner2.nextInt();
                        //switch (buyItem){
                            case 1: //
                                Scanner scanner3 =new Scanner(System.in);
                                System.out.println("Would you like an armor , a weapon or a potion? ");
                              //  int buyItem = scanner3.nextInt()
                        }
                    }
               }
        }


    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    private static double getRandomDoubleInRange(double min, double max) {
        Random r = new Random();
        double v = r.nextDouble() * (max - min) + min;
        return v;
    }


}


