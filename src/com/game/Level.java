package com.game;

import com.game.ui.Button;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Level{
    public BufferedImage image;
    public Button.ButtonAction action = null;

    public Level(int x, int y, String imagePath) {



        if(imagePath != null) {
            try {
                image = ImageIO.read(getClass().getResourceAsStream(imagePath));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void update(double delta) {

    }

    void draw(Graphics2D g) {
        g.drawImage(image, 0, 0, (int)(image.getWidth() * Game.LEVEL_SCALE), (int)(image.getHeight() * Game.LEVEL_SCALE), null);


    }
}


