package com.game;

import com.game.creatures.GameLogic;
import com.game.creatures.Player;

public class Story {
    public static void intro() {
        GameLogic.clearConsole();
        GameLogic.printSeperator(20);
        System.out.println("Story");
        GameLogic.printSeperator(30);
        System.out.println("Your village was raided by the Goblins");
        System.out.println("The vast majoriry of your relatives is dead , you won't easily find a friendly acquaintance if you follow this path ");
        System.out.println("Since you want to follow this path , what you want is revenge now. Your plan is to kill the master Goblin ");
        GameLogic.anythingToContinue();
    }

    public static void FirstActIntro() {
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("ACT I  - INTRO ");
        GameLogic.printSeperator(30);
        System.out.println("Your journey begins, scavenging for weapons at the battlefield and then running away into the woods");
        System.out.println("The forest is really quiet, you've heard stories that there are shape shifting creatures living in these woods");
        System.out.println("\nAfter walking for several hours, you find a shelter where you can camp for the day");
        System.out.println("Your one and only purpose in this life now is to ensure you brind justice");
        GameLogic.anythingToContinue();

    }

    public static void FirstActOutro() {
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("ACT I  - OUTRO ");
        GameLogic.printSeperator(30);
        System.out.println("You managed to make the night without alarming any monsters nearby");
        System.out.println("As you now entering another zone of this kingdom , you will now find new obstacles and enemies to confront");
        System.out.println("Experience is gained and you have a new attributed unlocked ");
        GameLogic.anythingToContinue();
    }

    public static void SecondActIntro() {
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("ACT II - INTRO ");
        GameLogic.printSeperator(30);
        System.out.println("You are now travelling for a more populated area, the city of Eragon ");
        System.out.println("You fought some small monsters on the way and now you have some gold in hand");
        System.out.println("You found a map that can lead to the Goblins safe ");
        System.out.println("Trying to come across with a shop to buy essential stuff");
        GameLogic.anythingToContinue();
    }

    public static void SecondActOutro() {
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("ACT II  - OUTRO ");
        GameLogic.printSeperator(30);
        System.out.println("You passed the town , now you are a few hours away from the your destination ");
        System.out.println("You are low on stamina, that's why you make a stop before commencing the fight");
        System.out.println("After all this experience you gain some knowledge and learn another trait ");
        GameLogic.anythingToContinue();
    }

    public static void ThirdActIntro() {
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("ACT III - INTRO ");
        GameLogic.printSeperator(30);
        System.out.println("Wake up and there you find a moving shop , deciding what to buy to enhance your chances against the Goblins ");
        System.out.println("You managed to sneak into the safe without beeing seen");
        System.out.println("You are rethinking what you are about to do  ");
        System.out.println("You have no regrets and now you are ready to enter the last chamber which belongs to the master Goblin");
        GameLogic.anythingToContinue();
    }
    public static void printEnd(Player player){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("Gongratulations"+ player.name + " You defeated the mighty Goblin");
        GameLogic.printSeperator(30);

    }
}
