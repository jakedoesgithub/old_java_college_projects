
package vector2d;
import java.util.Scanner;

        

/**
 * The purpose of this  program is create a demo of the Vector2D methods by
 * obtaining the x and y values for 3 vectors from the user then using those
 * to perform multiple test calculations<br>
 * CSC 1350 Project #4 <br>
 * @author Jake Ardoin
 * @since 11/17/17
 */
public class Vector2dDemo {
     /**
      * Asks the user for the x and y components of 3 vectors then performs multiple
      * calculations with those vectors
      * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the components of the first vector -> ");
        Vector2D v1 = new Vector2D(in.nextDouble(), in.nextDouble());
        
        System.out.print("Enter the components of the second vector -> ");
        Vector2D v2 = new Vector2D(in.nextDouble(), in.nextDouble());
        
        System.out.print("Enter the components of the third vector -> ");
        Vector2D v3 = new Vector2D(in.nextDouble(), in.nextDouble());
        
        System.out.printf("%nv1 = %s%n", v1.toString());
        System.out.printf("v2 = %s%n", v2.toString());
        System.out.printf("v3 = %s%n", v1.toString());
        
        
        System.out.printf("%n(v1 + v2) - (v1 - v3) = %s",((v1.add(v2)).sub(v1.sub(v3))).toString());
        System.out.printf("%n||(v1 + v2) - (v1 - v3)|| = %f%n", v1.add(v2).sub(v1.sub(v3)).norm());
        
        System.out.printf("%nunit(v1) x sqrt(v1.v1) = %s", v1.unit().sMulti(Math.sqrt(v1.dot(v1))).toString());
        System.out.printf("%nThe x-component of (v2 - v3) / ||v2 - v3|| = %f", v2.sub(v3).getX() / v2.sub(v3).norm());
        System.out.printf("%nThe y-component of (v2-v3) / (||v2 - v3|| =  %f%n", v2.sub(v3).getY() / v2.sub(v3).norm());
        
        System.out.printf("%nv3 = <%.1f,%.1f>", v3.getY(), v3.getX());
        Vector2D v4 = new Vector2D(v3.getY(), v3.getX());
        System.out.printf("%nv4 = %s", v4.toString());
        System.out.printf("%nIs unit(4 x v4) equal to unit(v4)? %b%n", v4.sMulti(4).unit().equals(v4.unit()));
        
        System.out.printf("%nAre ||v2 - v3|| and ||v2 + v3|| equal?  %b", v2.sub(v3).norm() == (v2.add(v3).norm()));

    }
}
