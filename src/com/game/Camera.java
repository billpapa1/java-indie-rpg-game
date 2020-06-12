package com.game;

public class Camera {
    private float xOffset , yOffset;

    public float getxOffset() {
        return xOffset;
    }
    public void move(float xAmt , float yAmt){
        xOffset += xAmt;
        yOffset += yAmt;

    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }

    public Camera (float xOffset , float yOffset){
        this.xOffset=xOffset;
        this.yOffset=yOffset;

    }
}
