package com.game.Physics;

public class IntersectResult {
    private float distanceX;
    private float distanceY;

    private boolean doesIntersect;

    public IntersectResult(float distX, float distY, boolean intersects) {
        this.distanceX = distX;
        this.distanceY = distY;
        this.doesIntersect = intersects;
    }

    public float getDistanceX() {
        return distanceX;
    }

    public float getDistanceY() {
        return distanceY;
    }

    public boolean doesIntersect() {
        return doesIntersect;
    }
}
