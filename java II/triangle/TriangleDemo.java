    
package triangle;
import java.awt.geom.Point2D;

/**
 *
 * @author jardo16
 */
public class TriangleDemo {
    
        public static void main(String[] args) {
            
            Point2D.Double[] points1 = { new Point2D.Double(9,9),
                                         new Point2D.Double(11,14),
                                         new Point2D.Double(13,17) } ;

            Triangle triangle1 = new Triangle(points1);
            
            Point2D.Double[] points2 = { new Point2D.Double(5,6),
                                         new Point2D.Double(5,46),
                                         new Point2D.Double(14,6) } ;            
            
            Triangle triangle2 = new Triangle(points2);
            
            System.out.printf("The first triangle: %s \n", triangle1.toString());
            System.out.printf("perimeter: %.4f\n", triangle1.perimeter());
            System.out.printf("area: %.4f\n\n", triangle1.area());
            
            System.out.printf("The first triangle: %s \n", triangle2.toString());
            System.out.printf("perimeter: %.4f\n", triangle2.perimeter());
            System.out.printf("area: %.4f\n", triangle2.area());
            
            
        
    }
    
}
