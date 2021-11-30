
package triangle;

import java.awt.geom.Point2D;

/**
 *
 * @author jardo16
 */
public class Triangle extends Polygon       
{

    public Triangle(Point2D.Double[] points)
    {
        super(points);
    }

    public double area()
    {
        double s = perimeter() / 2;
        double a = Math.sqrt(  s * (s - (distance(vertices[0], vertices[1]))) * (s - (distance(vertices[1], vertices[2]))) * (s - (distance(vertices[2], vertices[0]))));
        return a;
    }
    
    @Override
    public String toString()
    {
       return "{(" + vertices[0].x + "," + vertices[0].y + "), (" + vertices[1].x + "," + vertices[1].y + "), (" + vertices[2].x + "," + vertices[2].y + ")}";
    }
    
}
