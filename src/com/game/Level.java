package com.game;

import com.game.Physics.AABB;
import com.game.Physics.AABB;
import com.game.Physics.IntersectResult;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Level {
    private BufferedImage image;
    private ArrayList<AABB> blocks;

    private boolean showColliders;

    public Level(int x, int y, String imagePath) {
        this.image = ImageLoader.loadImage(imagePath);
        // creation of blocks and boundaries
        this.blocks = new ArrayList<AABB>();
        this.blocks.add(new AABB (0,0,700,0)); //x top boundary
        this.blocks.add(new AABB(0,0,0,400)); //y left side boundary
        this.blocks.add(new AABB(0,400,700,0)); //x bottom boundary
        this.blocks.add(new AABB(700,0,0,400)); //y right side boundary
        this.blocks.add(new AABB(105, 95, 1, 60)); // fence side left near the main house
        this.blocks.add(new AABB(110, 91, 75, 1)); // fence top
        this.blocks.add(new AABB(110, 154, 90, 1)); //fence bottom
        this.blocks.add(new AABB( 225,0, 90,115)); // house in the middle
        this.blocks.add(new AABB(195, 55, 1, 70)); //STAIRS main house over
        this.blocks.add(new AABB(195,55,25,1));   //STAIRS main house   side
        this.blocks.add(new AABB( 459, 30,15,15)); //TREE right side
        this.blocks.add(new AABB( 50, 30,17,17)); //TREE left top side - MIDDLE ONE
        this.blocks.add(new AABB( 78, 45,25,17)); //TREE left top side - RIGHT ONE
        this.blocks.add(new AABB( 0, 45,45,17)); //TREE left top side -LEFT ONE
        this.blocks.add(new AABB( 100, 30,40,17)); //TREE MIDDLE BEHIND MAIN HOUSE  - LEFT ONE
        this.blocks.add(new AABB( 150, 50,17,27)); //TREE  MIDDLE BEHIND MAIN HOUSE - MIDDLE ONE
        this.blocks.add(new AABB( 130, 75,7,10)); //TREE INSIDE FENCE MAIN HOUSE  (OVER FENCE) =LEFT ONE
        this.blocks.add(new AABB( 127, 95,13,10)); //TREE INSIDE FENCE MAIN HOUSE  (UNDER FENCE) = LEFT ONE
        this.blocks.add(new AABB( 167, 75,7,10)); //TREE INSIDE FENCE MAIN HOUSE  (OVER FENCE) =RIGHT ONE
        this.blocks.add(new AABB( 165, 95,13,10)); //TREE INSIDE FENCE MAIN HOUSE  (UNDER FENCE) = RIGHT ONE

        this.showColliders = true;
    }

    public void update(List<Entity> entities, double delta) {
        for (int i = 0; i < entities.size(); i++) {
            Entity currentEntity = entities.get(i);

            for (int j = 0; j < blocks.size(); j++) {
                AABB otherAABB = blocks.get(j);

                IntersectResult intersect = otherAABB.intersect(currentEntity.getBoundingBox());
                if (!intersect.doesIntersect()) continue;

                currentEntity.x += intersect.getDistanceX();
                currentEntity.y += intersect.getDistanceY();
            }
        }
    }

    public void draw(Graphics2D g) {
        g.drawImage(image, 0, 0, (int)(image.getWidth() * Game.LEVEL_SCALE), (int)(image.getHeight() * Game.LEVEL_SCALE), null);

        if(showColliders) {
            g.setColor(Color.RED);
            for (int i = 0; i < blocks.size(); i++) {
                AABB aabb = blocks.get(i);
                g.drawRect((int)(aabb.getX() * Game.LEVEL_SCALE), (int)(aabb.getY() * Game.LEVEL_SCALE),
                        (int)(aabb.getWidth() * Game.LEVEL_SCALE), (int)(aabb.getHeight() * Game.LEVEL_SCALE));
            }
        }
    }
}


