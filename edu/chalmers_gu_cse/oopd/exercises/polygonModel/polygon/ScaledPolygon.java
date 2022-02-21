package edu.chalmers_gu_cse.oopd.exercises.polygonModel.polygon;

import java.awt.*;
import java.util.List;

/**
 * Created by Niklas on 2016-02-28.
 */
class ScaledPolygon extends AbstractManipulatedPolygon implements IPolygon {
    double xFactor, yFactor;

    ScaledPolygon(AbstractPolygon base, double xFactor, double yFactor) {
        super(base);
        this.xFactor = xFactor;
        this.yFactor = yFactor;
    }

    protected void manipulatePoint(Point center, Point point) {
        double newX = (point.x-center.x)*xFactor + center.x;
        double newY = (point.y-center.y)*yFactor + center.y;
        point.x = (int) newX;
        point.y = (int) newY;
    }
}
