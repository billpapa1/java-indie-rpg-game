package com.game.creatures;

import com.game.Story;

import java.awt.*;
import java.util.Scanner;

public class GameLogic {
    static Player player;
    static Scanner scanner = new Scanner(System.in);
    private static String title;
    public static boolean isRunning;
    public static String[] states = {"Batlle", "Battle", "Battle", "Rest", "Rest"};
    public static String[] enemies = {"Goblin", "Elf", "|Goblin", "Master Goblin", "Ogre"};


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
        System.out.println("XP:" + player.xp);
        printSeperator(20);
        if (player.numAtkUpgrades > 0) {
            System.out.println("Offensive Attribute:" + player.attributes[player.numAtkUpgrades - 1]);
            printSeperator(20);
        }
        if (player.numDefUpgrades > 0) {
            System.out.println("Defensive Attribute" + player.attributes[player.numDefUpgrades - 1]);
        }
        anythingToContinue();

    }

    public static void checkAct() {
        if (player.xp > 10 && act == 2) {
            act = 2;
            place = 1;
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
        } else if (player.xp >= 100 && act == 2)
            act = 4;
        place = 3;
       // Story.printEnd();
        player.chooseTrait();
        player.hp = player.maxHp;
    }

     //   public static void randomEncounter(){
        //random number between 0 and the length of the states array
              //  int encounter = (int)(Math.random()*states.length);
           //     if (states[encounter].equals("Battle")) {
                    //randomBattle();
             //   } else if (states[encounter].equals(("Rest")) {
                //takeRest();
             //    } else {
                    //shop();
              //  }
    //    }
        public static void continueStory () {
            checkAct();
            if (act != 4) {
              //  randomEncounter();

            }
        }
        public static void randomBattle() {
            clearConsole();
            printHeading("You are encountering an evil creature");
            anythingToContinue();
        //  battle(new Enemy(enemies));
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


