
package ellipse2d;

import java.util.Scanner;

/**
 *
 * @author jardo16
 * @since 11/08/17
 */
public class Ellipse2DDemo {
    /**
    * Displays the following details about the specified ellipse to
    * the nearest hundred thousandths.<br>
    * <pre>
    * {@code
    * Ellipse2D[x, y, width, height]
    * location: (x ,y)
    * width: ........ height: ..........
    * area: ......... perimeter: .......
    * }
    * </pre>
    * @param ellipse an object of the Ellipse2D class
    */
    public static void printEllipseDetails(Ellipse2D ellipse)
    {
     System.out.println("----------------------------------------------------------");
     System.out.println(ellipse.toString());
     System.out.printf("location: (%.5f, %.5f)%n", ellipse.getX(), ellipse.getY());
     System.out.printf("width: %10.5f    height: %10.5f%n", ellipse.getWidth(), ellipse.getHeight());
     System.out.printf("area: %11.5f    perimeter: %7.5f%n", ellipse.area(), ellipse.perimeter());
     System.out.println("----------------------------------------------------------");
    }
    
    
    
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Please enter the location, width and height of the "
            + "ellipse (width > height) ->");
    double x = in.nextDouble();
    double y = in.nextDouble();
    double width = in.nextDouble();
    double height = in.nextDouble();
    Ellipse2D ellipse1 = new Ellipse2D(x, y, width, height);
    
    
    System.out.printf("%n Description of the First Ellipse:%n");
    printEllipseDetails(ellipse1);
        
    System.out.printf("%nDescription of the Second Ellipse:%n");
    Ellipse2D ellipse2 = new Ellipse2D(ellipse1.getX(), ellipse1.getY(), ellipse1.getWidth(), ellipse1.getHeight());
    printEllipseDetails(ellipse2);
    
    System.out.printf("%nDescription of the First Ellipse after it is Modified:%n");
    ellipse1.setEllipse2D(ellipse1.getX(), ellipse1.getY()-(ellipse1.getWidth()-ellipse1.getHeight())/2, ellipse1.getWidth(), ellipse1.getWidth());
    printEllipseDetails(ellipse1);
    
    System.out.printf("%nThe area between the first and second ellipses is : %.5f", ellipse1.area() - ellipse2.area());
    
    }
}
