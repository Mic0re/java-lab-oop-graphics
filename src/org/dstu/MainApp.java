package org.dstu;

import org.dstu.components.GraphicsPanel;
import org.dstu.shapes.Circle;
import org.dstu.shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        for (int i = 0; i < 500; i += 100) {
            shapes.add(new Circle(i, 0, 100, Color.CYAN));
        }

        GraphicsPanel canvas = new GraphicsPanel(shapes);

        for (Shape s: shapes) {
            Thread t = new Thread(s.getAnimator(canvas));
            t.start();
        }

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.add(canvas);
        frame.setVisible(true);
    }
}
