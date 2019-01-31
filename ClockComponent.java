/**
 * File:        ClockComponent.java
 * Author:      Zhilong Gan
 * ID:          100331942
 * Date:        2019.01.30
 * class:       CPSC 1181-03
 * instructor:  Hengameh Hamavand
 * title        clock component class
 * Compiler:    java JDK 10.2
 */


/**
 * the method will draw the thing need to on the frame
 * it include a Anaysis clock and a Digtial clock
 */

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.time.LocalTime;

public class ClockComponent extends JComponent
{
    private int hour;
    private int min;

    // constructors

    /**
     * this is a not argument constructor
     * the hour and min will set to the current time
     */

    public ClockComponent()
    {
        LocalTime t = LocalTime.now();  // t get the current time
        hour = t.getHour();
        min = t.getMinute();
    }

    /**
     *  this method will draw a clock that show the time that input in the argument
     * @param newHour the int type that show the hour
     * @param newMin the int type that show the minus
     */
    public ClockComponent(int newHour, int newMin)
    {
        hour = newHour;
        min = newMin;
    }


    //////////////////////////////////////////////////////////////////////////////
    //          methods

    /**
     * this method will show the the picture of the two clock
     * it overwrite the method in JComponent
     * @param g the Graphics show the drawing pen
     */
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        //create a clock with the hour and minus
        // set the position to the center of the picture
        Clock clock = new Clock(hour,min, getWidth() >> 1, getHeight() >> 1);
        clock.draw(g2);   // draw the clock
        //create the digitial clock and same as clock
        // but the position set the the lower middle of the picture
        DigtialClock dclock = new DigtialClock(hour,min, getWidth() >> 1, getHeight() >> 1);
        dclock.draw(g2);   // draw it out
    }
}
