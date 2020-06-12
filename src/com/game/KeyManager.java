package com.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class KeyManager implements KeyListener {
    private boolean[] keys;
    public boolean  up, dw, lt , rt;
    public KeyManager() {
        keys = new boolean[256];
    }
    public void tick(){
        up = keys[KeyEvent.VK_W];
        dw = keys[KeyEvent.VK_S];
        lt = keys[KeyEvent.VK_A];
        rt = keys[KeyEvent.VK_D];
        }



    @Override
    public void keyTyped(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        System.out.println("pressed!");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()]= false;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
