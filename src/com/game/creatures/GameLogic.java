package com.game.creatures;

import com.game.Story;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class GameLogic {
    static Player player;
    static Scanner scanner = new Scanner(System.in);
    private static String title;
    public static boolean isRunning;
    public static String[] states = {"Batlle", "Battle", "Battle", "Rest", "Rest"};
    public static String[] enemies = {" Goblin ", " Elf ", " Goblin ", " Master Goblin ", " Ogre "};


    public static int place = 0, act = 1;
    public static String[] places = {"The Woods", " Eregon", "|Goblins safe", "Masters Goblin room"};

    //create a method to get user input from console
    public static int readInt(String prompt, int userChoices) {
        int input;

        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                input = -1;
                System.out.println("Please enter an integer");
            }
        } while (input < 1 || input > userChoices);
        return input;
    }

    //clear the console
    public static void clearConsole() {
        for (int i = 0; i < 100; i++)
            System.out.println();
    }        // method to create a seperator(length  n )

    public static void printSeperator(int n) {
        for (int i = -0; i < n; i++)
            System.out.print("-");
        System.out.println();
    }

    //method to print a heading
    public static void printHeading(String title) {
        printSeperator(30);
        System.out.println(title);
        printSeperator(30);
    }

    //method to stop the game until user enters anything
    public static void anythingToContinue() {
        System.out.println("enter anything to continue....");
        scanner.next();
    }

    //method to start the game
    public static void startGame() {
        boolean nameSet = false;
        String name;
        clearConsole();
        printSeperator(40);
        printSeperator(30);
        System.out.println("MONSTER HUNTER ");
        System.out.println("text rpg game");
        printSeperator(30);
        printSeperator(40);
        anythingToContinue();

        do {
            clearConsole();
            printHeading("What's your name? ");
            name = scanner.next();
            clearConsole();
            printHeading("Your name is " + name + "\nis that correct? ");
            System.out.println("(1) YES!");
            System.out.println("(2) No , i want to change my name");

            int input = readInt("->", 2);
            if (input == 1)
                nameSet = true;
        } while (!nameSet);

        //print story intro
        Story.intro();
        //new player object with the name inputted
        player = new Player(name);
        //print first act
        Story.FirstActIntro();
        //game loop can continue , isRunning set to true
        isRunning = true;
        // start main Game loop
        gameLoop();
    }

    //method to print out the info about the character
    public static void characterInfo() {
        clearConsole();
        printHeading("CHARACTER INFO ");
        System.out.println(player.name + "\tHP:" + player.hp + "/" + player.maxHp);
        printSeperator(20);
        System.out.println("XP:" + player.xp + "\tMoney: " + player.money);
        printSeperator(20);
        System.out.println("Number of potions: " + player.potions);
        printSeperator(20);
        if (player.numAtkUpgrades > 0) {
            System.out.println("Offensive Attributes :" + player.atkUpgrades[player.numAtkUpgrades - 1]);
            printSeperator(20);
        }
        if (player.numDefUpgrades > 0) {
            System.out.println("Defensive Attribute" + player.defUpgrades[player.numDefUpgrades - 1]);
        }
        anythingToContinue();

    }

    public static void checkAct() {
        if (player.xp > 10 && act == 1) {
            act = 2;
            place = 1;
            Story.intro();
            Story.FirstActOutro();
            player.chooseTrait();
            Story.SecondActIntro();
            //assign new values to enemies
            enemies[0] = "Mercenary";
            enemies[1] = "Tree village";
            enemies[2] = "Goblin pack";
            enemies[3] = "Henchman";
            enemies[4] = "Boss";
            //assign new values to states
            states[0] = "Battle";
            states[1] = "Battle";
            states[2] = "Battle";
            states[3] = "Rest";
            states[4] = "Shop";
            //Heal the player

        } else if (player.xp >= 50 && act == 2) {
            act = 3;
            place = 2;
            Story.SecondActOutro();
            player.chooseTrait();
            Story.ThirdActIntro();
            //assign new values to enemies
            enemies[0] = "Mercenary";
            enemies[1] = "Tree village";
            enemies[2] = "Goblin pack";
            enemies[3] = "Henchman";
            enemies[4] = "Boss";
            //assign new values to states
            states[0] = "Battle";
            states[1] = "Battle";
            states[2] = "Battle";
            states[3] = "Rest";
            states[4] = "Shop";

        } else if (player.xp >= 100 && act == 3) {
            act = 4;
            place = 3;
            finalBattle();

            player.hp = player.maxHp;
        }
    }

    public static void randomEncounter() {
        // random number between 0 and the length of the states array
        int encounter = (int) (Math.random() * states.length);
        if (states[encounter].equals("Battle")) {
            randomBattle();
        } else if (states[encounter].equals("Rest")) {
            takeRest();
        } else
            shop();

    }

    public static void continueStory() {  // method to continue story
        checkAct(); //check in which act
        if (act != 4) {
            randomEncounter();

        }
    }

    public static void shop() {
        clearConsole();
        printHeading("While wandering you found an old cabin , you can hear someone whistling joyfully. Its time for shopping");
        int price = (int) (Math.random() * (10 + player.potions * 3) + 10 + player.potions);
        System.out.println(Arrays.toString(player.swords) + price + "gold.");
        printSeperator(20);
        System.out.println("This is a fire sale today , this sword is unbreakable! , Would you like to buy it? \n (1) Yes! \n(2)No Thanks ");
        int input2 = readInt("->", 2);
        if (input2 == 1) {
            clearConsole();
            //check if he has enought money
            if (player.money >= price) {
                printHeading("That's what I like to see , Have a good one with this tool");
                player.money -= price;
            } else
                printHeading("Not enough money to buy my masterpiece ");
            anythingToContinue();
        }
    }

    public static void takeRest() { //taking rest method
        clearConsole();
        if (player.rests >= 1) {
            printHeading("Do you want to rest a bit ? (" + player.rests + "rest(s) left).");
            System.out.println("(1) Yes \n (2) No , I have to keep going");
            int input = readInt("->", 2);
            if (input == 1) {
                clearConsole();
                if (player.hp < player.maxHp) {
                    int hpRegain = (int) (Math.random() * (player.xp / 4 + 1) + 10);
                    player.hp += hpRegain;
                    if (player.hp > player.maxHp)
                        player.hp = player.maxHp;
                    System.out.println("While resting you managed to restore up to " + hpRegain + "health");
                    System.out.println("Your current HP is :  " + player.hp + "/" + player.maxHp);
                    player.rests--;
                }
            } else
                System.out.println("You have to keep going, you are full on health");
            anythingToContinue();

        }
    }

    public static void randomBattle() {
        clearConsole();
        printHeading("You are encountering an evil creature");
        anythingToContinue();
        battle(new Enemy(enemies[(int) (Math.random() * enemies.length)], player.xp));
    }

    public static void battle(Enemy enemy) {
        //main Battle loop
        while (true) {
            clearConsole();
            printHeading(enemy.name + "  \nHP: " + enemy.hp + " /  " + enemy.maxHp);
            printHeading((player.name + "  \nHP  " + player.hp + " / " + player.maxHp));
            System.out.println("Choose an action");
            printSeperator(30);
            System.out.println(" (1)FIGHT\n (2) USE POTION\n (3) ESCAPE  ");
            int input = (readInt("->", 3));
            //if conditions to react to user input
            if (input == 1) {
                clearConsole();
                System.out.println("How would you like to attack ");
                printSeperator(20);
                System.out.println("(1) Basic attack\n (2) Use spells ");
                int input6 = (readInt("->", 2));
                if (input6 == 1) {
                    int dmg = player.attack() - enemy.defend();
                    int dmgTaken = enemy.attack() - player.defend();

                    if (dmgTaken < 0) {
                        dmg -= dmgTaken / 2;
                        dmgTaken = 0;
                    }
                    if (dmg < 0)
                        dmg = 0;
                    //deal damage to both
                    player.hp -= dmgTaken;
                    enemy.hp -= dmg;
                    clearConsole();
                    printHeading("BATTLE ");
                    System.out.println(" You dealth " + dmg + " damage to " + enemy.name + ".");
                    printSeperator(15);
                    System.out.println(" The enemy " + enemy.name + " dealt " + dmgTaken + " damage to you ");
                    anythingToContinue();
                    //check if still alive or dead
                    if (player.hp <= 0) {
                        playerDied();
                        break;
                    } else if (enemy.hp <= 0) {
                        clearConsole();
                        printHeading("You defeated the " + enemy.name + "!");
                        player.xp += enemy.xp;
                        System.out.println("You earned" + enemy.xp + "XP!");
                        boolean addRest = (Math.random() * 5 + 1 <= 2.2);
                        int moneyEarned = (int) (Math.random() * enemy.xp);
                        if (addRest) {
                            player.rests++;
                            System.out.println("You might have time for another rest ");
                        }
                        anythingToContinue();
                        break;
                    }
                } else if (input6 == 2) {

                }

            } else if (input == 2) {  // use potion (2nd part)
                clearConsole();
                if (player.potions > 0 && player.hp < player.maxHp) {
                    System.out.println("Do you want to regain some health drinking a potion?(" + player.potions + "left).");
                    System.out.println("(1)Yes\n (2) No, maybe later");
                    int input1 = readInt("->", 2);
                    if (input1 == 1) {
                        player.hp = player.maxHp;
                        clearConsole();
                        printHeading("Your health has been restored, you now have " + player.maxHp);
                        anythingToContinue();
                    }
                }
            } else { // run away
                clearConsole();
                if (Math.random() * 10 + 1 <= 3.5) {
                    printHeading("You ran away from" + enemy.name + " like a coward");
                    anythingToContinue();
                    break;
                } else {
                    printHeading("You couldn't escape ");
                    int dmgTaken = enemy.attack();
                    System.out.println("While you running , you took" + dmgTaken + "damage!");
                    anythingToContinue();
                    if (player.hp <= 0) {
                        playerDied();
                    }
                }
            }
        }
    }

    public static void finalBattle() {
        battle(new Enemy("The master Goblin", 300));

        Story.printEnd(player);
        isRunning = false;

    }


    public static void printMenu() {
        //printing story
        clearConsole();
        printHeading(places[place]);
        System.out.println("choose an action ");
        printSeperator(20);
        System.out.println("(1) Continue your story");
        System.out.println("(2) Character Info ");
        System.out.println("(3) Exit Game");
    }

    public static void playerDied() { //when player dies
        clearConsole();
        printHeading("You died miserably.........");
        printHeading("You earned " + player.xp + "XP on your journey , Try for more next time ");
        isRunning = false;
    }

    public static void gameLoop() {
        while (isRunning) {
            printMenu();
            int input = readInt("->", 3);
            if (input == 1)
                continueStory();
            else if (input == 2)
                characterInfo();
            else
                isRunning = false;
        }
    }
}


