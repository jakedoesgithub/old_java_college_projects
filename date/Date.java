
package date;

/**
 *
 * @author Jake Ardoin
 */
public class Date {

    
   private int month;
   private int day;
   private int year;
   
   public Date()
   {
       month = 1;
       day = 1;
       year = 1970;
   }
 
   public Date (int m, int d, int y)
   {
       month = m;
       day = d;
       year = y;
   }
   
   public Date(Date date)
   {
       month = date.month;
       day = date.day;
       year = date.year; 
   }
   
   public int getMonth()
   {
       return month;
   }
   
   public int getDay()
   {
       return day;
   }
   
   public int getYear()
   {
       return year;
   }
   
   public void setDate(int m, int d, int y)
   {
       month = m;
       day = d;
       year = y;
   }
   

   
   
 
}
