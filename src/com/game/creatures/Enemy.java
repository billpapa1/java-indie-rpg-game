package com.game.creatures;

public class Enemy extends Character {
    int playerXp;
        public Enemy (String name , int playerXp){
            super(name, (int) (Math.random()*playerXp+playerXp/3 + 5), (int)(Math.random()*(playerXp/4)+1));
            this.playerXp=playerXp;
        }

    public Enemy() {
        super();
    }

    public Enemy(String enemy) {
    }

    @Override
    public int attack() {
        return (int) (Math.random()*(playerXp/4+7)+xp/4 + 3 );
    }

    @Override
    public int defend() {
        return (int) (Math.random()*(playerXp/4+7)+xp/4 + 3 );
    }
}
