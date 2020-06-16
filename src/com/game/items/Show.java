/*package com.game.items;

import com.game.creatures.Hero;
import com.game.creatures.Monster;
import com.game.spells.FireSpell;
import com.game.spells.IceSpell;
import com.game.spells.LightingSpell;

import java.util.List;


public class Show {
    public static void showSpells(List<IceSpell> list1, List<FireSpell> list2, List<LightingSpell> list3) {


        if (list1.size() != 0) {
            System.out.println("The list of your available Icespells");
            System.out.println(" ");
            for (IceSpell spell : list1) {
                System.out.println("name : " + spell.getName());
                System.out.println(("price : " + spell.getPrice()));
                System.out.println("Hero's level required : " + spell.getMinLevel());
                System.out.println("minimum damage :" + spell.getMinDmg());
                System.out.println("max damage : " + spell.getMaxDmg());
                System.out.println("magic Energy required :" + spell.getMagicEnergy());
                System.out.println("Damage reduction : " + spell.getDmgRed());
                System.out.println(" ");
            }
        } else {
            System.out.println("No IceSpells found");
        }
        if (list2.size() != 0) {
            System.out.println("The list of your available FireSpells");
            System.out.println(" ");
            for (FireSpell spell : list2) {
                System.out.println("name : " + spell.getName());
                System.out.println(("price : " + spell.getPrice()));
                System.out.println("Hero's level required : " + spell.getMinLevel());
                System.out.println("minimum damage :" + spell.getMinDmg());
                System.out.println("max damage : " + spell.getMaxDmg());
                System.out.println("magic Energy required :" + spell.getMagicEnergy());
                System.out.println("Damage reduction : " + spell.getDefRed());
                System.out.println(" ");
            }
        } else {
            System.out.println("No Firespells found");
        }
        if (list3.size() != 0) {
            System.out.println("The list of your available LightingSpells");
            System.out.println(" ");
            for (LightingSpell spell : list3) {
                System.out.println("name : " + spell.getName());
                System.out.println(("price : " + spell.getPrice()));
                System.out.println("Hero's level required : " + spell.getMinLevel());
                System.out.println("minimum damage :" + spell.getMinDmg());
                System.out.println("max damage : " + spell.getMaxDmg());
                System.out.println("magic Energy required :" + spell.getMagicEnergy());
                System.out.println("Damage reduction : " + spell.getAvoidAtt());
                System.out.println(" ");
            }
        } else {
            System.out.println("No Firespells found");
        }
    }

    public static void showItems(List<Weapon> list1, List<Armor> list2 , List<Potion> list3) {

        if (list1.size() != 0) {
            System.out.println("Here is a list of your available weapons: ");
            System.out.println("");
                for (Weapon weapon : list1) {
                        System.out.println("name: " + weapon.getPrice());
                        System.out.println("price: " + weapon.getPrice());
                        System.out.println("minimum hero's level required: " + weapon.getMinLevel());
                        System.out.println("damage: " + weapon.getDamage());
                        System.out.println("hands required: " + weapon.getHandsReq());
                        System.out.println("");
                }
        } else {System.out.println("No weapons found"); }

        if (list2.size() != 0) {
            System.out.println("Here is a list of your available armors: ");
            System.out.println("");
                for (Armor armor: list2) {
                        System.out.println("name: " + armor.getName());
                        System.out.println("price: " + armor.getPrice());
                        System.out.println("minimum hero's level required: " + armor.getMinLevel());
                        System.out.println("hands required: " + armor.getDmgRed());
                        System.out.println("");
                    }
        } else {System.out.println("No Armors found"); }

        if (list3.size() != 0) {
            System.out.println("Here is a list of your available armors: ");
            System.out.println("");
                 for (Potion potion: list3){
                        System.out.println("name: " + potion.getName());
                        System.out.println("price: " + potion.getPrice());
                        System.out.println("minimum hero's level required: " + potion.getMinLevel());
                        System.out.println("damage: " + potion.getProperty());
                        System.out.println("hands required: " +potion.getPropertyperc());
                        System.out.println("");
                    }
        } else {System.out.println("No Potions found"); }
    }

    public static void showHeroStats(Hero hero){
        System.out.println("Name: " +hero.getName());
        System.out.println("Game.Level: " +hero.getLevel());
        System.out.println(("Health Power: "+ hero.getHp()));
        System.out.println("Magic Power: " + hero.getMagicPower());
        System.out.println("Strength: "+hero.getStrength());
        System.out.println("Dexterity:"+hero.getDexterity());
        System.out.println("Agility:"+hero.getAgility());
        System.out.println("Money"+hero.getMoney());
        System.out.println("Experience"+hero.getExperience());
    }

    public static void showMonsterStats(Monster monster){
        System.out.println("Name:" + monster.getName());
        System.out.println("Game.Level:"+ monster.getLevel());
        System.out.println("Health Power"+ monster.getHp());
        System.out.println("Minimum Damage" +monster.getMinDmg());
        System.out.println("Maximum Damage"+ monster.getMaxDmg());
        System.out.println("Defense Rate"+ monster.getDefRate());
        System.out.println("Avoid Attack"+ monster.getAvoidAtt());
    }
    public static void PrintRow(String[] row) {
        for (String i:row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
        }
}

*/