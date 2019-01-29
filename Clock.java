import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Clock
{
    private int centerx;
    private int centery;
    private int r = 250;
    private int hour;
    private int min;
    private int x;
    private int y;
    private int xOffset = 7;
    private int yOffset = 10;


    public Clock(int newHour, int newMin, int newcenterx, int newcentery)
    {
        hour = newHour > 12 ? newHour - 12 : newHour;
        min = newMin;
        centerx = newcenterx;
        centery = newcentery;
        x = centerx - r;
        y = centery - r;
    }


    public void draw(Graphics2D g2)
    {
        Stroke orginal = g2.getStroke();
        Stroke moreDeep = new BasicStroke(3);
        g2.setStroke(moreDeep);
        Rectangle clockFrame = new Rectangle (x,y,r << 1, r << 1);
        g2.draw(clockFrame);
        Ellipse2D.Double body = new Ellipse2D.Double(x,y,r << 1, r << 1);
        Ellipse2D.Double centerPoint = new Ellipse2D.Double(centerx - 8, centery - 8,16,16);
        g2.draw(body);
        g2.fill(centerPoint);
        g2.setStroke(orginal);
        drawNumber(g2);
        drawTime(g2,hour, min);


    }




    private void drawNumber(Graphics2D g2)
    {
        Stroke orginal = g2.getStroke();
        int number = 1;    // start from 1
        for(int degree = 60; degree != -300; degree -= 6)
        {
            double rad = degree * Math.PI / 180;

            if(degree % 30 == 0)
            {
                String word = "" + number;
                Font bigger = new Font(Font.SERIF,Font.BOLD,26);
                g2.setFont(bigger);
                g2.drawString(word,(int)(centerx + (r - 35) * Math.cos(rad)) - xOffset, (int)(centery - (r - 35) * Math.sin(rad)) + yOffset);
                Stroke depper = new BasicStroke(4);
                g2.setStroke(depper);
                number++;
            }
            else
            {
                g2.setStroke(orginal);
            }

            Point2D.Double outer = new Point2D.Double(centerx + r * Math.cos(rad), centery - r * Math.sin(rad));

            Point2D.Double inner = new Point2D.Double(centerx + (r - 20) * Math.cos(rad), centery - (r - 20) * Math.sin(rad));

            Line2D.Double line = new Line2D.Double(inner, outer);
            g2.draw(line);
        }
    }



    public void drawTime(Graphics2D g2, int h, int m)
    {
        g2.setColor(Color.GRAY);
        int hr = r >> 1;
        int mr = (r >> 2) * 3;

        double hdegree = 90 - h * 30 - (m >> 1);
        double mdegree = 90 - m * 6;
        double hRad = hdegree * Math.PI / 180;
        double mRad = mdegree * Math.PI / 180;

        Point2D.Double hPoint = new Point2D.Double(centerx + hr * Math.cos(hRad),centery - hr * Math.sin(hRad));
        Point2D.Double mPoint = new Point2D.Double(centerx + mr * Math.cos(mRad), centery - mr * Math.sin(mRad));
        Point2D.Double centerPoint = new Point2D.Double(centerx, centery);

       Line2D.Double hLine = new Line2D.Double(centerPoint, hPoint);
       Line2D.Double mLine = new Line2D.Double(centerPoint, mPoint);

       g2.setStroke(new BasicStroke(5));
       g2.draw(hLine);
       g2.setStroke(new BasicStroke(3));
       g2.draw(mLine);
    }


}
