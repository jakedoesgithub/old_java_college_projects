
package triangle;
import java.awt.geom.Point2D;

/**
 *
 * @author jardo16
 */
abstract public class Polygon 
{
    
    Point2D.Double[] vertices;
    
    public Polygon()
    {
      vertices = null;
    }
    
    public Polygon(Point2D.Double[] points)
    {
        vertices= points;

 
    }
    

    public double distance(Point2D.Double p1, Point2D.Double p2)
    {
        double distance = Math.sqrt( Math.pow((p1.x - p2.x),2) + Math.pow((p1.y - p2.y),2));
        return distance;
       
    }
    
    abstract public double area();

    
    public double perimeter()
    {
        int numVert = vertices.length;
        double result = 0;
        for (int i = 0; i < numVert; i++)
        {
            result += distance(vertices[i], vertices[(i+1)% numVert]);
        }
        
        
        return result;
        
    }
    
    
}
