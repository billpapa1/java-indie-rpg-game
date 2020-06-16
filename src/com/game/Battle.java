/*package com.game;

import com.game.creatures.Hero;
import com.game.creatures.Monster;
import com.game.items.Potion;
import com.game.items.Show;
import com.game.items.Weapon;
import com.game.spells.FireSpell;
import com.game.spells.IceSpell;
import com.game.spells.LightingSpell;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Battle implements Runnable  {
    public static final String[] attributes = {"healthPower", "magicPower", "strength", "dexterity", "agility"};
    private static String[] levels = {"easy", "intermediate", "legendary", "immortal "};

    //   private int Monsters  = CreatureInit.getHeroes() *2;


    public static void usePotion(Hero hero) {
        if (hero.getHeroPotionList().size() != 0) {
            System.out.println("The number of potions you posses ");
        }
        for (Potion potion : hero.getHeroPotionList()) {
            System.out.println("name: " + potion.getName());
            System.out.println("Property to increase: " + potion.getProperty());
            System.out.println(("Property percentage increased" + potion.getPropertyperc()));
        }
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("How many potions would you like to use, we have from 0 to" + (hero.getHeroPotionList().size() - 1));
        int PickPotion = scanner1.nextInt();
        String property = hero.getHeroPotionList().get(PickPotion).getProperty();
        double percentage = hero.getHeroPotionList().get(PickPotion).getPropertyperc();

        for (int j = 0; j < attributes.length; j++) { //for loop through the attributes (Numerated) array
            if (attributes[j].equals(property)) {
                if (j == 0) {
                    hero.setHp(((1 + percentage) * hero.getHp())); // set hp with a perc
                    System.out.println("Hero's Health Power increased to " + hero.getHp()); //msg
                } else if (j == 1) {
                    hero.setMagicPower((int) ((1 + percentage) * hero.getMagicPower())); // set magic power with a perc
                    System.out.println("Hero's magic power increased" + hero.getMagicPower()); //msg
                } else if (j == 2) {
                    hero.setStrength((int) ((1 + percentage) * hero.getStrength())); // set strength with a perc
                    System.out.println(("Hero's strength increased" + hero.getStrength())); //mgs
                } else if (j == 3) {
                    hero.setDexterity((int) ((1 + percentage) * hero.getDexterity())); //set dexterity with a perc
                    System.out.println(("Hero's dexterity increased") + hero.getDexterity()); //msg
                } else {
                    hero.setAgility((int) (1 + percentage) * hero.getAgility()); //set agility with a perc
                    System.out.println("Hero's agility increased" + hero.getAgility()); //msg
                }
                hero.getHeroPotionList().remove(hero.getHeroPotionList().get(PickPotion)); //removal of potion
                System.out.println("A potion was used"); // a potion was erased from the list
            } else {
                System.out.println("No more Potions");  //message that there are not potions left
            }
        }
    }

    public static void equip(Hero hero) { //equip  class
        Scanner scanner4 = new Scanner(System.in); //user input
        System.out.println("Equip an armor" + (hero.getHeroArmorList().size() - 1) + "if you don't want to equip an armor type 0");//msg
        int pickArmor = scanner4.nextInt(); //assign the input- variable pickArmor
        if (pickArmor == 0) { //if user input == 0
            System.out.println("Hmm alright mate , let's pick a weapon then"); // msg
        } else { //if not then
            for (int k = 0; k < hero.getHeroArmorList().size(); k++) //for loop to go through armor list
                if (k == pickArmor) { // if k found == with user input  then
                    hero.setArmorEqquiped(hero.getHeroArmorList().get(pickArmor)); // equip selected armor from inventory
                    System.out.println("Hero: " + hero.getName() + "is now equipped with armor " + hero.getArmoredEqquiped().getName()); // msg
                }
        }
        Scanner scanner3 = new Scanner(System.in); // user input
        System.out.println("Pick a weapon for your hero " + (hero.getHeroWeaponList().size() - 1) + " if you don't need a weapon type 0"); //msg
        int pickWeapon = scanner3.nextInt(); //assign the inpit - variable pick weapon
        if (pickWeapon == 0) { //if user input == 0
            System.out.println("Didn't pick anything , you better leave"); // msg
        } else { // if not
            for (int i = 0; i < hero.getHeroWeaponList().size(); i++) { // for loop through weapon list
                if (i == pickWeapon) { // if user input found then
                    hero.setWeaponEqquiped(hero.getHeroWeaponList().get(pickWeapon)); // equip weapon to hero
                    System.out.println("Your hero " + hero.getName() + "has now the " + hero.getWeaponEqquiped().getName()); // msg
                }
            }
        }
    }

    public static void HeroAttack(Hero[] heroes, Monster[] monsters) { // Attack class
        Monster defMonster = null;
        while (defMonster == null) {
            Scanner scanner1 = new Scanner(System.in); // user input
            int pickHeroAttack = scanner1.nextInt(); // assign user input
            Hero heroattacks = heroes[pickHeroAttack];
            int herolvlIndex = Arrays.asList().indexOf(heroattacks.getLevel());
            for (Monster monster : monsters) {
                int monsterLevelIndex = Arrays.asList(levels).indexOf(monster.getLevel());
                if (Math.abs(herolvlIndex - monsterLevelIndex) <= 1) ;
                {
                    defMonster = monster;
                }
            }
            if (defMonster != null) {
                System.out.println("Hero:" + heroattacks.getName() + "is attacking Monster:" + defMonster.getName());
                if (defMonster.getAvoidSpellRounds() > 0) {
                    defMonster.setAvoidAtt(defMonster.getAvoidAtt() - defMonster.getAvoidSpell());
                    defMonster.setAvoidSpellRounds(defMonster.getAvoidSpellRounds() - 1);
                }
                if (defMonster.getAvoidAtt() < 0.5) {
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Select your attack , normal attack (1) , cast spell (2) , usePotion , changeArmor(3) ");
                    int pickAction = scanner2.nextInt();
                    System.out.println("Since you wish to attack, here is a list with the weapons available");
                    System.out.println(" ");
                    for (Weapon weapon : heroattacks.getHeroWeaponList()) {
                        System.out.println("name: " + weapon.getName());
                        System.out.println("damage" + weapon.getDamage());
                        System.out.println("Hands required" + weapon.getHandsReq());
                        System.out.println(" ");
                    }
                    Scanner scanner3 = new Scanner(System.in);
                    System.out.println("Select the weapon you would like to equip to your character "); // numerated
                    int pickWeapon = scanner3.nextInt();
                    heroattacks.setWeaponEqquiped((heroattacks.getHeroWeaponList().get(pickWeapon)));
                    switch (pickAction) {
                        case 1:
                            System.out.println(" Your Hero" + heroattacks.getName() + "a normal attack to" + defMonster.getName());
                    }
                    if (defMonster.getDefRedRounds() != 0) {
                        defMonster.setDefRate(defMonster.getDefRate() - defMonster.getDefRed());

                        defMonster.setDmgRedRounds(defMonster.getDmgRedRounds() - 1);
                    }
                    if (defMonster.getHp() - heroattacks.getWeaponEqquiped().getDamage() + defMonster.getDefRate() < 0) {
                        defMonster.setHp(0);
                    } else {
                        defMonster.setHp(defMonster.getHp() - heroattacks.getWeaponEqquiped().getDamage() + defMonster.getDefRate());
                    }
                    System.out.println("Attack was successful  ");
                } else {
                    System.out.print(" There are no weapons for you to use ");
                }
                break;
            }
            System.out.println("Hero" + heroattacks.getName() + "is going to cast a spell to" + defMonster.getName());
            Show.showSpells(heroattacks.getHeroIceSpellList(), heroattacks.getHeroFireSpellList(), heroattacks.getHeroLightingSpellList());
            Scanner scanner5 = new Scanner(System.in);
            System.out.println(" Select which spell , ice spell (1) , fire spell(2) , lighting spell(3) ");
            int pickSpell = scanner5.nextInt();
            switch (pickSpell) {
                case 1:
                    Scanner scanner6 = new Scanner(System.in);
                    int pickIceSpell = scanner6.nextInt();
                    IceSpell icespell = heroattacks.getHeroIceSpellList().get(pickIceSpell);
                    double dmg = getRandomNumberInRange(icespell.getMinDmg(), icespell.getMaxDmg());

                    if (defMonster.getHp() - dmg + defMonster.getDefRate() < 0) {
                        defMonster.setHp(0);
                    } else {
                        defMonster.setHp(defMonster.getHp() - dmg + defMonster.getDefRate());
                    }
                    defMonster.setDmgRed(icespell.getDmgRed());
                    defMonster.setDmgRedRounds(getRandomIntInRange(1, 3));
                    heroattacks.setMagicPower((int) (heroattacks.getMagicPower() - icespell.getMagicEnergy()));
                    System.out.println("Successful use of spell ");
                    break;
            }
            heroattacks.getHeroFireSpellList();
            Scanner scanner6 = new Scanner(System.in);
            int pickFireSpell = scanner6.nextInt();
            FireSpell fireSpell = heroattacks.getHeroFireSpellList().get(pickFireSpell);

            double dmg2 = getRandomNumberInRange(fireSpell.getMinDmg(), fireSpell.getMaxDmg());

            defMonster.setDefRed(fireSpell.getDefRed());
            if (defMonster.getHp() - dmg2 + defMonster.getDefRate() - defMonster.getDefRed() < 0) {
                defMonster.setHp(0);
            } else {
                defMonster.setHp(defMonster.getHp() - dmg2 + defMonster.getDefRate() - defMonster.getDefRed());
                defMonster.setDefRedRounds((int) getRandomNumberInRange(1, 3));
                heroattacks.setMagicPower((int) (heroattacks.getMagicPower() - fireSpell.getMagicEnergy()));
                System.out.println("Firespell used ");
                break;
            }
                Scanner scanner7 = new Scanner(System.in);
                int pickLightingSpell = scanner7.nextInt();
                heroattacks.getHeroLightingSpellList().get(pickLightingSpell);
                LightingSpell lightingSpell = heroattacks.getHeroLightingSpellList().get(pickLightingSpell);
                double dmg3 = getRandomNumberInRange(lightingSpell.getMinDmg(), lightingSpell.getMaxDmg());

                if (defMonster.getHp() - dmg3 + defMonster.getDefRate() < 0) {
                    defMonster.setHp(0);
                } else {
                    defMonster.setHp(defMonster.getHp() - dmg3 + defMonster.getDefRate());
                }
                defMonster.setAvoidSpell(lightingSpell.getAvoidAtt());
                defMonster.setAvoidSpellRounds(getRandomIntInRange(1, 3));
                heroattacks.setMagicPower((int) (heroattacks.getMagicPower() - lightingSpell.getMagicEnergy()));
                System.out.println("Lighting spell used");
                break;

                // public static void main(Object attacker, Object defender) {
                //   if (attacker instanceof Hero) {
                // }
            }
        }

    private static double getRandomNumberInRange ( double min, double max){
        Random r = new Random();
        double v = r.nextDouble() * (max - min) + min;
        return v;
    }

    private static int getRandomIntInRange ( int mini, int maxi){
        Random r = new Random();
        return (int) (r.nextInt((int) ((maxi - mini) + 1)) + mini);
    }

    @Override
    public void run() {

    }
}
//https://www.bing.com/videos/search?q=a+console+rpg+battle+system+in+java&&view=detail&mid=FBF7C7098F0E0B910F87FBF7C7098F0E0B910F87&&FORM=VRDGAR&ru=%2Fvideos%2Fsearch%3Fq%3Da%2520console%2520rpg%2520battle%2520system%2520in%2520java%26qs%3Dn%26form%3DQBVDMH%26sp%3D-1%26pq%3Da%2520console%2520rpg%2520battle%2520system%2520in%2520ja%26sc%3D0-33%26sk%3D%26cvid%3DDF5FDE4D27854BB28ACA7EC9065B7218

*/