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
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GraphDisplay extends JPanel 
{
      
    //vertex parameters
    GeometricObject[] gArray;
    private BufferedImage image; //background image
    
    //Default constructor
  // public GraphDisplay(){
   //     setVertex( new Point());
   // }
    
    //parameterized constructor
    public GraphDisplay(GeometricObject[] g){
        setGeometricObjects(g);
        try
        {
            image = ImageIO.read(new File("room.png"));
        }
        catch (IOException ex)
        {
            System.out.println("Image file not found!");
        }  
            
    }
    
    //vertex mutator
    public void setGeometricObjects(GeometricObject[] g){
        this.gArray = g;
    }
    
    public void paint (Graphics g){
         super.paint(g); //clears window
        
          for(GeometricObject e:gArray)
        {
        e.draw(g);//invokes object's draw method through polymorphism
        }
        //draws background image
        Dimension d = getSize();
        g.drawImage(image, 0, 0, d.width, d.height, this);
        
        if(gArray[0] != null){
            gArray[0].draw(g);
        }
        //outputs description
        g.setColor(new Color(64, 64, 64, 128));
        g.fillRoundRect(0, 385, 180, 30, 5, 5);
        g.setColor(Color.WHITE);
        g.setFont(new Font("SansSerif", Font.BOLD, 12));
       
    }
}
