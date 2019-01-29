import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
public class DigtialClock
{
    private String time;
    private int centerx;
    private int centery;

    public DigtialClock(int newhour, int newmin,int newx, int newy)
    {
       time = newhour + " : " + newmin;
       centerx = newx;
       centery = newy;
    }


    public void draw(Graphics2D g2)
    {
        Rectangle frame = new Rectangle(centerx - 50,centery + 50, 100,50);
        g2.setColor(Color.blue);
        g2.draw(frame);
        g2.drawString(time ,centerx - 37, centery + 85);
    }
}
