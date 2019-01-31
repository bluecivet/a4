/**
 * File:        Clock.java
 * Author:      Zhilong Gan
 * ID:          100331942
 * Date:        2019.01.30
 * class:       CPSC 1181-03
 * instructor:  Hengameh Hamavand
 * title        clock class
 * Compiler:    java JDK 10.2
 */



/**
 * this class is the Clock class
 * it contain the element that need to draw in the picture for example
 * the position of the clock the hour and min of the clock
 * the radius of the clock
 * the class also provide a method for drawing itself
 */

import java.awt.*;
import java.awt.geom.*;

public class Clock
{
    private int centerx;  // the center of the position of the clock
    private int centery;
    private int r = 250;    // the radius which mean the size
    private int hour;
    private int min;
    private int x;         // the position actual use (the left top conner)
    private int y;
    private int xOffset = 7;      // to ajust the letter of the position that show in the clock
    private int yOffset = 10;

    /**
     * the constructor for the clock which initial some of the element
     * @param newHour  int type for the hour for  the clock
     * @param newMin   int type for the min for the clock
     * @param newcenterx    int type for the centerx position for the clock
     * @param newcentery    int type for the center y position for the clock
     */
    public Clock(int newHour, int newMin, int newcenterx, int newcentery)
    {
        hour = newHour > 12 ? newHour - 12 : newHour;   // if the hour is greater than 12 and then hour - 12
        min = newMin;
        centerx = newcenterx;
        centery = newcentery;
        //calculate the actual display position
        x = centerx - r;
        y = centery - r;
    }


    public void draw(Graphics2D g2)
    {
        Stroke orginal = g2.getStroke();   // save the original stroke
        Stroke moreDeep = new BasicStroke(3);         //create the new stroke to make it deeper
        g2.setStroke(moreDeep);

        Rectangle clockFrame = new Rectangle (x,y,r << 1, r << 1);   // outer frame
        g2.draw(clockFrame);
        Ellipse2D.Double body = new Ellipse2D.Double(x,y,r << 1, r << 1);     // inner frame

        Ellipse2D.Double centerPoint = new Ellipse2D.Double(centerx - 8, centery - 8,16,16);  // the center point
        g2.draw(body);
        g2.fill(centerPoint);
        g2.setStroke(orginal);  // after drawing the frame than reset the stroke
        drawNumber(g2);         // draw the letter in the frame
        drawTime(g2,hour, min);    // draw the line that show the time

    }


    /**
     * the method will draw the number and add some decoration for the clock
     * @param g2 Graphics2D type the show the pen for the drawing
     */
    private void drawNumber(Graphics2D g2)
    {
        Stroke orginal = g2.getStroke();
        int number = 1;    // start drawing from letter 1

        //the letter 1 that display in the clock is 60 degree
        // each min is 6 degree between
        // since teh whole circle is 360 degree so draw until -300 degree
        for(int degree = 60; degree != -300; degree -= 6)
        {
            double rad = degree * Math.PI / 180;  // calculate the the radian

            /**
             *  each 5 minus will have 30 degree between
             *  if the degree reach every 30 degree than change to deeper stroke draw the number out
             */

            if(degree % 30 == 0)
            {
                String word = "" + number;
                Font bigger = new Font(Font.SERIF,Font.BOLD,26);
                g2.setFont(bigger);
                g2.drawString(word,(int)(centerx + (r - 35) * Math.cos(rad)) - xOffset, (int)(centery - (r - 35) * Math.sin(rad)) + yOffset);
                Stroke depper = new BasicStroke(4);
                g2.setStroke(depper);
                number++;     // the next number
            }
            else
            {
                g2.setStroke(orginal);    // reset to the less deep stroke
            }

            //some decoration the little line
            Point2D.Double outer = new Point2D.Double(centerx + r * Math.cos(rad), centery - r * Math.sin(rad));

            Point2D.Double inner = new Point2D.Double(centerx + (r - 20) * Math.cos(rad), centery - (r - 20) * Math.sin(rad));

            Line2D.Double line = new Line2D.Double(inner, outer);
            g2.draw(line);
        }
    }

    /**
     * the method will draw the time out for the time that want to show
     * @param g2 the Graphics2d type showing the drawing pen
     * @param h the int type show the hour
     * @param m the int type show the minus
     */

    public void drawTime(Graphics2D g2, int h, int m)
    {
        g2.setColor(Color.GRAY);
        int hr = r >> 1;    // the radius for the hour line half of the original radius
        int mr = (r >> 2) * 3;   // the radius for the minus line 3 / 4 of the original radius

        double hdegree = 90 - h * 30 - (m >> 1);   // the degree for the hour line 90 is refer to letter 12
        double mdegree = 90 - m * 6;             // the degree for the minus line 6 degree is the different between each minus
        // convert degree to radian
        double hRad = hdegree * Math.PI / 180;
        double mRad = mdegree * Math.PI / 180;

        // create the point with the correct position
        Point2D.Double hPoint = new Point2D.Double(centerx + hr * Math.cos(hRad),centery - hr * Math.sin(hRad));
        Point2D.Double mPoint = new Point2D.Double(centerx + mr * Math.cos(mRad), centery - mr * Math.sin(mRad));
        Point2D.Double centerPoint = new Point2D.Double(centerx, centery);

        // connect the point
       Line2D.Double hLine = new Line2D.Double(centerPoint, hPoint);
       Line2D.Double mLine = new Line2D.Double(centerPoint, mPoint);

       //  draw the line out
       g2.setStroke(new BasicStroke(5));
       g2.draw(hLine);
       g2.setStroke(new BasicStroke(3));
       g2.draw(mLine);
    }


}
