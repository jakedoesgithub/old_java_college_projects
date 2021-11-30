package outputdemo;

/**
 * This program is written to experiment with the use of <br>
 * 'print' and 'println' methods, variable declaration, concatenation, <br>
 * dividing two integers and dividing doubles or mixed operations<br>,
 * CSC 13250 Lab # 1,br.
 * @author Jake Ardoin
 * @since 09/06/2017
 */
public class OutputDemo
{
    public static void main(String[] args)
    {       
        System.out.println ("first name: Jane");
        System.out.println("last name: Taylor");  
        int first = 5, second = 6;
        System.out.println("first = " + first + ", second = " +second);
        double average = (first + second) / 2.0;
        System.out.println("Average = " + average);
        String firstName = "Jane";
        System.out.println("first name: " + firstname);
        String name = "Jane Taylor";
        System.out.println("name: " + name);
    }
} 
