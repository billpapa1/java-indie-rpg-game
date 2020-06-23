package com.game.creatures;

import com.game.Entity;
import com.game.Game;
import com.game.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;


import static java.awt.event.KeyEvent.*;

public class Hero extends Creature {
    private BufferedImage player;

    public BufferedImage getPlayer(int x) {
        return player;
    }

    public void setPlayer(BufferedImage player) {
        this.player = player;
    }

    @Override
    public void setX(float x) {
        super.setX(x);
    }

    @Override
    public float getX() {
        return super.getX();
    }

    @Override
    public void setY(float y) {
        super.setY(y);
    }

    @Override
    public float getY() {
        return super.getY();
    }

    public Hero() {
        this.player = ImageLoader.loadImage("/images/player.png");

        sizeX = player.getWidth();
        sizeY = player.getHeight();
    }


    public void render(Graphics2D g) {
        g.drawImage(player, (int) (Game.LEVEL_SCALE * x), (int) (Game.LEVEL_SCALE * y),
                (int) (sizeX * Game.LEVEL_SCALE), (int) (sizeY * Game.LEVEL_SCALE), null);
    }

    @Override
    public void update(double delta) {
        float speed = 64;

        if (Game.pressedKeys.contains(VK_W)) {
            y -= speed * delta;
        }

        if (Game.pressedKeys.contains(VK_A)) {
            x -= speed * delta;
        }

        if (Game.pressedKeys.contains(VK_D)) {
            x += speed * delta;
        }

        if (Game.pressedKeys.contains(VK_S)) {
            y += speed * delta;
        }
    }

    @Override
    public void onCollideWith(Entity other) {

    }
}