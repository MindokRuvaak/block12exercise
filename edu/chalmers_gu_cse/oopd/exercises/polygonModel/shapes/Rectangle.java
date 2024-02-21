package edu.chalmers_gu_cse.oopd.exercises.polygonModel.shapes;

/**
 * Created by Niklas on 2016-02-14.
 */
class Rectangle extends Polygon {

    public Rectangle(int x, int y, int sizeX, int sizeY, double rotation){
        super(x,y);
        this.scale(sizeX,sizeY);
        this.rotate(rotation);
    }
    public Rectangle(int x, int y, int sizeX, int sizeY){
        super(x,y);
        this.scale(sizeX,sizeY);
    }
    public Rectangle(int x, int y, double rotation){
        this(x,y,1,1,rotation);
    }
    public Rectangle(int x, int y){
        this(x,y,1,1);
    }

    protected Point[] getOffsets() {
        int xOffset = getScaleX() / 2;
        int yOffset = getScaleY() / 2;
        return new Point[]{
                new Point(-xOffset, -yOffset),
                new Point( xOffset, -yOffset),
                new Point( xOffset,  yOffset),
                new Point(-xOffset,  yOffset)
        };
    }

}
