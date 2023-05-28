package org.dstu.shapes.animation;

import org.dstu.shapes.Circle;
import org.dstu.shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class CircleAnimator extends Animator {

    public CircleAnimator(Shape shape, JComponent component) {
        super(shape, component);
    }

    private void assignRandomColor() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        shape.setColor(new Color(r, g, b));
    }
    @Override
    public void run() {
        int radius = ((Circle) shape).getRadius();
        int step = 10;
        while (true) {
            int screenWidth = component.getWidth();
            int screenHeight = component.getHeight();

            if (shape.getY() == 0 && shape.getX() < (screenWidth - radius)) {
                shape.moveRel(step, 0);
            }

            if (shape.getX() == (screenWidth - radius) && shape.getY() < (screenHeight - radius)) {
                shape.moveRel(0, step);
            }

            if (shape.getY() == (screenHeight - radius) && shape.getX() > 0) {
                shape.moveRel(-step, 0);
            }

            if (shape.getX() == 0 && shape.getY() > 0) {
                shape.moveRel(0, -step);
            }

            if (
                    shape.getY() == 0 && shape.getX() == (screenWidth - radius - step)
                            || shape.getX() == (screenWidth - radius) && shape.getY() == (screenWidth - radius - step)
                            || shape.getY() == (screenHeight - radius - step) && shape.getX() == 0
                            || shape.getY() == 0 && shape.getX() == 0
            ) {
                assignRandomColor();
            }


            if (component != null) {
                component.repaint();
            }
            try {
                Thread.sleep(90);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
