package edu.chalmers_gu_cse.oopd.exercises.controller;

import edu.chalmers_gu_cse.oopd.exercises.polygonModel.PolygonModel;
import edu.chalmers_gu_cse.oopd.exercises.polygonModel.shapes.PolygonFactory;
import edu.chalmers_gu_cse.oopd.exercises.view2d.PolygonViewer;

import java.awt.*;
import java.awt.event.*;

/**
 * Created by Niklas on 2016-02-21.
 */
public class PolygonClicker {

    private final PolygonModel model;

    public PolygonClicker(PolygonModel model) {
        this.model = model;
    }

    public void initInteraction(PolygonViewer view) {
        view.addMouseListener(new PolygonCreator());
    }

    private class PolygonCreator implements MouseListener {
        public void mouseEntered(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mouseClicked(MouseEvent e) {
            Point pointClicked = e.getPoint();
            model.addPolygon(PolygonFactory.createRectangle(pointClicked.x, pointClicked.y));
        }

    }

}