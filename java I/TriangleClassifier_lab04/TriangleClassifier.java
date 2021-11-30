
package triangleclassifier;
import java.util.Scanner;

/** The purpose of this program is to classify a triangle based on the measure of its angles
 * using the three side lengths as input. It will take any 3 integers and determine if they
 * can represent the sides of a triangle, and if they can, classify the triangle as acute,
 * right, or obtuse.
 *CSC 1350 Lab #4
 * @author Jake Ardoin
 * @since 10/04/2017
 */
public class TriangleClassifier 
{ 

    public static void main(String[] args) 
    {  // gathers the inputs, initialize variables
       Scanner in = new Scanner(System.in);
       int side1 = 0;
       int side2 = 0;
       int side3 = 0;
       int max = 0;
       int sumOfSquares = 0;
       String clasString ="";
       String triangleType ="";
       int obtuseCounter = 0;
       int triangleCounter = 0;
       
       
       
       for(int i=0; i<10; i++)
       {
       System.out.print("Enter three integers -> ");
       side1 = in.nextInt();
       side2 = in.nextInt();
       side3 = in.nextInt();
       
       if (side1 + side2 >= side3 && side1 + side3 >= side2 && side2 + side3 >= side1)
      {
           triangleCounter ++;
           if (side1 > side2 && side1 > side3)
           {
               max = side1;
               sumOfSquares = (side2*side2)+(side3*side3);
               clasString = side2 + "^2 " + "+ " + side3 + "^2";
               
           }
           else if (side2 > side1 && side2 > side3)
           {
               max = side2;
               sumOfSquares = (side1*side1)+(side3*side3);
               clasString = side1 + "^2 " + "+ " + side3 + "^2";
           }
           else
           {
               max = side3;
               sumOfSquares = (side2*side2)+(side1*side1);
               clasString = side2 + "^2 " + "+ " + side1 + "^2";
           }
          if ((max*max) < sumOfSquares)
          {
            triangleType = "acute";
            clasString = triangleType + ": " + max + "^2 " + "< " + clasString;
          }
          else if ((max*max) > sumOfSquares)
          {
            obtuseCounter ++;
            triangleType = "obtuse";
            clasString = triangleType + ": " + max + "^2 " + "> " + clasString;
          }
          else
          {
           triangleType = "right";
           clasString = triangleType + ": " + max + "^2 " + "= " + clasString;
          }  
       }
       else
       {
        System.out.printf("%d, %s and %d do not satisfy the triangle inequality.", side1, side2, side3);
       }
       
       
        System.out.printf("A trigangle with sides %d, %d and %d is %s%n%n", side1, side2, side3, clasString);
     } // end for loop
       
       
        System.out.printf("%d of the %d triangles is/are obtuse", obtuseCounter, triangleCounter);
    }
    
}
