/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

/**
 *
 * @author estephanysanchez PID:6244863
 * @author Prof. Antonio Hernandez
 */
import java.awt.Graphics;
import java.util.ArrayList;

public class LineSegment extends GeometricObject {
    
    private Point begin;
    private Point end;
    
    public LineSegment(){
        begin = new Point(0,0);
        end = new Point(1,1);
    }
    public LineSegment(Point b, Point e){
        begin = b;
        end = e;
    }
    
    @Override
    public void draw(Graphics g){
        g.setColor(getBoundaryColor());
        g.drawLine((int)begin.getX(),(int)begin.getY(), 
                (int)end.getX(),(int) end.getY());
    }
    
    public Point getBegin(){
        return begin;
    }
    
    public void setBegin(Point b){
        begin = b;
    }
    
    public Point getEnd(){
        return end;
    }
    
    public void setEnd(Point e){
        end = e;
    }
    
    public double greatestX(){
        return begin.getX() > end.getX() ? begin.getX() : end.getX();
    }
    
    public double greatestY(){
        return begin.getY() > end.getY() ? begin.getY() : end.getY();
    }
    
    public double smallestX(){
        return begin.getX() < end.getX() ? begin.getX() : end.getX();
    }
    
    public double smallestY(){
        return begin.getY() < end.getY() ? begin.getY() : end.getY();
    }
    
    @Override
    public String toString(){
        String str = "LINE_SEGMENT "+super.toString()+"\n";
        str += begin + "\n" + end;
        
        return str;
    }
    
    public void translate(Vector v){
        begin.translate(v);
        end.translate(v);
    }
    
    public boolean isHorizontal(){
        return begin.getY() == end.getY();
    }
    
    public boolean isVertical(){
        return begin.getX() == end.getX();
    }
    
    public double lenght(){
        return Math.sqrt(Math.pow(begin.getX() - end.getX(),2)+ 
                Math.pow((begin.getY() - end.getY()), 2));
        
    }/**
     * Determines if two numbers have the same sign.
     */
    private boolean sameSign(double a, double b)
    {
        return (a>0 &&  b>0) || (a<0) && (b<0);
    }

    /**
     * Determines if this line segment intersects another given line segment. If so,
     * it returns intersection point. If line segments are collinear, possibility of
     * intersection if not analyzed and simply a value of 'COLLINEAR' is returned.
     *
     * @param ls given line segment to check intersection with
     * @param p intersection point, if intersection point exists and it's unique
     *          (if line segments are collinear and intersection is not empty,
     *           no point is returned); it must be instantiated in caller
     * @return -1: segments are not collinear and do not intersect, OR
     *          1: line segments are not collinear and intersect, OR
     *          0: line segments are collinear; intersection might be empty or not.
     * @throws IllegalArgumentException if any of the two line segments has length = zero
     */
    public int intersect(LineSegment ls, Point p) throws IllegalArgumentException
    {
        //x and y coordinates of this line segment end points
        double x1 = this.getBegin().getX();
        double y1 = this.getBegin().getY();
        double x2 = this.getEnd().getX();
        double y2 = this.getEnd().getY();

        //x and y coordinates of ls end points
        double x3 = ls.getBegin().getX();
        double y3 = ls.getBegin().getY();
        double x4 = ls.getEnd().getX();
        double y4 = ls.getEnd().getY();

        //line1 is the line that goes through the two points defining this line segment
        Line line1 = new Line(begin, end);

        double a1 = line1.getA();
        double b1 = line1.getB();
        double c1 = line1.getC();

        //line2 is the line that goes through the two points defining line segment ls
        Line line2 = new Line(ls.getBegin(), ls.getEnd());

        double a2 = line2.getA();
        double b2 = line2.getB();
        double c2 = line2.getC();

        //evaluate point (x3, y3) in equation of line passing through this line segment
        double r3 = a1*x3 + b1*y3 + c1;

        //evaluate point (x4, y4) in equation of line passing through this line segment
        double r4 = a1*x4 + b1*y4 + c1;

        //evaluate point (x1, y1) in equation of line passing through ls
        double r1 = a2*x1 + b2*y1 + c2;

        //evaluate point (x2, y2) in equation of line passing through ls
        double r2 = a2*x2 + b2*y2 + c2;

        if ((x1==x2 && y1==y2) /*end points of this line segment are the same*/ ||
            (x3==x4 && y3==y4) /*end points of   ls line segment are the same*/
           ) throw new IllegalArgumentException();
        else
            if (r1 == 0 && r2 == 0)
                return 0; //COLLINEAR, no need to check r3 and r4
            else
                if (sameSign(r3, r4))
                    return -1; //NO INTERSECTION
                else
                    if (sameSign(r1, r2))
                        return -1; //NO INTERSECTION
                    else
                    {
                        double denominator = a1*b2 - a2*b1;
                        double x = (b1*c2 - b2*c1) / denominator;
                        double y = (a2*c1 - a1*c2) / denominator;

                        p.setX(x);
                        p.setY(y);

                        return 1; //INTERSECTION;
                    }
    }
    
    public static ArrayList<Point> computeAllIntersections(GeometricObject[] g){
        LineSegment[] lsArray = (LineSegment[]) g;
        ArrayList<Point> pointList = new ArrayList<>();
        for(int i = 0; i<lsArray.length; i++){
            for(int j=i+1; j<lsArray.length;j++){
                Point p = new Point();
                int intersectionType = lsArray[i].intersect(lsArray[j],p);
                if(intersectionType == 1){
                    pointList.add(p);
                }
            }
        }
        return pointList;
    }
    
  
}
