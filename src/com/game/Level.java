package com.game;

import com.game.Physics.AABB;
import com.game.Physics.IntersectResult;
import com.game.creatures.Hero;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Level {
    private BufferedImage image;
    private ArrayList<AABB> blocks;
    private Hero hero;

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
        this.blocks.add(new AABB(246, 152, 2, 2)); //Mail box under main house
        this.blocks.add(new AABB(297, 152, 5, 1)); //Sign in front of main house (near mail box)
        this.blocks.add(new AABB(180, 200,2,2)); // Second sign under the main house (under the road)
        this.blocks.add(new AABB( 100, 233,24,1)); // Bench under the main house (under the road) (PARK)
        this.blocks.add(new AABB( 225,0, 90,115)); // house in the middle
        this.blocks.add(new AABB(195, 55, 1, 70)); //STAIRS main house over
        this.blocks.add(new AABB(195,55,25,1));   //STAIRS main house   side
        this.blocks.add(new AABB( 50, 30,17,17)); //TREE left top side - MIDDLE ONE
        this.blocks.add(new AABB( 78, 45,25,17)); //TREE left top side - RIGHT ONE
        this.blocks.add(new AABB( 0, 45,45,17)); //TREE left top side -LEFT ONE
        this.blocks.add(new AABB( 100, 30,40,17)); //TREE MIDDLE BEHIND MAIN HOUSE  - LEFT ONE
        this.blocks.add(new AABB( 150, 50,17,27)); //TREE  MIDDLE BEHIND MAIN HOUSE - MIDDLE ONE
        this.blocks.add(new AABB( 130, 75,7,10)); //TREE INSIDE FENCE MAIN HOUSE  (OVER FENCE) =LEFT ONE
        this.blocks.add(new AABB( 127, 95,13,10)); //TREE INSIDE FENCE MAIN HOUSE  (UNDER FENCE) = LEFT ONE
        this.blocks.add(new AABB( 167, 75,7,10)); //TREE INSIDE FENCE MAIN HOUSE  (OVER FENCE) =RIGHT ONE
        this.blocks.add(new AABB( 165, 95,13,10)); //TREE INSIDE FENCE MAIN HOUSE  (UNDER FENCE) = RIGHT ONE
        this.blocks.add(new AABB( 425, 30,50,15)); //TREE right side of the map (second house left top)
        this.blocks.add(new AABB( 425, 65,25,15)); //TREE right side of the map (second house left top)
        this.blocks.add(new AABB( 400, 0,20,5)); //TREE on top right side
        this.blocks.add(new AABB( 330, 0,40,10)); //TREE on top right side
        this.blocks.add(new AABB( 370, 20,30,1)); //Bench right top middle of main house and right house
        this.blocks.add(new AABB( 470, 0,90,90)); // House on the right top
        this.blocks.add(new AABB( 463, 120,2,2)); // Mail box house on the right top
        this.blocks.add(new AABB( 420, 119,2,2)); // Sign in front of house on the right top
        this.blocks.add(new AABB( 580, 120,90,1)); // Fence under the house on the right top /perpendicular
        this.blocks.add(new AABB( 670, 120,1,33)); // Fence under the house on the right top /side
        this.blocks.add(new AABB( 680, 90,15,25)); //TREE right side of the house
        this.blocks.add(new AABB( 560, 0,40,35)); //TREE right side of the house
        this.blocks.add(new AABB( 560, 0,80,13)); //TREE on top right side
        this.blocks.add(new AABB( 625, 0,30,35)); //TREE on top right side
        this.blocks.add(new AABB( 650, 0,40,90)); //TREE on top right side
        this.blocks.add(new AABB( 425, 205,93,1)); // Fence over bottom house( pond)/perpendicular
        this.blocks.add(new AABB( 518, 205,1,30)); // Fence over bottom house( pond)/ side
        this.blocks.add(new AABB( 427, 312, 90,1)); // Fence under the POND (lake) // bottom
        this.blocks.add(new AABB( 518, 296,1,15)); //Fence under the POND (LAKE)  //side
        this.blocks.add(new AABB( 435, 235,63,53)); // POND (LAKE)
        this.blocks.add(new AABB( 350, 230,65,54)); //HOUSE near the lake (POND)
        this.blocks.add(new AABB( 345, 312,2,2)); // Mail box under the house near the LAKE
        this.blocks.add(new AABB( 360,220 ,45,7)); // ROOF OF THE HOUSE NEAR THE LAKE ( POND)
        this.blocks.add(new AABB( 372, 215,19,5)); // Extra roof of the house near the lake (pond)
        this.blocks.add(new AABB( 580, 220,64,57)); // HOUSE bottom right
        this.blocks.add(new AABB( 578, 210,90,1)); // Fence over the house Bottom right //perpendicular
        this.blocks.add(new AABB( 670, 195,1,15)); // Fence over the house bottom right //side
        this.blocks.add(new AABB( 0, 250,30,30)); // TREES left side
        this.blocks.add(new AABB( 19, 210,34,40)); // TREES left side
        this.blocks.add(new AABB( 0, 180,22,30)); // TREES left side
        this.blocks.add(new AABB( 0, 155,15,30)); // TREES left side
        this.blocks.add(new AABB( 0, 123,15,30)); // TRESS left side
        this.blocks.add(new AABB( 40, 119,25,30)); // TRESS left side
        this.blocks.add(new AABB( 47, 112,12,9)); // TRESS left side (top addition)
        this.blocks.add(new AABB( 0, 70,6,34)); // TREES BOTTOM LEFT
        this.blocks.add(new AABB( 80, 190,7,27)); // TREES BOTTOM LEFT
        this.blocks.add(new AABB( 0, 300,23,100)); // TREES BOTTOM LEFT
        this.blocks.add(new AABB( 20, 310,7,20)); // TREES BOTTOM LEFT
        this.blocks.add(new AABB( 20, 360,9,40)); // TREES BOTTOM LEFT
        this.blocks.add(new AABB( 20, 380,15,20)); // TREES BOTTOM LEFT
        this.blocks.add(new AABB( 75, 365,10,35)); // TREES BOTTOM LEFT
        this.blocks.add(new AABB( 60, 385,40,12)); //TREES BOTTOM LEFT
        this.blocks.add(new AABB( 65, 373,28,12)); // TREES BOTTOM LEFT
        this.blocks.add(new AABB( 125, 394,127,6)); //POND (RIVER )BOTTOM
        this.blocks.add(new AABB( 167, 325,5,28)); //TREES OVER THE POND (RIVER )BOTTOM
        this.blocks.add(new AABB( 205, 325,5,28)); //TREES OVER THE POND (RIVER )BOTTOM
        this.blocks.add(new AABB( 280, 385,8,15)); //TREES BOTTOM LINE AFTER THE POND (ON THE RIGHT) /PERPENDICULAR
        this.blocks.add(new AABB( 272, 393,23,7)); //TREES BOTTOM LINE AFTER THE POND (ON THE RIGHT) / SIDE
        this.blocks.add(new AABB( 315, 393,27,7)); //TREES BOTTOM LINE AFTER THE POND (ON THE RIGHT) / SIDE 2nd
        this.blocks.add(new AABB( 325, 379,8,18)); //TREES BOTTOM LINE AFTER THE POND (ON THE RIGHT) /PERPENDICULAR 2nd
        this.blocks.add(new AABB( 318, 385,20,8)); //TREES BOTTOM LINE AFTER THE POND (ON THE RIGHT) /PERPENDICULAR 2nd addition
        this.blocks.add(new AABB( 365, 394,11,6)); //TREE BOTTOM MID LINE (AFTER THEE POND AND THE TREES ( SMALL ONE)
        this.blocks.add(new AABB( 405, 365,11,30)); //BIG TREE AFTER THE SMALL TREE
        this.blocks.add(new AABB( 400, 376,24,24)); //BIG TREE / PERPENDICULAR
        this.blocks.add(new AABB( 395, 389,37,11)); //BIG TREE PERPENDICULAR
        this.blocks.add(new AABB( 505, 362,15,29)); //BIG TREE RIGHT SIDE
        this.blocks.add(new AABB( 498, 376,29,24)); //BIG TREE RIGHT SIDE PERPE
        this.blocks.add(new AABB( 494, 389,40,11)); //BIG TREE RIGHT SIDE PERPE
        this.blocks.add(new AABB( 455, 385,21,15)); //SMALLER TREE IN THE MIDDLE OF 2 BIG ONES RIGHT SIDE
        this.blocks.add(new AABB( 461, 380,12,5)); //SMALLER TREE IN THE MIDDLE OF 2 BIG ONES RIGHT SIDE
        this.blocks.add(new AABB( 545, 393,27,7)); //MEDIUM tree right side after the big ones
        this.blocks.add(new AABB( 555, 379,8,18)); //MEDIUM tree right side after the big ones
        this.blocks.add(new AABB( 550, 385,20,8)); //MEDIUM tree right side after the big ones
        this.blocks.add(new AABB( 590, 385,20,10)); //A BIT SMALLER TREE AFTER THE MID ONE
        this.blocks.add(new AABB( 585, 393,27,7)); //A BIT SMALLER TREE AFTER THE MID ONE
        this.blocks.add(new AABB( 630, 390,33,10)); //MEDIUM to big  tree right side after the big ones
        this.blocks.add(new AABB( 638, 370,14,25)); //MEDIUM to big  tree right side after the big ones
        this.blocks.add(new AABB( 633, 382,27,10)); //MEDIUM to big tree right side after the big ones
        this.blocks.add(new AABB( 680, 390,20,10)); //BIG TRESS BOTTOM LEFT CORNER
        this.blocks.add(new AABB( 676, 370,14,25)); //BIG TRESS BOTTOM LEFT CORNER
        this.blocks.add(new AABB( 673, 360,27,10)); //BIG TRESS BOTTOM LEFT CORNER
        this.blocks.add(new AABB( 668, 306,25,10)); //BIG TRESS BOTTOM LEFT CORNER over the corner one
        this.blocks.add(new AABB( 658, 316,28,30)); //BIG TRESS BOTTOM LEFT CORNER over the corner one
        this.blocks.add(new AABB( 658, 328,30,20)); //BIG TRESS BOTTOM LEFT CORNER over the corner one
        this.blocks.add(new AABB( 680, 290,20,21)); //BIG TREE SIDE BY SIDE RIGHT SIDE
        this.blocks.add(new AABB( 695, 215,5,80)); //BIG TREE SIDE BY SIDE RIGHT SIDE
        this.blocks.add(new AABB( 690, 225,5,35)); //BIG TREE SIDE BY SIDE RIGHT SIDE
        this.blocks.add(new AABB( 567, 308,2,2)); //SIGN UNDER THE HOUSE RIGHT SIDE
        this.blocks.add(new AABB( 567, 308,2,2)); //SIGN UNDER THE HOUSE RIGHT SIDE
        this.blocks.add(new AABB( 582, 350,1,1)); //LANTERN RIGHT SIDE
        this.blocks.add(new AABB( 300, 348,1,1)); //LANTERN MID SIDE LEFTf




        this.showColliders = false;
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


