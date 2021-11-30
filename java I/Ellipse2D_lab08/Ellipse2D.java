
package ellipse2d;
import java.util.Scanner;

/**
 *
 * @author jardo16
 * @since 11/08/17
 */
public class Ellipse2D {
private double x;
private double y;
private double width;
private double height;

    /**
     * Creates an ellipse located at (0,0) whose width and height are both 0.
     */
    public Ellipse2D()
    {
        x = 0;
        y = 0;
        width = 0;
        height = 0;
        
    }
    
    /**
     * Creates ab ellipse from the specified coordinates
     * @param xLoc location on x axis
     * @param yLoc location on y-axis
     * @param w width of ellipse
     * @param h height of ellipse
     */
    public Ellipse2D(double xLoc, double yLoc, double w, double h)
    {
        x = xLoc;
        y = yLoc;
        width = w;
        height = h;
    }
    
    /**
     * Returns the height of the framing rectangle in double precision
     * @return the height of the framing rectangle in double precision
     */
    public double getHeight()
    {
        return height;
    }
    
    /**
     * returns the width of the framing rectangle in double precision
     * @return the width of the framing rectangle in double precision
     */
    public double getWidth()
    {
        return width;
    }
    
    /**
     * returns the X-coordinate of the upper-left corner of the framing rectangle
     * in double precision
     * @return the x-coordinate of the upper-left corner of the framing
     * rectangle in double precision
     */
    public double getX()
    {
        return x;
    }
    
    /**
     * returns the Y-coordinate of the upper-left corner of the framing rectangle
     * in double precision
     * @return the y-coordinate  of the upper-left corner of the framing rectangle
     * in double precision
    */
    public double getY()
    {
      return y;          
    }
    
    /**
     * sets the location and size of the framing rectangle of this Shape to the
     * specified values
     * @param xLoc the x coordinate of the upper-left corner of the framing box
     * @param yLoc the y coordinate of the upper-left corner of the framing box
     * @param w the width
     * @param h the height
     */
    public void setEllipse2D(double xLoc, double yLoc, double w, double h)
    {
        x = xLoc;
        y = yLoc;
        width = w;
        height = h;
    }
    
    /**
     * returns a string representation of this ellipse 
     * @return a string representation of this ellipse in the format: 
     * “Ellipse2D[x=...,y=..., w=..., h=.....]" where ... represent the values 
     * of the X-coordinate, Ycoordinate, width and height of the ellipse
     */
@Override
    public String toString()
    {
     return String.format("Ellipse2D[x=%.5f, y=%.5f, w=%.5f, h=%.5f]", x,y,width,height);
    }
    
    /**
     * returns the area of this ellipse
     * @return the area of this ellipse
     */
    public double area()
    {
        double area = (Math.PI * width * height) / 4;
        return area;
    }
    
    /**
     * returns the approximate perimeter of this ellipse
     * @return the approximate perimeter of this ellipse
     */
    public double perimeter()
    {
        double perimeter = (Math.PI / 2)*((3*(width+height))-(Math.sqrt(((3*width) + height)*(width+(3*height)))));
        return perimeter;
    }
    
    
    
}
