
package auxiliarymath;

/**
 *
 * @author jardo16
 */
public class AuxiliaryMath {

    public static boolean isPalindrome(int n)
    {
        String num = "" + n;
        int numDigits = num.length();
        
        for (int i = 0; i < num.length() / 2; i++)
        {
            if ( num.charAt(i) != num.charAt(num.length()-1-i) )
            {
                return false;
            }
        }
        return true;
        
    }
    
    public static int fibonacci(int n)
    {
        
        if (n == 0)
        {
            return 0;
        }
        
        if (n == 1)
        {
            return 1;
        }
        int result = 0; 
        int numOne = 1;
        int numTwo = 0;
        for (int i = 2; i <= n; i++)
        {
            result = numOne + numTwo;
            numTwo = numOne;
            numOne = result;
        }
        return result;
    }
    
    public static int gCD(int a, int b)
    {
        int gcd = 0;
        if (a == 0 || b == 0)
        {
            gcd = Math.abs(a+b); 
        }
        else
        {
            a = Math.abs(a);
            b = Math.abs(b);
            do
            {
                int remainder = 0;
                remainder = a % b;
                a = b;
                b = remainder;
            }
            while ( b!= 0);
            gcd = a;         
        }
        return gcd;
    }
    
    public static double powInt(double b, int n)
    {
      double result = b;
      if ( n > 0)
      {
          
          for ( int i = 1; i < n; i++)
          {
              result = result * b;
          }

      }
      
      if (n < 0)
      {
          n = Math.abs(n);
          for ( int i = 1; i < n; i++)
          {
              result = result * b;
          }
          result = 1 / result;
          
      }
      return result;
      
      
    }
    
    
    
}
