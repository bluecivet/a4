import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
/**
 * File:        DigtialClock.java
 * Author:      Zhilong Gan
 * ID:          100331942
 * Date:        2019.01.30
 * class:       CPSC 1181-03
 * instructor:  Hengameh Hamavand
 * title        number clock class
 * Compiler:    java JDK 10.2
 */




/**
 *  the class is for the clock that only contain the number
 *  it contain the element that need to draw it out
 *  the time and the position
 */
public class DigtialClock
{
    private String time;
    //position
    private int centerx;
    private int centery;

    /**
     * the constructor for the class
     * set the element for the object
     * @param newhour the int type that show the hour
     * @param newmin the int type that show the minus
     * @param newx  the int type show the x position
     * @param newy  the int type show the y position
     */
    public DigtialClock(int newhour, int newmin,int newx, int newy)
    {
       time = newhour + " : " + newmin;  // hh : mm
       centerx = newx;
       centery = newy;
    }


    /**
     * the method that draw the number clock out
     * @param g2 the Graphics2D type show the drawing pen
     */

    public void draw(Graphics2D g2)
    {
        Rectangle frame = new Rectangle(centerx - 50,centery + 50, 100,50);
        g2.setColor(Color.blue);
        g2.draw(frame);   // draw frame
        g2.drawString(time ,centerx - 37, centery + 85);   // draw time
    }
}
