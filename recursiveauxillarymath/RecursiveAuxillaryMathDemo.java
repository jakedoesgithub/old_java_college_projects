
package recursiveauxillarymath;
import java.util.Scanner;

/**
 *
 * @author Jake Ardoin
 */
public class RecursiveAuxillaryMathDemo 
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter three integers whose GCD is to be found -> ");
        int aGCD = scan.nextInt();
        int bGCD = scan.nextInt();
        int cGCD = scan.nextInt();
        
        
        System.out.print("Enter an integer n to find fibonacci (n) -> ");
        int nFib = scan.nextInt();
        
        
        System.out.print("Enter the base and exponenet, an integer, of a power -> ");
        double base = scan.nextDouble();
        int pow = scan.nextInt();
        

        System.out.print("Enter two positive integers i and j where i < j -> ");
        int small = scan.nextInt();
        int big = scan.nextInt();
        int numPal = 0;
        while( small >= big)
        {
            System.out.print("Please re-enter the integers making sure i is smaller than j ->");
            small = scan.nextInt();
            big = scan.nextInt();
        }
        System.out.println("");
        String num = "";
        for(int i = small; i < big; i++)
        {
            num = "" + i;
            if (RecursiveAuxillaryMath.recursiveIsPalindrome(num, 0, num.length()-1))
            {
                numPal++;
            }
        }
        

        System.out.printf("gdc(%d,%d,%d) = %d\n", aGCD, bGCD, cGCD, RecursiveAuxillaryMath.recursiveGCD(RecursiveAuxillaryMath.recursiveGCD(aGCD, bGCD), cGCD));
        System.out.printf("fibonacci(%d) = %d\n", nFib, RecursiveAuxillaryMath.recursiveFibonacci(nFib));
        System.out.printf("%.6f ^ %d = %.6f\n", base, pow, RecursiveAuxillaryMath.recursivePowInt(base, pow));
        System.out.printf("There are %d palindromic numbers between %d and %d", numPal, small, big);
    }
}
