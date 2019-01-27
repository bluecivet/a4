import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.time.LocalTime;
public class ClockComponent extends JComponent
{
    private int hour;
    private int min;

    // constructors

    public ClockComponent()
    {
        LocalTime t = LocalTime.now();
        hour = t.getHour();
        min = t.getMinute();
    }


    public ClockComponent(int newHour, int newMin)
    {
        hour = newHour;
        min = newMin;
    }


    //////////////////////////////////////////////////////////////////////////////
    //          methods

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

    }
}
