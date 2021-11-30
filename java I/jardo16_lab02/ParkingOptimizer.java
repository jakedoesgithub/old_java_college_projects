
package parkingoptimizer;
import java.util.Scanner;
/**
 * This program is written to learn the use of Scanner class objects by creating
 * a program that determines the maximum number of minutes that a vehicle may
 * park in a lot given the number of parking minutes per various coin
 * denominations. <br>
 * CSC 1350 Lab # 2 <br>
 * @author Jake Ardoin
 * @since 9/13/2017
 * @version 1
 */
public class ParkingOptimizer 
{
    public static void main(String[] args)
    {
       Scanner scanone = new Scanner(System.in);
       
       System.out.print("Enter the number of parking minutes per quarter -> ");
       int minsPerQuarter = scanone.nextInt ();
       
       System.out.print("Enter the number of parking minutes per dime -> ");
       int minsPerDime = scanone.nextInt ();
       
       System.out.print("Enter the number of parking minutes per nickel -> ");
       int minsPerNickel = scanone.nextInt ();
       
       System.out.println ();
       
       // Above sets the time available for parking from each denomination of coin
       
       
       System.out.print("Enter the number of pennies available -> ");
       int numPenny = scanone.nextInt ();
            
       int numQuarter = numPenny / 25;
       int quarterRemainder = numPenny % 25;
       
       int numDime = quarterRemainder / 10;
       int dimeRemainder = quarterRemainder % 10;
       
       int numNickel = dimeRemainder / 5;
       int nickelRemainder = dimeRemainder % 5;
      
       System.out.print("Number of pennies used = ");
       System.out.print(numQuarter);
       System.out.print("x25 + ");
       System.out.print(numDime);
       System.out.print("x10 + ");
       System.out.print(numNickel);
       System.out.print("x5 = ");
       System.out.println(numPenny - nickelRemainder);
       System.out.print("Maximum number of minutes to park: ");
       System.out.print(numQuarter);
       System.out.print("x36 + ");
       System.out.print(numDime);
       System.out.print("x14 + ");
       System.out.print(numNickel);
       System.out.print("x4 = ");
       System.out.println((numQuarter * minsPerQuarter)+ (numDime * minsPerDime) + (numNickel * minsPerNickel));
       System.out.println ();
       //  Above : Run #1. Asks for how many pennies (aka cents) used then calculates the maximum amount of
       // parking time possible
       
       System.out.print("Enter the number of pennies available -> ");
       numPenny = scanone.nextInt ();
            
       numQuarter = numPenny / 25;
       quarterRemainder = numPenny % 25;
       
       numDime = quarterRemainder / 10;
       dimeRemainder = quarterRemainder % 10;
       
       numNickel = dimeRemainder / 5;
       nickelRemainder = dimeRemainder % 5;
       
       System.out.print("Number of pennies used = ");
       System.out.print(numQuarter);
       System.out.print("x25 + ");
       System.out.print(numDime);
       System.out.print("x10 + ");
       System.out.print(numNickel);
       System.out.print("x5 = ");
       System.out.println(numPenny - nickelRemainder);
       System.out.print("Maximum number of minutes to park: ");
       System.out.print(numQuarter);
       System.out.print("x36 + ");
       System.out.print(numDime);
       System.out.print("x14 + ");
       System.out.print(numNickel);
       System.out.print("x4 = ");
       System.out.println((numQuarter * minsPerQuarter)+ (numDime * minsPerDime) + (numNickel * minsPerNickel));
       System.out.println ();
       // Above: Run 2. Repeats run 1 with different input from user using the same time per denomination.
       
       
       System.out.print("Enter the number of pennies available -> ");
       numPenny = scanone.nextInt ();
            
       numQuarter = numPenny / 25;
       quarterRemainder = numPenny % 25;
       
       numDime = quarterRemainder / 10;
       dimeRemainder = quarterRemainder % 10;
       
       numNickel = dimeRemainder / 5;
       nickelRemainder = dimeRemainder % 5;
       
       System.out.print("Number of pennies used = ");
       System.out.print(numQuarter);
       System.out.print("x25 + ");
       System.out.print(numDime);
       System.out.print("x10 + ");
       System.out.print(numNickel);
       System.out.print("x5 = ");
       System.out.println(numPenny - nickelRemainder);
       System.out.print("Maximum number of minutes to park: ");
       System.out.print(numQuarter);
       System.out.print("x36 + ");
       System.out.print(numDime);
       System.out.print("x14 + ");
       System.out.print(numNickel);
       System.out.print("x4 = ");
       System.out.println((numQuarter * minsPerQuarter)+ (numDime * minsPerDime) + (numNickel * minsPerNickel));
       System.out.println ();
       // // Above: Run 3. Repeats Run # 1 with different input from user using the same time per denomination.
    }
}