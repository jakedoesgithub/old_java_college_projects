/**
 *  This is a program that simulates the rearrangement of a collection of marbles. 
 * 0 denotes a black marble while 1 denotes a white marble. <br>
 * CSC 1350 Lab # 7
 * @author Jake Ardoin
 * @since 11/1/17
 */
package marblerearranger;
import java.util.Arrays;

public class MarbleRearranger {
    /**
     * Gives the index of the first, left-most white marble.
     * @param marbles an array of 0's and 1's denoting black
     * and white marbles, respectively.
     * @return the index of the left-most white (1) marble.
     */
    public static int getFirstWhiteIndex(int[] marbles)
    {
      int white = 1;
      int returnPos = marbles.length;
      int pos = 0;
      boolean found = false;
      while (pos < marbles.length && !found)
        {
            if (marbles[pos] == white)
            {
             found = true;
             returnPos = pos;
            }
             else
            {
             pos++;
            }
        }
      return returnPos;
    }
            
            
    /**
     * Determines the index of the left-most black marble
     * (0) to the right of the index from or the number of 
     * marbles (length of the array) if there is none.
     * @param marbles an array of 0's and 1's denoting black
     * and white marbles, respectively.
     * @param from the index of a white marble
     * @return the index of the left-most black marble
     */
    public static int getNextBlackIndex(int[] marbles, int from)
    {
      int black = 0;
      int returnPos = marbles.length;
      int pos = from;
      boolean found = false;
      while (pos < marbles.length && !found)
        {
            if (marbles[pos] == black)
            {
             found = true;
             returnPos = pos;
            }
             else
            {
             pos++;
            }
        }
      return returnPos;
    }
    
    /**
     * Exchanges the elements with the specified indices
     * @param marbles an array of 0's and 1's denoting black
     * and white marbles, respectively.
     * @param i an index of a marble
     * @param j another index of a marble
     */
     public static void swap(int[] marbles, int i, int j)
     {
         int temp = marbles[i];
         marbles[i] = marbles[j];
         marbles[j] = temp;
     }
     
    
    public static void main(String[] args) 
    {  
    int[] marbles = {1,0,1,0,0,1,0,1,1};

    int white = getFirstWhiteIndex(marbles);
    int black = getNextBlackIndex(marbles, white);
    System.out.printf("marbles[] = %s%n", Arrays.toString(marbles));
     System.out.printf("Left Most White Index = %d, Next Black Index = %d%n", white, black);
     System.out.printf("# of Marbles Examined for Next Black Index: %d%n", black - white);

    
    do
    {
     swap(marbles, white, black);
     System.out.printf("marbles[] = %s%n", Arrays.toString(marbles));
     white++;
     black = getNextBlackIndex(marbles, white);
     System.out.printf("Left Most White Index = %d, Next Black Index = %d%n", white, black);
     System.out.printf("# of Marbles Examined for Next Black Index: %d%n", black - white);

    }
    while (black < marbles.length);
    System.out.printf("marbles[] = %s%n", Arrays.toString(marbles));
    System.out.printf("Left Most White Index = %d, Next Black Index = %d%n", white, black);
    System.out.printf("# of Marbles Examined for Next Black Index: %d%n", black - white-1);
    System.out.printf("*** no black marble found to the right of the leftmost white marble");
    }
            
            

}
