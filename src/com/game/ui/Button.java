package com.game.ui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Button extends UIElement {
    public int x;
    public int y;
    public int w;
    public int h;
    public ButtonAction action = null;
    public BufferedImage image;

    public Button(int x, int y, int w, int h, String imagePath) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        if(imagePath != null) {
            try {
                image = ImageIO.read(getClass().getResourceAsStream(imagePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(this.action != null && (e.getX() >= x && e.getX() < (x + w)) && (e.getY() >= y && e.getY() < (y + h))) {
            this.action.pressed();
            e.consume();
        }
    }

    @Override
    public void draw(Graphics2D g) {
        if(image == null) return;

        g.drawImage(image, x, y, w, h, null);
    }

    public static interface ButtonAction {
        void pressed();
    }
}