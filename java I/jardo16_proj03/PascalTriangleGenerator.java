
package pascaltrianglegenerator;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;



/**
 * This program creates a Pascal triangle and outputs it to a user defined file. <br>
 * CSC 1350 Project #4 <br>
 * @author Jake Ardoin
 * @since 11/5/17
 */
public class PascalTriangleGenerator 
{ 

    /**
    * Computes an array containing the coefficients of the binomial (x+y)^(k+1)
    * given an array containing the coefficients of the binomial (x + y)^k.
    * @param currentRow an array that contains the coefficients of an expansion
    * of the binomial (x + y)^k for some k >= 0.
    * @return an array containing the binomial coefficients of an expansion of
    * the binomial (x + y)^(k+1) or the array [1] when currentRow is null.
    */
    public static int[] nextRow(int[] currentRow)
    {
    if (currentRow == null)
    {
        int[] newArray = {1};
        return newArray;
    }
    else
    {
     int[] newArray;
     newArray = new int[currentRow.length + 1];
     newArray[0] = 1;
     newArray[newArray.length - 1] = 1;
     for (int i = 1; i < newArray.length -1; i++)
     {
         newArray[i] = (currentRow[i-1] + currentRow[i]);
     }
     return newArray;       
    }
    }

    /**
    * Displays a row of the Pascal’s triangle
    * @param row an array containing binomial coefficients
    * @param numRows the number of rows that the triangle will have
    * @param shift the number of columns by which the first
    * @param writer a reference to a file output stream
    * coefficient, 1, of the next row is shifted leftward
    * from the first coefficient on the previous row.
    */
    public static void printRow(int row[], int numRows, int shift, PrintWriter writer)
    {
     int margin = (numRows - row.length)*shift;
     String output = "";
     for (int i=0; i<margin; i++)
     {
         output+=" ";
     }
        
     for (int i = 0; i < row.length; i++ )
     {
         output += row[i];
         
         for (int p = 0; p < shift; p++)
         {
             output+= " ";
         }
     }
        System.out.println(output);
        writer.println(output);
    }


    public static void main(String[] args) throws IOException
    {
        
       
       
       Scanner in = new Scanner(System.in);
       System.out.print("Enter the name of the output file -> ");
       PrintWriter fileOut = new PrintWriter(new File(in.next()));
       System.out.print("Enter the number of rows for the triangle -> ");
       int numberRows = in.nextInt();
       
       int[] row = nextRow(null);
       for (int i = 0; i < numberRows; i++)
       {
           printRow(row, numberRows, 1, fileOut);
           row = nextRow(row);
       }

     fileOut.close(); 
    }
    
}
