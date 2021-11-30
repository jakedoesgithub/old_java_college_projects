
package minmaxfinder;
import java.util.Scanner;

/** This program is designed to process a group of test scores and track some details about it.
 * It will find the max and min of the group of test scores and the average. <br>
 *CSC Lab 1350 Lab # 5
 * @author jardo16
 * @since 10/11/2017
 */
public class MinMaxFinder {

    public static void main(String[] args) {
     Scanner in = new Scanner(System.in);


    
     //startup message
     System.out.print("Enter number of test scores (>= 5) to computer the lowest, highest, and sum of passing scores -> ");
     int scoreCount = in.nextInt();
     System.out.println();
     
     //first score
     System.out.print("Enter the first test  score [0-100] -> ");
     int score = in.nextInt();
     int max = score;
     int min = score;
     int fCount = 0;
     int sumPassScores= 0;
     String listOfFScores = "";
     if (score < 60)
     {
         fCount ++;
         listOfFScores = listOfFScores + score + " ";
     }
     else if (score > 70)
     {
        sumPassScores += score;
     }
     System.out.printf("Lowest = %d, Highest = %d and Sum of Passing Scores = %d%n", min, max, sumPassScores);
     System.out.printf("Number of F Scores (%d) : %s%n%n", fCount, listOfFScores);
     
     //start loop
     
     for(int i = 1; i < scoreCount; i++)
     {
        System.out.print("Enter the next test score [0-100] -> ");
        score = in.nextInt();
        if (score > max)
        {
            max = score;
        }
        else if (score < min)
        {
           min = score;
        }
         
        if (score < 60)
        {
           fCount ++;
           listOfFScores = listOfFScores + score + " ";
        }
        else if (score > 70)
        {
           sumPassScores += score;
        }
          System.out.printf("Lowest = %d, Highest = %d and Sum of Passing Scores = %d%n", min, max, sumPassScores);
          System.out.printf("Number of F Scores (%d) : %s%n%n", fCount, listOfFScores);
    
    }

}

}