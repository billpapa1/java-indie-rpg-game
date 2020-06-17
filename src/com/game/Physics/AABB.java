package com.game.Physics;

public class AABB {
    private float x;
    private float y;

    private float width;
    private float height;

    public AABB() {
        this(0, 0, 0, 0);
    }

    public AABB(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public IntersectResult intersect(AABB other) {
        float distX1 = other.x - x - width;
        float distX2 = other.x + other.width - x;
        float distY1 = other.y - y - height;
        float distY2 = other.y + other.height - y;

        boolean overlapsX = Math.signum(distX1) != Math.signum(distX2);
        boolean overlapsY = Math.signum(distY1) != Math.signum(distY2);

        float minDistX = Math.abs(distX1) < Math.abs(distX2) ? -distX1 : -distX2;
        float minDistY = Math.abs(distY1) < Math.abs(distY2) ? -distY1 : -distY2;

        if(overlapsX && overlapsY) {
            if(Math.abs(minDistX) < Math.abs(minDistY)) return new IntersectResult(minDistX, 0, true);
            else return new IntersectResult(0, minDistY, true);
        }

        return new IntersectResult(0, 0, false);
    }


    public void setX(float x) {
        this.x = x;
    }

    public float getX() {
        return x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getY() {
        return y;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getWidth() {
        return width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getHeight() {
        return height;
    }
}