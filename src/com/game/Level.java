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

        this.blocks = new ArrayList<AABB>();
        this.blocks.add(new AABB(102, 106, 5, 48));
        this.blocks.add(new AABB(102, 91, 86, 15));
        this.blocks.add(new AABB(102, 154, 105, 15));

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


