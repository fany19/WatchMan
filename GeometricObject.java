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

abstract public class GeometricObject {
     private Color boundaryColor;    //boundary color
    private Color interiorColor;    //interior color

    /**
     * Default constructor; sets object to default colors.
     */
    public GeometricObject()
    {
        interiorColor = Color.pink;
        boundaryColor = Color.black;
    }

    /**
     * Parameterized constructor; sets object to user colors.
     */
    public GeometricObject(Color iC, Color bC)
    {
        interiorColor = iC;
        boundaryColor = bC;
    }

    /**
     * Abstract drawing method, to be implemented in subclasses.
     * 
     * @param g device context where object is drawn in
     */
    abstract public void draw(Graphics g);

    /**
     * Access method.
     */
    public Color getBoundaryColor()
    {
        return boundaryColor;
    }
    
    /**
     * Access method.
     */
    public Color getInteriorColor()
    {
        return interiorColor;
    }

    /**
     * Mutate method.
     */
     public void setBoundaryColor(Color boundaryColor)
    {
        this.boundaryColor = boundaryColor;
    }
    
    /**
     * Mutate method.
     */
     public void setInteriorColor(Color interiorColor)
    {
        this.interiorColor = interiorColor;
    }

    @Override
    public String toString()
    {
        String str;
        str = "BOUNDARY (" +
              boundaryColor.getRed() + ", " +
              boundaryColor.getGreen() + ", " +
              boundaryColor.getBlue() + ", " +
              boundaryColor.getAlpha() + ") " +
              "INTERIOR (" +
              interiorColor.getRed() + ", " +
              interiorColor.getGreen() + ", " +
              interiorColor.getBlue() + ", " +
              interiorColor.getAlpha() + ")";
        return str;
    }
}

