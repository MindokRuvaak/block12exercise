package edu.chalmers_gu_cse.oopd.exercises.polygonModel.shapes;

import java.awt.Graphics;

import javax.swing.*;

/**
 * Created by Niklas on 2016-02-14.
 */
public abstract class Shape extends JComponent {
    private final Point centerPoint;
    private int scaleX = 10;
    private int scaleY = 10;
    private double rotation = 0; // Degrees clockwise

    public Point getCenterPoint() {
        return new Point(centerPoint);
    }

    public int getScaleX() {
        return scaleX;
    }

    public int getScaleY() {
        return scaleY;
    }

    public double getRotation() {
        return rotation;
    }

    private Shape(Point center) {
        this.centerPoint = center;
    }

   public Shape(int x, int y) {
        this(new Point(x, y));
   }
    public void translate(int x, int y) {
        centerPoint.translate(x, y);
    }

    public void scale(int x, int y) {
        this.scaleX = scaleX * x;
        this.scaleY = scaleY * y;
    }

    public void rotate(double angle) {
        this.rotation = rotation + angle;
    }

    public abstract void paint(Graphics g);

    public static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Point(Point p) {
            this(p.getX(), p.getY());
        }

        public void translate(int x, int y) {
            this.x += x;
            this.y += y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

}