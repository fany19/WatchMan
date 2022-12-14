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
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Graphics;

public class Line extends GeometricObject{
    
    private double a;
    private double b;
    private double c;
    
    public Line(){
        a=-1;
        b=1;
        c=0;
    }
    public Line(double a, double b, double c) throws IllegalArgumentException
    {
        if(a==0 && b==0) throw new IllegalArgumentException();
        else{
            this.a=a;
            this.b=b;
            this.c=c;
        }
    }
    public Line(Point p, Point q)throws IllegalArgumentException{
        
        if(p.getX()== q.getX() && p.getY()== q.getY())
            throw new IllegalArgumentException("Both points have same coordinates");
        else if(p.getX() != q.getX()){
             a = (q.getY()-p.getY())/(q.getX()-p.getX());
            b = -1;
            c= p.getY() - a * p.getX();
        }
        else {
            a = 1;
            b = 0;
            c = -p.getX();
        }
             
    }
    @Override
    public void draw(Graphics g){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double maxX = screenSize.width;
        double maxY = screenSize.height;
        
        double x1, y1, x2, y2;
        if(!isVertical()){
            x1=0.0;
            y1=getY(x1);
            x2=maxX;
            y2=getY(x2);
            
        }
        else{
            y1=0.0;
            x1=getX(y1);
            y2=maxY;
            x2=getX(y2);
        }
        g.setColor(getBoundaryColor());
        g.drawLine((int)x1,(int) y1, (int)x2, (int)y2);
    }
    
    public double getA(){
        return a;
    }
    
    public double getB(){
        return b;
    }
    
    public double getC(){
        return c;
    }
    
    public double getY(double x) throws IllegalStateException
    {
        if(b!=0)
            return (-a/b)*x+(-c/b);
        else
            throw new IllegalStateException("Vertical line cannot be used here");
    }
    
    public double getX(double y) throws IllegalStateException
    {
        if(b!=0)
            return (-b/a)*y+(-c/a);
        else
            throw new IllegalStateException("Horizontal line cannot be used here");
    }
    
    public boolean isVertical(){
        return b==0;
    }
    
    public void setA(double a) throws IllegalStateException
    {
        if(a==0 && this.b==0)throw new IllegalStateException();
        else
            this.a=a;
            
    }
    
    public void setB(double b) throws IllegalStateException
    {
        if(this.a==0 && b==0)throw new IllegalStateException();
        else
            this.b=b;
            
    }
    
    public void setC(double c){
        this.c=c;
    }
    
    public void setLine(double a, double b, double c) throws IllegalStateException
    {
        if(a==0 && b==0)throw new IllegalStateException();
        else{
             this.a=a;
             this.b=b;
             this.c=c;
        }     
    }
    
    public double distanceFromPoint(Point p){
        
        return Math.abs(a * p.getX() + b * p.getY() + c) / 
                Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }
    
    public int pointRelativePosition(Point p){
        int relativePosition = 0;
        
        if(!isVertical()){
            double yCoord = getY(p.getX());
            if(yCoord > p.getY()) relativePosition = -1;
            else if (yCoord == p.getY()) relativePosition = 0;
            else relativePosition = 1;
        }    
        else{
            double xCoord = -c/a;
            if(xCoord > p.getX()) relativePosition = -1;
            else if(xCoord == p.getX()) relativePosition = 0;
            else relativePosition = 1;
        }
        return relativePosition;
    }
  
    @Override
    public String toString(){
        String str = "LINE "+a+" "+b+" "+c+" "+super.toString();
        return str;
    }
}

