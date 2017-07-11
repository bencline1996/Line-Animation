package lab_9_8;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
 

public class Line extends JPanel {
 
	
		//Creates integers to later be coordinate points
        private static int firstX1 = -200;
        private static int y = 150;
        private static int firstX2 = 0;
        private static int secondX1 = 250;
        private static int secondX2 = 250;
        private static int middleX = 250;
        private static int middleY = 400;
 
        private void moveLine()
        
        {
                if (firstX1 != middleX) //Until X1 reaches the center, move X1 right
                {
                        firstX1 += 1;
                }
                
                if (firstX2 != middleX) //Until X2 reaches the center, move X2 right
                {
                        firstX2 += 1;
                }
                
                if (firstX1 == middleX) //When X1 reaches the center, increase second X1
                {
                	secondX1 += 1;
                }
                if (firstX2 == middleX) //When X2 reaches the center, increase second X2. X2 should increase before X1
                {
                        secondX2 += 1;
                }
                

        }
 

        public void paint(Graphics g) {
                super.paint(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.drawLine(firstX1, y, firstX2, y); //Creates first line
                g2d.drawLine(middleX, 0, middleX, middleY); //Creates vertical line
                g2d.setColor(Color.RED); //"Changes color" of the line segment
                g2d.drawLine(secondX1,  y,  secondX2,  y); //Creates second line segment
        }
 
        public static void main(String[] args) throws InterruptedException
        {
                JFrame frame = new JFrame("Line Animation"); //Creates frame and frame accessories
                Line lineAnimation = new Line();
                frame.add(lineAnimation);
                frame.setSize(middleX * 2, middleY);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                while (true)
                {
                        lineAnimation.moveLine();
                        lineAnimation.repaint();
                        Thread.sleep(10); //Controls speed
                }
        }
       
}