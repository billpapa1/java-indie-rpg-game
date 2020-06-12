package com.game.ui;

import java.awt.*;
import java.awt.event.MouseEvent;

    public class SimpleButton extends UIElement {
        private int x, y;
        private int width, height;
        private boolean isHovering;
        private boolean isPressed;

        private String text;

        private com.game.ui.Button.ButtonAction action;

        public SimpleButton() {
            this(0, 0, 100, 100);
        }

        public SimpleButton(int x, int y, int width, int height) {
            this(x, y, width, height, null);
        }

        public SimpleButton(int x, int y, int width, int height, String text) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;

            this.text = text;
            this.isHovering = false;
            this.isPressed = false;

            this.action = null;
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            this.isHovering = (e.getX() >= x && e.getX() < (x + width)) && (e.getY() >= y && e.getY() < (y + height));
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if ((e.getX() >= x && e.getX() < (x + width)) && (e.getY() >= y && e.getY() < (y + height))) {
                this.isPressed = true;
                e.consume();
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (isHovering && isPressed) {
                if (action != null) {
                    action.pressed();
                }
            }

            this.isPressed = false;
        }

        public void draw(Graphics2D g) {
            int paddingX = 5;
            int paddingY = 5;

            g.setColor(Color.WHITE);
            g.drawRect(x, y, width, height);

            if (isHovering) {
                if (isPressed) {
                    g.fillRect(x + paddingX, y + paddingY, width - 2 * paddingX + 1, height - 2 * paddingY + 1);
                    g.setColor(Color.BLACK);
                } else {
                    g.drawRect(x + paddingX, y + paddingY, width - 2 * paddingX, height - 2 * paddingY);
                }
            }

            if (text != null) {
                FontMetrics metrics = g.getFontMetrics();

                int strStartX = x + (width - metrics.stringWidth(text)) / 2;
                int strStartY = y + (height - metrics.getHeight()) / 2 + metrics.getAscent();

                g.drawString(text, strStartX, strStartY);
            }
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public void setText(String text) {
            this.text = text;
        }

        public void setAction(Button.ButtonAction action) {
            this.action = action;
        }
    }


