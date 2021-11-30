
package squarerootfinder;
import java.util.Scanner;

/** This program uses a loop to approximate the square root of a number.
 *  by using the squeeze theorem.
 * @author Jake
 * @since 10/12/17
 * Course: CSC1350 <br>
 * Section: 002 <br>
 * PAWS ID: jardo16 <br>
 * Project #: 2 <br>
 * Instructor: Dr. Duncan <br>
 */
public class SquareRootFinder {

  
    public static void main(String[] args) {
     Scanner in = new Scanner(System.in);
     
     // ask for user input
     System.out.print("Enter a number to find its square root -> ");
     double number = in.nextDouble();
     final double EPSILON = 0.00001;
     
     // start boolean to find if n > 1, n < 1 n > 0, n < 0
     if (number > 1)
     {
         double low = 1.000000;
         double high = number;
         double midPoint = ((high - low) / 2) + low;
         double midPointSquared = midPoint * midPoint;
         double approxCheck = Math.abs(midPointSquared - number);
         System.out.printf("[%.6f, %.6f]%n", low, high);
         
         // begin caluclation of square root loop
         while (approxCheck > EPSILON)
         {
             if (midPointSquared > number)
             {
                 high = midPoint;
                 midPoint = ((high-low)/2) + low;
                 midPointSquared = midPoint * midPoint;
                 approxCheck = Math.abs(midPointSquared - number);
             }
             else
             {
                 low = midPoint;
                 midPoint = ((high-low)/2) + low;
                 midPointSquared = midPoint * midPoint;
                 approxCheck = Math.abs(midPointSquared - number);
             }
             System.out.printf("[%.6f, %.6f]%n", low, high);
         }
         System.out.printf("%nThe square root of %.6f is %.6f", number, midPoint);
         
     }
     else if (number < 1 && number > 0)
     {
         double low = 0.000000;
         double high = 1.000000;
         double midPoint = ((high - low) / 2) + low;
         double midPointSquared = midPoint * midPoint;
         double approxCheck = Math.abs(midPointSquared - number);
         System.out.printf("[%.6f, %.6f]%n", low, high);
         
         // begin caluclation of square root loop
         while (approxCheck > EPSILON)
         {
             if (midPointSquared > number)
             {
                 high = midPoint;
                 midPoint = ((high-low)/2) + low;
                 midPointSquared = midPoint * midPoint;
                 approxCheck = Math.abs(midPointSquared - number);
                 
             }
             else
             {
                 low = midPoint;
                 midPoint = ((high-low)/2) + low;
                 midPointSquared = midPoint * midPoint;
                 approxCheck = Math.abs(midPointSquared - number);
             }
             System.out.printf("[%.6f, %.6f]%n", low, high);
         }
         System.out.printf("%nThe square root of %.6f is %.6f", number, midPoint);
         
         
     }
     else
     {
       System.out.printf("The square root of %.6f is NaN", number);  
     }
     
     
     
    }
    
}
