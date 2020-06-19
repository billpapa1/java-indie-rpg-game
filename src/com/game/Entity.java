package com.game;

import com.game.Physics.AABB;

import java.awt.*;

public abstract class Entity {
    protected float x;
    protected float y;

    protected float sizeX;
    protected float sizeY;

    public Entity() {
        this.x = 100;
        this.y =100;
    }

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void update(double delta);

    public abstract void render(Graphics2D g);

    public void onCollideWith(Entity other) {}

    public AABB getBoundingBox() {
        return new AABB(x, y, sizeX, sizeY);
    }

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

    public void setSizeX(float sizeX) { this.sizeX = sizeX; }

    public float getSizeX() { return this.sizeX; }

    public void setSizeY(float sizeY) { this.sizeY = sizeY; }

    public float getSizeY() { return this.sizeY; }
}