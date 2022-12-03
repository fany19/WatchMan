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

public class FrameDisplay extends JFrame
{   
    private GraphDisplay panel;

    /**
     * Creates an initializes the window frame.
     * 
     * @param width frame width
     * @param height frame height
     * @param g geometric objects to be depicted in this frame
     */
    public FrameDisplay(int width, int height, GeometricObject[] g)
    {
        setTitle("Room");
        setSize(width, height);
        setResizable(false);

        panel = new GraphDisplay(g);
        add(panel);
    }
}