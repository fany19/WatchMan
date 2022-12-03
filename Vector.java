/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;
/**
 *
 * @author Prof. Antonio Hernandez
 */
public class Vector {
    
    private double x;
    private double y;
    
    public Vector(){
        x = y = 0;
        
    }
    public Vector(double x, double y){
        
        this.x = x;
        this.y = y;
    }
    public Vector add(Vector v){
        return new Vector(this.x + v.x, this.y + v.y);
    }
    
    public double direction(){
        double angle = Math.toDegrees(Math.atan2(y, x));
        if(angle < 0) angle+= 360;
        
        return angle;
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public double magnitud(){
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
    
    public Vector neg(){
        return new Vector(-x, -y);
    }
    
    public void setX(double x){
        this.x = x;
    }
    
    public void setY(double y){
        this.y = y;
    }
    
    public Vector substract( Vector v){
        return new Vector(this.x - v.x, this.y - v.y);
    }
    
    public String toString(){
        return "Vector(" + x + " , " + y + ")";
    }
}


