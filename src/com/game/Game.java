package com.game;

import com.game.Physics.AABB;
import com.game.Physics.IntersectResult;
import com.game.creatures.Hero;
import com.game.creatures.Monster;
import com.game.ui.Button;
import com.game.ui.SimpleButton;
import com.game.ui.UIElement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class Game extends Canvas implements Runnable {
    private List<Entity> entitiesList = new ArrayList<>();
    private boolean isRunning = false;
    private Thread thread;
    private Level level;
    private Font normalFont;
    private Hero hero;
    private Monster monster;
   // private Camera camera;
   // private  int height , width;
    public BufferedImage enemy;
    public BufferedImage player;

    private List<UIElement> uiElements = new ArrayList<>();
    public static HashSet<Integer> pressedKeys = new HashSet<>();
  //  private KeyManager keyManager;
    public static final float LEVEL_SCALE = 90.0f/16.0f;

    public Game() {
        setSize(784, 700);
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
        ;
     //   this.uiElements.add(new SimpleButton(300, 150, 175, 75, "Button"));

        this.monster = new Monster();
        this.hero = new Hero();
        this.entitiesList.add(monster); // adding monster in the entity list
        this.entitiesList.add(hero); // adding hero in the entity list.
    }


    public void start() {
        if (!isRunning) {
            this.thread = new Thread(this);

            isRunning = true;
            this.thread.start();
        }
    }

    private void init() {
        enemy = ImageLoader.loadImage("/images/enemy.png"); // loading enemy png
        player = ImageLoader.loadImage("/images/player.png"); // loading players pngs

     //   Button button = new Button(450, 360, 50, 50, "/images/right arrow.png");
       // button.action = () -> {
  //      };
      //  uiElements.add(button);
        this.level = new Level(0, 0, "/images/background_world.png");

        //Button button1 = new Button(355, 260, 50, 50, "/images/up arrow.png");
      //  uiElements.add(button1);

      //  Button button2 = new Button(260, 360, 50, 50, "/images/left arrow.png");
       // uiElements.add(button2);

     //   Button button3 = new Button(350, 450, 50, 50, "/images/down arrow.png");
       //uiElements.add(button3);
    }

    private void update(double delta) {
    //    if (pressedKeys.contains(KeyEvent.VK_W)) {
         //   System.out.println("W pressed");
    //    }

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

        // render the background world
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
            frame.setSize(784, 900);
            frame.setResizable(true);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.add(game);

            game.start();
        }
    }
