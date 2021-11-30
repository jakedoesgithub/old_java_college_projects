
package vector2d;

/**
 * The purpose of this class is to create a 2D vector and to modify it and get 
 * different variables from it and do addition, subtraction, dot product on it and<br>
 * to calculate the vector norm and to create a unit vector from any vector. also
 * modifies toString.
 * CSC 1350 Project #4 <br>
 * @author Jake Ardoin
 * @since 11/17/17
 */
public class Vector2D {
    private double x;
    private double y;
    

    /**
     * Creates a zero vector where both x and y = 0
     */
    public Vector2D()
    {
        x= 0;
        y= 0;
    }
    
     /**
     * Creates a vector with suer defined x and y
     * @param xComp the x value
     * @param yComp the y value
     */
    public Vector2D(double xComp, double yComp)
    {
        x = xComp;
        y = yComp;
    }
   
     /**
     * Creates a vector that is equivalent to v
     * @param v the name of the vector to be copied
     */
    public Vector2D(Vector2D v)
    {
       x = v.x;
       y = v.y;
    }
    
    /**
     * Gets the x-component of a vector
     * @return the x-component of a vector
     */
    public double getX()
    {
        return x;
    }
    
    /**
     * Gets the y-component of a vector
     * @return the y-component of a vector
     */
    public double getY()
    {
        return y;
    }
    
    /**
     * Computes the norm of a vector
     * @return the norm of a vector
     */
    public double norm()
    {
        double norm = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
        return norm;
    }
    
    /**
     * Modifies a vector using the specified parameters as its x- and y-
     * components
     * @param xComp the new x-value
     * @param yComp the new y value
     */
    public void setVector2D(double xComp, double yComp)
    {
        x = xComp;
        y = yComp;
    }
    
    /**
     * Computes the unit vector for a vector or throws an IllegalArgumentException
     * when invoked by the zero vector
     * @throws IllegalArgumentException invoked by the zero vector
     * @return the unit vector of the vector it is called on
     */
    public Vector2D unit()
    {
        if (x == 0 && y==0)
        {throw new IllegalArgumentException("An invalid argument has been supplied");}
        Vector2D unit = new Vector2D(x/norm(), y/norm());
        return unit;
        
    }
    
    /**
     * Computes the sum of 2 vectors
     * @param v the vector you want to compute the sum with
     * @return the sum of two vectors
     */
    public Vector2D add(Vector2D v)
    {
        Vector2D sum = new Vector2D(x+v.x , y+v.y);
        return sum;
    }
    
     /**
     * Computes the difference of 2 vectors
     * @param v the vector you want to compute the difference with
     * @return the difference of the two vectors
     */
    public Vector2D sub(Vector2D v)
    {
        Vector2D dif = new Vector2D(x-v.x , y-v.y);
        return dif;
    }
    
     /**
     * Computes the dot product of 2 vectors
     * @param v one of 2 vectors to be multiplied 
     * @return the dot product of the two vectors
     */
    public double dot(Vector2D v)
    {
        double dot = (v.x * x) + (v.y * y);
        return dot;
    }
    
     /**
     * Computes the product of a vector and a scalar
     * @param scalar the scalar to multiply by
     * @return the product of the vector and the scalar
     */
    public Vector2D sMulti(double scalar)
    {
        Vector2D sMulti = new Vector2D(x*scalar, y*scalar);
        return sMulti;
    }
    
     /**
     * determines whether two vectors are equal
     * @param v the vector to compare to
     * @return true/false
     */
    public boolean equals(Vector2D v)
    {
      boolean b;
      b = x==v.x && y==v.y;
      return b;
    }
    
     /**
     * gives a string representation of a vector in the format <x,y>, where x
     * and y are the x and y components of the vector
     * @return <x,y>
     */
    @Override
    public String toString()
    {
     String output = "<"+x+","+y+">";
     return output;
    }
    
    
    
    
    
    
    
    
    
}
