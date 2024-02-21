package edu.chalmers_gu_cse.oopd.exercises.polygonModel.shapes;

/**
 * Created by Niklas on 2016-02-14.
 */
class Triangle extends Polygon {
    public Triangle(int x, int y, int sizeX, int sizeY, double rotation){
        super(x,y);
        this.scale(sizeX,sizeY);
        this.rotate(rotation);
    }
    public Triangle(int x, int y, int sizeX, int sizeY){
        super(x,y);
        this.scale(sizeX,sizeY);
    }
    public Triangle(int x, int y, double rotation){
        super(x,y);
        this.rotate(rotation);
    }
    public Triangle(int x, int y){
        super(x,y);
    }

    protected Point[] getOffsets() {
        int xOffset = getScaleX() / 2;
        int yOffset = getScaleY() / 3;
        return new Point[]{
                new Point(0,   -yOffset*2),
                new Point(-xOffset,  yOffset  ),
                new Point( xOffset,  yOffset  )
        };
    }
}
