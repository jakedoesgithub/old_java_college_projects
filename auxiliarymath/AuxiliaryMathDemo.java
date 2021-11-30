
package auxiliarymath;
import java.util.Scanner;


/**
 *
 * @author jardo16
 */
public class AuxiliaryMathDemo 
{
        public static void main(String[] args) 
        {
            System.out.println("Enter three integers whose GCD is to be found -> ");
            Scanner in = new Scanner(System.in);
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            
            System.out.println("Enter an integer n to find fibonacci(n)-> ");
            int nFib = in.nextInt();
            
            System.out.println("Enter a base != (double) and an exponent != 0 (integer) -> ");
            double base = in.nextDouble();
            int exponent = in.nextInt();
             
             
            System.out.println("Enter two positive integers i and j where i < j -> ");
            int palOne = in.nextInt();
            int palTwo = in.nextInt();
            System.out.println();
            int numPals = 0;
            
            for (int i = palOne; i < palTwo; i++)
            {
                if ( AuxiliaryMath.isPalindrome(i))
                {
                    numPals++;
                }
            }
            
            
            System.out.printf("gdc(%d, %d, %d) = %d%n", a, b, c, AuxiliaryMath.gCD(AuxiliaryMath.gCD(a,b), c));
            System.out.printf("fibonacci(%d) = %d%n", nFib, AuxiliaryMath.fibonacci(nFib));
            System.out.printf("%f ^ %d = %f%n", base, exponent, AuxiliaryMath.powInt(base, exponent));
            System.out.printf("There are %d palindromic numbers between %d and %d", numPals , palOne, palTwo);
            
        }
    
}

