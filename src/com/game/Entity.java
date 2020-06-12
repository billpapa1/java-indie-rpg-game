package com.game;

import java.awt.*;

public abstract class   Entity {
    public float x;
    public float y;

    public Entity() {
        this.x = 0;
        this.y = 0;
    }

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void update(double delta);



    public abstract void render(Graphics2D g, RenderInfo renderInfo);

    public void setX(float x) {
        this.x = x;
    }

    public float getX() {
        return this.x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getY() {
        return this.y;
    }


}