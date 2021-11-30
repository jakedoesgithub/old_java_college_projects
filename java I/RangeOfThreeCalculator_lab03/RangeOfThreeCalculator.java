/**
 * The purpose of this class is to write a program, RangeOfThreeCalculator,
 * that uses decision statements to compute the range of three integers, counts
 * the number of comparisons used to determine it, displays the number in
 * non-increasing order, and then prints a string detailing all the comparisons
 * made along with their logical values. <br>
 * CSC 1350 Lab # 3
 * @author Jake Ardoin
 * @since 9/20/2017
 */
package rangeofthreecalculator;

import java.util.Scanner;

public class RangeOfThreeCalculator 
{

    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter three integers to compute their range -> ");
        int first = in.nextInt(), second = in.nextInt(), third = in.nextInt();
        
        int numComparisons = 1;
        if (first > second) 
        {
            numComparisons ++;
            if (second > third)  // 1 > 2 > 3
            {
                System.out.printf("Range(%d, %d, %d,) = %d", first, second, third, first - third);
                System.out.println();
                System.out.printf("Comparisons: %d > %d? (T), %d > %d (T); ", first, second, second, third);
                System.out.printf("#Comparisons = %d", numComparisons);
            }
            else 
            {
                numComparisons ++;
                if (first > third)  // 1 > 2 > 3
                {    
                System.out.printf("Range(%d, %d, %d,) = %d", first, third, second, first - second);
                System.out.println();
                System.out.printf("Comparisons: %d > %d? (T), %d > %d (F), %d > %d (T); ", first, second, second, third, first, third);
                System.out.printf("#Comparisons = %d", numComparisons);
                }
                else
                {    
                System.out.printf("Range(%d, %d, %d,) = %d", third, first, second, first - second);
                System.out.println();
                System.out.printf("Comparisons: %d > %d? (T), %d > %d (F), %d > %d (F); ", first, second, second, third, first, third);
                System.out.printf("#Comparisons = %d", numComparisons);
                }
            }    
        }
        else
        {    
            numComparisons ++;
            if (second > third)
            {
                numComparisons ++;
                if (first > third)
                {
                System.out.printf("Range(%d, %d, %d,) = %d", second, first, third, second - third);
                System.out.println();
                System.out.printf("Comparisons: %d > %d? (F), %d > %d (T), %d > %d (T); ", first, second, second, third, first, third);
                System.out.printf("#Comparisons = %d", numComparisons);
                }
                else
                {
                System.out.printf("Range(%d, %d, %d,) = %d", second, third, first, second - first);
                System.out.println();
                System.out.printf("Comparisons: %d > %d? (F), %d > %d (T), %d > %d (F); ", first, second, second, third, first, third);
                System.out.printf("#Comparisons = %d", numComparisons);
                }
            }
            else
            {
                System.out.printf("Range(%d, %d, %d,) = %d", third, second, first, third - first);
                System.out.println();
                System.out.printf("Comparisons: %d > %d? (F), %d > %d (F); ", first, second, second, third);
                System.out.printf("#Comparisons = %d", numComparisons);
            }

        }
    }
}
