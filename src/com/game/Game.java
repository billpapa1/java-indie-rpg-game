package com.game;

import com.game.creatures.Hero;
import com.game.Physics.AABB;
import com.game.Physics.IntersectResult;
import com.game.creatures.Monster;
import com.game.ui.UIElement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game extends Canvas implements Runnable {
    private boolean isRunning = false;
    private Thread thread;

    private Level level;
    private Hero hero;
    private List<Entity> entitiesList = new ArrayList<>();

    private List<UIElement> uiElements = new ArrayList<>();
    private Font normalFont;

    public static HashSet<Integer> pressedKeys = new HashSet<>();

    public static final float LEVEL_SCALE = 90.0f / 16.0f;

    public Game() {
        setSize(1280, 720);
        setBackground(Color.ORANGE);

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                for (UIElement element : uiElements) {
                    if (e.isConsumed()) break;

                    element.mouseMoved(e);
                }
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                for (UIElement element : uiElements) {
                    if (e.isConsumed()) break;

                    element.mousePressed(e);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                for (UIElement element : uiElements) {
                    if (e.isConsumed()) break;

                    element.mouseReleased(e);
                }
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                for (UIElement element : uiElements) {
                    if (e.isConsumed()) break;

                    element.keyPressed(e);
                }

                pressedKeys.add(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                for (UIElement element : uiElements) {
                    if (e.isConsumed()) break;

                    element.keyReleased(e);
                }

                pressedKeys.remove(e.getKeyCode());
            }
        });

        this.normalFont = new Font("Times New Roman", Font.PLAIN, 30);

        this.hero = new Hero();
        this.entitiesList.add(new Monster());
        this.entitiesList.add(hero);
    }


    public void start() {
        if (!isRunning) {
            this.thread = new Thread(this);

            isRunning = true;
            this.thread.start();
        }
    }

    private void init() {
        this.level = new Level(0, 0, "/images/background_world.png");
    }

    private void update(double delta) {
        for (int i = 0; i < entitiesList.size(); i++) {
            entitiesList.get(i).update(delta);
        }

        //Check for intersections with other entities
        for (int i = 0; i < entitiesList.size(); i++) {
            Entity currentEntity = entitiesList.get(i);
            AABB currentAABB = currentEntity.getBoundingBox();

            for (int j = 0; j < entitiesList.size(); j++) {
                if(i == j) continue;

                Entity otherEntity = entitiesList.get(j);
                AABB otherAABB = otherEntity.getBoundingBox();

                IntersectResult intersect = currentAABB.intersect(otherAABB);
                if (!intersect.doesIntersect()) continue;

                currentEntity.onCollideWith(otherEntity);
                otherEntity.onCollideWith(currentEntity);
            }
        }
        //Update scene
        level.update(entitiesList, delta);
    }

    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            bs = getBufferStrategy();
        }

        Graphics2D g = (Graphics2D) bs.getDrawGraphics();

        float cameraX = -hero.getX() * LEVEL_SCALE + (getWidth() - hero.getSizeX() * LEVEL_SCALE) / 2;
        float cameraY = -hero.getY() * LEVEL_SCALE + (getHeight() - hero.getSizeY() * LEVEL_SCALE) / 2;

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.translate((int)cameraX, (int)cameraY);

        //Enable anti-aliasing
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setFont(normalFont);

        level.draw(g);

        for (int i = 0; i < entitiesList.size(); i++) {
            entitiesList.get(i).render(g);
        }

        for (UIElement element : uiElements) {
            element.draw(g);
        }

        //Display to screen
        g.dispose();
        bs.show();
    }

    private void destroy () {

    }

    @Override
    public void run () {
        double lastTime = 0;

        init();

        while (isRunning) {
            double elapsedTime = (System.nanoTime() - lastTime) / 1000000000.0;

            if (elapsedTime >= 1 / 60.0) {
                update(elapsedTime);
                render();

                lastTime = System.nanoTime();
            }
        }

        destroy();
    }

    public static void main (String[]args){
        Game game = new Game();

        JFrame frame = new JFrame();
        frame.setSize(1280, 720);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(game);

        game.start();
    }
}
