package set;
 
import java.util.ArrayList;

/**
 * 
 * @author Jake Ardoin
 */

public class Set<T>
{
    
   /**
    * A list of elements contained in the set
    */
   public ArrayList<T> elements;

   
   /**
    * Creates a set using the elements of the ArrayList list.
    * @param list the ArrayList whose elements are used to create this set.
    * @throws IllegalArgumentException if list contains a duplicity.
    */
   public Set(ArrayList<T> list)
   {
       elements = new ArrayList();
       int i, size = list.size();
       T elt;
       for(i = 0; i < size; i++)
       {
          elt = list.get(i);
          if (elements.contains(elt))
              throw new IllegalArgumentException("Set<T>: Duplicity not "
                      + "allowed in sets");
          elements.add(elt);
       }
   }

   
   /**
    * Determines whether a set contains the specified element
    * @param elt an element
    * @return true if elt is an element of this set; otherwise, false
    */
   public boolean isElement(T elt)
   {
       return elements.contains(elt);
   }

   
   /**
    * Determines whether a set is empty
    * @return true if this set is empty; otherwise, false
    */
   public boolean isEmpty()
   {
       return elements.isEmpty();
   }

   
   /**
    * Computes the intersection of this set and the specified set.
    * @return a set representing the intersection of this set and s.
    */
   public Set<T> intersect(Set<T> s)
   {
      T elt;
      ArrayList<T> result = new ArrayList();
      int i, size = elements.size();
      for (i = 0; i < size; i++)
      {
         elt = elements.get(i);
         if (s.elements.contains(elt))
            result.add(elt);
      }
      return new Set(result);           
   }

   
   /**
    * Computes the union of this set and the specified set.
    * @return a set representing the union of this set and s.
    */
   public Set<T> union(Set<T> s)
   {
       T elt;
       ArrayList<T> result = new ArrayList(s.elements);
       int size = elements.size();
       for(int i = 0; i < size; i++)
       {
           elt = elements.get(i);
           if( !result.contains(elt))
           {
               result.add(elt);
           }
        
       }
       return new Set(result);
   }

   
   /**
    * Computes the difference of this set and the specified set.
    * @return a set representing the difference of this set and s.
    */
   public Set<T> diff(Set<T> s)
   {
       T elt;
       ArrayList<T> result = new ArrayList(elements);
       int size = s.elements.size();
 
       for(int i = 0; i < size; i++)
       {
           elt = s.elements.get(i);
           if(result.contains(elt))
           {
               result.remove(elt);
           }
       }
       return new Set(result);
   }   


   /**
    * Determines whether this set is equal to the specified object.
    * @return false if the specified object is not equal to this set; 
    *         otherwise, true
    */
   public boolean equals(Object obj)
   {
       T elt;
       Set<T> list = (Set<T>)obj;
       if(elements.size() != list.elements.size())
       {
           return false;
       }
       int size = list.elements.size();
       for(int i = 0; i < size; i++)
       {
           if(!elements.contains(list.elements.get(i)))
           {
               return false;
           }
       }
       return true;
   }

   
   /**
    * Determines whether this set is a subset of the specified set.
    * @return false if this set is not a subset of the specified set;
    *         otherwise, true
    */
   public boolean subset(Set<T> s)
   {
      T elt;
      int size = elements.size();
      for(int i = 0; i < size; i++)
      {
          elt = elements.get(i);
          if( !s.elements.contains(elt))
          {
              return false;
          }
      }
      return true;
   }

   
   /**
    * Determines whether this set is a proper subset of the specified set.
    * @return false if this set is not a proper subset of the specified set;
    *         otherwise, true
    */
   public boolean properSubset(Set<T> s)
   {
       T elt;
       if( this.equals(s))
       {
           return false;
       }
       for(int i = 0; i < elements.size(); i++)
       {
           elt = elements.get(i);
           if(!s.elements.contains(elt))
           {
               return false;
           }
       }
       return true;
   }

   
   /**
    * returns a string {x1,x2,...,xn} representing this set,
    * where x1,x2,...,xn are elements of this set.
    * @return a string representation of this set formatted
    *         as specified.
    */
   public String toString()
   {
      String setAsString = "{";
      int size = elements.size();
      if (size > 0)
	  {
         setAsString += elements.get(0);
         int i;
         for (i = 1; i < size; i++)
            setAsString += ", " + elements.get(i);         
      }
      return setAsString+"}";            
   }

}