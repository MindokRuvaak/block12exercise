package edu.chalmers_gu_cse.oopd.exercises.polygonModel.shapes;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niklas on 2016-02-17.
 */
public abstract class Polygon extends Shape {

    protected Polygon(int x, int y){ super(x,y); }

    public void paint(Graphics g){
        List<Point> corners = getCorners();
        // first and last point should be the same
        corners.add(corners.get(0));
        Point from = null;
        for (Point to : corners){
            if (from != null){
                g.drawLine(from.getX(), from.getY(), to.getX(), to.getY());
            }
            from = to;
        }

    }

    protected abstract Point[] getOffsets();

    private List<Point> getCorners() {
        // Find the data for this particular polygon
        Point center = getCenterPoint();
        Point[] offsets = getOffsets();
        double alpha = Math.toRadians(getRotation());
        // Calculate points based on that data
        return calculateCornerPoints(center, offsets, alpha);
    }

    /* Everything below this point is completely independent of any
    *  particular polygon. You can tell by the fact that the code does not
    *  mention any members (fields or methods) from the object itself. */

    private static List<Point> calculateCornerPoints(Point center, Point[] offsets, double alpha) {
        List<Point> corners = new ArrayList<>(offsets.length) ;
        for (Point pointOffsets : offsets) {
            Point newCorner = calculateCornerPoint(center, pointOffsets, alpha);
            corners.add(newCorner);
        }
        return corners;
    }
    private static Point calculateCornerPoint(Point center, Point offset, double alpha) {
        return rotatePoint(center, alpha,
                    movePoint(center, offset));
    }
    private static Point movePoint(Point center, Point offset) {
        return new Point(center.getX()+ offset.getX(), center.getY()+ offset.getY());
    }
    private static Point rotatePoint(Point center, double alpha, Point newCorner) {
        double newX = center.getX() + (newCorner.getX() - center.getX()) * Math.cos(alpha) - (newCorner.getY() - center.getY()) * Math.sin(alpha);
        double newY = center.getY() + (newCorner.getX() - center.getX()) * Math.sin(alpha) + (newCorner.getY() - center.getY()) * Math.cos(alpha);
        return new Point((int) newX, (int) newY);
    }

}
