package com.game;

import com.game.creatures.Creature;
import com.game.creatures.Hero;
import com.game.items.Item;
import com.game.items.Weapon;

import java.util.HashMap;

public class Inventory {
    public Creature owner;
    public HashMap<Item, Integer> inventory = new HashMap<Item, Integer>();

    public Inventory(Creature owner) {
        this.owner = owner;
    }

    public boolean incrementAmount(Item item, int change) {
        if (change > 0) {
            int oldValue = inventory.get(item);
            int newValue = oldValue + change;
            inventory.put(item, newValue);
            return true;
        } else {
            if (inventory.get(item) >= change) {
                int oldValue = inventory.get(item);
                int newValue = oldValue + change;
                inventory.put(item, newValue);
                return true;
            } else {
                return false;
            }
        }


    }

    public HashMap<Item, Integer> inventory() {
        return inventory;
    }
}


  /*  public String checkInventory(Hero player) {
        String output = "";
        for (Item key : inventory.keySet()) {
            if (!(key.getName().equalsIgnoreCase("Fists"))) {
                Integer amount = inventory.get(key);
                if (amount > 0) {
                    String name = key.getName();
                    output += "-----" + name;
                    if (key.getType().equalsIgnoreCase("Weapon")) {
                        key = (Weapon) key;
                        int str = key.getAt().getStrength();
                        int dxt = key.getAt().getdexterity();
                        int agi = key.getAt().getAgility();
                        int Mgc = key.getAt().getMagicPower();
                        output += "(" + str + ", " + dxt + ", " + agi + ", " + Mgc + ")";
                    }
                    output += ": " + amount + "\n";
                }
            }

        }
        return output;
    }*/


