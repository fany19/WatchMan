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
import java.awt.*;

public class SimplePolygon extends GeometricObject{
    
    private Point[] vertexList;
    private int size;
    private int vertNumber = 0;
    
    /**
     * Instantiates an empty RectPolygon object. 
     */
    public SimplePolygon(){
        size = 100;
        vertexList = new Point[size];
        vertNumber = 0;
    }
    /**
     * Adds a vertex as the last one in the sequence of vertices. Vertex array
     * will be expanded to double its size if vertex cannot be added because
     * array is full.
     *
     * @param v the new vertex
     */
    public void addVertex(Point v){
        vertexList[vertNumber] = new Point(v.getX(), v.getY());
        vertNumber++;
    }
    public Point[] getVertex(){
        Point[] vert = new Point[vertNumber];
        for(int i = 0; i< vertNumber; i++){
            vert[i] = vertexList[i];
        }
        return vert;
    }
    /**
     * Computes the area of this polygon using shoelace algorithm.
     *
     * @return area of this polygon
     */
    public double area(){
        if(vertNumber < 4)
            return Double.NaN;
        
        double sum1 = 0.0, sum2 = 0.0, area = 0.0;
        Point v1, v2;
        
        for(int i = 0; i < vertNumber; i++){
            v1 = vertexList[i];
            v2 = vertexList[(i + 1) % vertNumber];
            
            sum1 += v1.getX() * v2.getY();
            sum2 += v2.getX() * v1.getY();
        }
        area = 0.5 * Math.abs(sum1-sum2);
        
        return area;
    }
    
     /**
     * Determines the smallest rectangle bounding this polygon.
     *
     * @return bounding rectangle
     */
    public Rectangle boundingRectangle(){
        
        Point p1, p2;
        p1 = new Point(this.greatestX(), this.smallestY());
        p2 = new Point(this.smallestX(),this.greatestY());
        
        Rectangle r = new Rectangle(p1, p2);
     
        return r;
        
    }
   /**
     * Draws this polygon.
     *
     * @param g graphics context
     */
    @Override
      public void draw(Graphics g)
    {
        int[] xPoints = new int [vertNumber];
        int[] yPoints = new int [vertNumber];
        
        for(int i = 0; i< vertNumber; i++){
            xPoints[i] = (int)vertexList[i].getX();
            yPoints[i] = (int)vertexList[i].getY();
        }
      
        g.setColor(getInteriorColor());
        g.fillPolygon(xPoints, yPoints, vertNumber);
        g.setColor(getBoundaryColor());
        g.drawPolygon(xPoints, yPoints, vertNumber);
    }
      
      
    public LineSegment[] getEdges(){
          LineSegment[] ls = new LineSegment[vertNumber] ;
          
          for(int i =0; i< vertNumber; i++){
              ls[i] = new LineSegment(vertexList[i], vertexList[(i+1) % vertNumber]);
              
          }

          return ls;
      }
      
      
    
      /**
     * Returns the number of vertices in this polygon
     *
     * @return number of vertices in this polygon
     */
    public int getNumberOfVertices(){
        
        return vertNumber;
    }  
    
       
    public Point[] getVertices(){
        
        return vertexList;
        
    }
    
    /**
     * Determines the greatest x.
     *
     * @return the greatest x
     */ 
    public double greatestX(){
        
        double x;
        double max = vertexList[0].getX();
        
        for(int i = 1; i< vertNumber; i++){
             x = vertexList[i].getX();
            
            if(x>max){
                max = x;
            }
        }
        return max;
    }
    
    /**
     * Determines the greatest y.
     *
     * @return the greatest y
     */
    public double greatestY(){
        
          double y;
        double max = vertexList[0].getY();
        
        for(int i = 1; i< vertNumber; i++){
             y = vertexList[i].getY();
            
            if(y>max){
                max = y;
            }
        }
        return max;
    }
    
    /**
     * Determines the smallest x.
     *
     * @return the smallest x
     */
    public double smallestX(){
        
        double x;
        double min = vertexList[0].getX();
        
        for(int i = 1; i< vertNumber; i++){
             x = vertexList[i].getX();
            
            if(x<min){
                min = x;
            }
        }
        return min;
    }
    
    /**
     * Determines the smallest y.
     *
     * @return the smallest y
     */
    public double smallestY(){
        
        double y;
        double min = vertexList[0].getY();
        
        for(int i = 1; i< vertNumber; i++){
             y = vertexList[i].getY();
            
            if(y<min){
                min = y;
            }
        }
        return min;
    }
 
    /**
     * Determines if given point is contained in this polygon.
     *
     * @param p given point
     * @return true if p is on the boundary or the interior of this polygon.
     */
   
    public boolean isPointInSimplePolygon(Point p)
    {
        double x = p.getX();
        double y = p.getY();
        if ( (smallestX() <= x && x <= greatestX()) &&
                (smallestY() <= y && y <= greatestY()) )
            return true;
        else
            return false;
    }
    
    /**
     * Constructs a String description of this polygon.
     *
     * @return String containing vertices of this polygon.
     */
    @Override
    public String toString()
    {
        String str = "RECTILINEAR POLYGON " + super.toString() + "\n";
        str += "SIZE: " + size + "\n" +"NUMBER OF VERTEX: " + vertNumber;

        return str;
    }
    
    /**
     * Translates this polygon by given vector.
     *
     * @param v given vector
     */
    public void translate(Vector v)
    {
        for(int i = 0; i< vertNumber; i++){
            vertexList[i].translate(v); 
        }
    }
}

