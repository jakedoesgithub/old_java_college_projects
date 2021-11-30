
package recursiveauxillarymath;

/**
 *
 * @author Jake Ardoin
 */
public class RecursiveAuxillaryMath 
{
    public static boolean recursiveIsPalindrome(String num, int i, int j)
    {
       if(i >= j)
		return true;
  	  if(num.charAt(i) != num.charAt(j))
          return false;
       return recursiveIsPalindrome(num, i+1, j-1);

    }

    public static long recursiveFibonacci(int n)
    {
        switch (n) 
        {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                long fib;
                fib = recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
                return fib;
        }
    }
    
    public static int recursiveGCD(int a, int b)
    {
        if(a == 0 || b == 0)
        {
            return Math.abs(a + b);
        }
        else
        {
            a = Math.abs(a);
            b = Math.abs(b);
            int r;
            r = a % b;
            a = b;
            b = r;
            if(b != 0)
            {
                return RecursiveAuxillaryMath.recursiveGCD(a, b);
            }
            return a;
        }
    }
    
    public static double recursivePowInt(double a, int n)
    {
        if(n==0)
        {
            return 1;
        }
        else if(n>0)
        {
           return a * recursivePowInt(a, n-1); 
        }
        else
        {
            return (1/a) * recursivePowInt(a, n+1);
        }           
    }
    
}
