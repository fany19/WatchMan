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

import javax.swing.JFrame;
import java.util.Random;

public class Assignment3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Assignment3();
    }

    public Assignment3() {

        //frame size
        int frameWidth = 400;
        int frameHeight = 400;

        boolean intersection = false;
        //Defining the geometric objects that represent the problem data
        int pNumber = 13;
        int dNumber = 10;
        int dir = 0;

        SimplePolygon[] p = new SimplePolygon[pNumber];//geometric object array

        Vector[] directions = new Vector[dNumber];
     
        directions[0] = new Vector(0.0, 1.0);
        directions[1] = new Vector(-1.0, 0.0);
        directions[2] = new Vector(0.0, -1.0);
        directions[3] = new Vector(1.0, 0.0);
        directions[4] = new Vector(0.0, 1.0);
        directions[5] = new Vector(1.0, 0.0);
        directions[6] = new Vector(0.0, -1.0);
        directions[7] = new Vector(-1.0, 0.0);
        directions[8] = new Vector(1.0, 0.0);
        directions[9] = new Vector(0.0, 1.0);

        //creating a set of RectPolygon
        p[0] = new SimplePolygon();//watchman
        Point watchmanp1 = new Point(346, 90);
        Point watchmanp2 = new Point(351, 90);
        Point watchmanp3 = new Point(343, 74);
        Point watchmanp4 = new Point(343, 54);
        Point watchmanp5 = new Point(363, 54);
        Point watchmanp6 = new Point(363, 49);
        Point watchmanp7 = new Point(339, 49);
        Point watchmanp8 = new Point(339, 46);
        Point watchmanp9 = new Point(343, 46);
        Point watchmanp10 = new Point(343, 33);
        Point watchmanp11 = new Point(323, 33);
        Point watchmanp12 = new Point(323, 46);
        Point watchmanp13 = new Point(327, 46);
        Point watchmanp14 = new Point(327, 49);
        Point watchmanp15 = new Point(303, 49);
        Point watchmanp16 = new Point(303, 54);
        Point watchmanp17 = new Point(323, 54);
        Point watchmanp18 = new Point(323, 74);
        Point watchmanp19 = new Point(315, 90);
        Point watchmanp20 = new Point(320, 90);
        Point watchmanp21 = new Point(333, 76);
        p[0].addVertex(watchmanp1);
        p[0].addVertex(watchmanp2);
        p[0].addVertex(watchmanp3);
        p[0].addVertex(watchmanp4);
        p[0].addVertex(watchmanp5);
        p[0].addVertex(watchmanp6);
        p[0].addVertex(watchmanp7);
        p[0].addVertex(watchmanp8);
        p[0].addVertex(watchmanp9);
        p[0].addVertex(watchmanp10);
        p[0].addVertex(watchmanp11);
        p[0].addVertex(watchmanp12);
        p[0].addVertex(watchmanp13);
        p[0].addVertex(watchmanp14);
        p[0].addVertex(watchmanp15);
        p[0].addVertex(watchmanp16);
        p[0].addVertex(watchmanp17);
        p[0].addVertex(watchmanp18);
        p[0].addVertex(watchmanp19);
        p[0].addVertex(watchmanp20);
        p[0].addVertex(watchmanp21);

        p[1] = new SimplePolygon();//up wall
        Point w1p1 = new Point(395, 10);
        Point w1p2 = new Point(399, 3);
        Point w1p3 = new Point(1, 3);
        Point w1p4 = new Point(7, 10);
        p[1].addVertex(w1p1);
        p[1].addVertex(w1p2);
        p[1].addVertex(w1p3);
        p[1].addVertex(w1p4);

        p[2] = new SimplePolygon();//left wall
        Point w2p1 = new Point(7, 371);
        Point w2p2 = new Point(7, 9);
        Point w2p3 = new Point(1, 3);
        Point w2p4 = new Point(1, 377);
        p[2].addVertex(w2p1);
        p[2].addVertex(w2p2);
        p[2].addVertex(w2p3);
        p[2].addVertex(w2p4);

        p[3] = new SimplePolygon(); //bottom wall
        Point w3p1 = new Point(399, 377);
        Point w3p2 = new Point(395, 371);
        Point w3p3 = new Point(6, 371);
        Point w3p4 = new Point(0, 377);
        p[3].addVertex(w3p1);
        p[3].addVertex(w3p2);
        p[3].addVertex(w3p3);
        p[3].addVertex(w3p4);

        p[4] = new SimplePolygon();//right wall
        Point w4p1 = new Point(399, 377);
        Point w4p2 = new Point(399, 3);
        Point w4p3 = new Point(395, 10);
        Point w4p4 = new Point(395, 371);
        p[4].addVertex(w4p1);
        p[4].addVertex(w4p2);
        p[4].addVertex(w4p3);
        p[4].addVertex(w4p4);

        p[5] = new SimplePolygon();//obstacule 1
        Point obst1p1 = new Point(265, 142);
        Point obst1p2 = new Point(265, 75);
        Point obst1p3 = new Point(168, 75);
        Point obst1p4 = new Point(168, 142);
        p[5].addVertex(obst1p1);
        p[5].addVertex(obst1p2);
        p[5].addVertex(obst1p3);
        p[5].addVertex(obst1p4);

        p[6] = new SimplePolygon();//obstacule 2
        Point obst2p1 = new Point(139, 180);
        Point obst2p2 = new Point(139, 117);
        Point obst2p3 = new Point(93, 117);
        Point obst2p4 = new Point(93, 180);
        p[6].addVertex(obst2p1);
        p[6].addVertex(obst2p2);
        p[6].addVertex(obst2p3);
        p[6].addVertex(obst2p4);

        p[7] = new SimplePolygon();//obstacule 3
        Point obst3p1 = new Point(139, 268);
        Point obst3p2 = new Point(139, 204);
        Point obst3p3 = new Point(96, 204);
        Point obst3p4 = new Point(96, 268);
        p[7].addVertex(obst3p1);
        p[7].addVertex(obst3p2);
        p[7].addVertex(obst3p3);
        p[7].addVertex(obst3p4);

        p[8] = new SimplePolygon();//obstacule 4
        Point obst4p1 = new Point(265, 311);
        Point obst4p2 = new Point(265, 242);
        Point obst4p3 = new Point(166, 242);
        Point obst4p4 = new Point(166, 311);
        p[8].addVertex(obst4p1);
        p[8].addVertex(obst4p2);
        p[8].addVertex(obst4p3);
        p[8].addVertex(obst4p4);

        p[9] = new SimplePolygon();//obstacule 5
        Point obst5p1 = new Point(22, 309);
        Point obst5p2 = new Point(25, 302);
        Point obst5p3 = new Point(33, 303);
        Point obst5p4 = new Point(30, 294);
        Point obst5p5 = new Point(34, 284);
        Point obst5p6 = new Point(26, 283);
        Point obst5p7 = new Point(20, 277);
        Point obst5p8 = new Point(17, 287);
        Point obst5p9 = new Point(8, 283);
        Point obst5p10 = new Point(15, 296);
        Point obst5p11 = new Point(11, 304);
        Point obst5p12 = new Point(18, 302);
        p[9].addVertex(obst5p1);
        p[9].addVertex(obst5p2);
        p[9].addVertex(obst5p3);
        p[9].addVertex(obst5p4);
        p[9].addVertex(obst5p5);
        p[9].addVertex(obst5p6);
        p[9].addVertex(obst5p7);
        p[9].addVertex(obst5p8);
        p[9].addVertex(obst5p9);
        p[9].addVertex(obst5p10);
        p[9].addVertex(obst5p11);
        p[9].addVertex(obst5p12);

        p[10] = new SimplePolygon();//obstacule 6
        Point obst6p1 = new Point(21, 104);
        Point obst6p2 = new Point(25, 95);
        Point obst6p3 = new Point(34, 98);
        Point obst6p4 = new Point(30, 88);
        Point obst6p5 = new Point(35, 79);
        Point obst6p6 = new Point(27, 77);
        Point obst6p7 = new Point(19, 71);
        Point obst6p8 = new Point(17, 79);
        Point obst6p9 = new Point(9, 77);
        Point obst6p10 = new Point(15, 88);
        Point obst6p11 = new Point(10, 98);
        Point obst6p12 = new Point(17, 97);
        p[10].addVertex(obst6p1);
        p[10].addVertex(obst6p2);
        p[10].addVertex(obst6p3);
        p[10].addVertex(obst6p4);
        p[10].addVertex(obst6p5);
        p[10].addVertex(obst6p6);
        p[10].addVertex(obst6p7);
        p[10].addVertex(obst6p8);
        p[10].addVertex(obst6p9);
        p[10].addVertex(obst6p10);
        p[10].addVertex(obst6p11);
        p[10].addVertex(obst6p12);

        p[11] = new SimplePolygon();//obstacule 7
        Point obst10p1 = new Point(70, 333);
        Point obst10p2 = new Point(53, 301);
        Point obst10p3 = new Point(29, 326);
        Point obst10p4 = new Point(45, 354);
        p[11].addVertex(obst10p1);
        p[11].addVertex(obst10p2);
        p[11].addVertex(obst10p3);
        p[11].addVertex(obst10p4);

        p[12] = new SimplePolygon();//obstacule 8
        Point obst12p1 = new Point(124, 47);
        Point obst12p2 = new Point(124, 11);
        Point obst12p3 = new Point(39, 11);
        Point obst12p4 = new Point(39, 47);
        p[12].addVertex(obst12p1);
        p[12].addVertex(obst12p2);
        p[12].addVertex(obst12p3);
        p[12].addVertex(obst12p4);

        FrameDisplay frame = new FrameDisplay(frameWidth, frameHeight, p);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Random rnd = new Random();
        int random = 0;
      
        while (true) {
            delay(4);

            intersection = false;

            if (dir == dNumber) {
                dir = 0;
            }
            p[0].translate(directions[dir]);

            for (int i = 1; i < pNumber; i++) {
                if (Algorithms.isThereAnIntersection(p[0], p[i])) {
                    intersection = true;
                    break;
                }
            }

            if (intersection) {
                random = rnd.nextInt(101-1) + 1;
               // System.out.println("random: "+random);
                if(random > 90){
                    if (dir == dNumber) {
                    dir = 0;
                }
                p[0].translate(directions[dir].neg());
              
                dir = dir + 1;
                // System.out.println("dir: "+dir);
                }
                else{
                    for(int i = 0; i<3;i++){
                        p[0].translate(directions[dir].neg());
                    }
                   
                    dir = rnd.nextInt(dNumber);
                   // System.out.println("dir: "+dir);
                    p[0].translate(directions[dir].neg());
                    dir = dir + 1;
                }                
            }
            frame.repaint();
        }
    }

    public void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
        }
    }

}
