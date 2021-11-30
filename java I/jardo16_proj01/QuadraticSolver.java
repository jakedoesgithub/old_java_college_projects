
package quadraticsolver;
import java.util.Scanner;

/**
 * The purpose of this program is to use conditional statements, logical
 * operators, standard math class methods, basic arithmetic operators,
 * and other java functions to design a program based around quadratic
 * equations. It accepts user input for the variables of the equation, 
 * displays the equation, determines its discriminant, roots, axis of
 * symmetry, vertex, x-intercept, y-intercept, and the shape of the parabola.
 * @author Jake Ardoin
 * @since 9/23/17
 * Course: CS1350 <br>
 * Section: 002 <br>
 * PAWS ID: jardo16 <br>
 * project #: 1 <br>
 * Instructor: Dr. Duncan <br>
 */
public class QuadraticSolver 
{
    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
    // The part that asks for user input
        System.out.print("Enter the coefficient of the quadratic term -> ");
        double quadratic = in.nextDouble();
        System.out.print("Enter the coefficient of the linear term -> ");
        double linear = in.nextDouble();
        System.out.print("Enter the coefficient of the constant term -> ");
        double constant = in.nextDouble();
        System.out.println();
        
    // The part that tells user if the inputs correspond to a quadratic term or not
    // then prints the quadratic equation 
       if (quadratic == 0)
       {
           System.out.print("Equation is not quadratic if input for the quadratic coefficient is 0");
           System.exit(0);
       }

       System.out.printf("For the quadratic equation ");
       
       // quadratic term display
       if (quadratic == -1)
       {
           System.out.print("-x^2");
       }
       else if (quadratic == 1)
       {
           System.out.print("x^2");
       }
       else
       {
           System.out.printf("%.5fx^2", quadratic);
       }
       
       // linear term display
       if (linear == -1)
       {
           System.out.printf("-x");
       }
       else if (linear == 1)
       {
           System.out.print("+x ");
       }
       else if (linear < -1)
       {
           System.out.printf("%.5fx", linear);
       }
       else if (linear > 1)
       {
           System.out.printf("+%.5fx", linear);
       }
       
       // constant term display
       if (constant < 0 )
       {
           System.out.printf("%.5f", constant);
       }
       else if (constant > 0)
       {
           System.out.printf("+%.5f", constant);
       }
       
       System.out.println("=0 :");
       System.out.println();
       
     // The part that calculates the discriminant
     double discriminant = (Math.pow(linear, 2) - 4 * quadratic * constant);
     System.out.printf("Discriminant: %.5f", discriminant);
     System.out.println();
     
     
     // The part that calculates the axis of symmetry
     double axis = (-(linear / (2 * quadratic)));
     System.out.printf("Axis of Symmetry: x = %.5f", axis);
     System.out.println();
     
       
     //The part that calculates the vertex
     double vertexX = (-linear / (2 * quadratic));
     double vertexY = (((-Math.pow(linear, 2)) / (4 * quadratic)) + constant);
     System.out.printf("Vertex: (%.5f, %.5f)", vertexX, vertexY);
     System.out.println();
     
     // The part that calculates the y-intercept
     System.out.printf("y-intercept: (0.00000, %.5f)", constant);
     System.out.println();
    
     
     // The part that figures out how many x-intercepts there are and displays them along
     // with the shape and the roots
     if (discriminant == 0)
     {
        double onlyX = (-linear / (2 * quadratic));
        System.out.printf("x-intercept: (%.5f, 0.00000)", onlyX);
        System.out.println();
        System.out.println("Shape: " + (quadratic > 0 ? "Concave upward" : "Concave downward"));
        System.out.printf("Root: x = {%.5f}", onlyX);
     }
     
     else if (discriminant > 0)
     {    
        double firstX = ((-linear + Math.sqrt(discriminant)) / (2 * quadratic));
        double secondX = ((-linear - Math.sqrt(discriminant)) / (2 * quadratic));
        System.out.printf("x-intercepts: (%.5f, 0.00000) and (%.5f, 0.00000)", firstX, secondX);
        System.out.println();
        System.out.println("Shape: " + (quadratic > 0 ? "Concave upward" : "Concave downward"));
        System.out.printf("Roots: x = {%.5f, %.5f}", firstX, secondX);
     }
     else
     {
        double ratPart = (-linear / (2 * quadratic));
        double radPart = (Math.sqrt(Math.abs(discriminant)) / Math.abs(2 * quadratic));
        System.out.println("x-intercepts: none");
        System.out.println("Shape: " + (quadratic > 0 ? "Concave upward" : "Concave downward"));
        
        if (ratPart == 0)
        {    
            System.out.printf("Root: x = {%.5fi, %.5fi}", radPart, -radPart);
        }
        else
        {
            System.out.printf("Root: x = {%.5f+%.5fi, %.5f-%.5fi}", ratPart, radPart, ratPart, radPart);
        }
     }
     
    }
    

    
}
