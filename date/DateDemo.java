
package date;
import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author Jake Ardoin
 */
public class DateDemo {

        static String findWeekday(int month, int day, int year)
        {
            
            int m = month;
            int d = day;
            int yr = year;
            int c = year / 100;
            int v = year % 100;
            int u = 2*(3-(c%4));
            int w = v / 4;
            int x;
            int q;
          
            
            String[] dayName = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
            
            if (yr % 400 == 0 || (yr % 100 != 0 && yr % 4 == 0))
            {
                int[] xValue = {0,6,2,3,6,1,4,6,2,5,0,3,5};
                x = xValue[m];
            }
            else
            {
                int[] xValue = {0,0,3,3,6,1,4,6,2,5,0,3,5};
                x = xValue[m];
            }
            
            int y = u + v + w + x + d;
            
            int dayOfWeek = y % 7;
            
            return dayName[dayOfWeek];
        }
   
        public static void main(String[] args) 
    {
        
        
        
        String[] monthName = {"no month 0", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int m1, d1, y1,actualDayFirst, actualDayLast;
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the date in mm/dd/yyyy format");
        String line = in.nextLine();
        System.out.println();
        String[] nums = line.split("/");
        m1 = Integer.parseInt(nums[0]);
        d1 = Integer.parseInt(nums[1]);
        y1 = Integer.parseInt(nums[2]);
        
        Date firstDay = new Date(m1, d1, y1);
        Date lastDay = new Date(firstDay);
        
        System.out.printf("First day of class: %s, %s %d, %d%n", findWeekday(firstDay.getMonth(),firstDay.getDay(), firstDay.getYear()), monthName[firstDay.getMonth()], firstDay.getDay(), firstDay.getYear());
        System.out.printf("Last day of class: %s, %s %d, %d%n", findWeekday(lastDay.getMonth(), lastDay.getDay(), lastDay.getYear()), monthName[lastDay.getMonth()], lastDay.getDay(), lastDay.getYear());
        
        System.out.println();
        
        System.out.printf("Enter the last day of class:%n");
        String line2 = in.nextLine();
        System.out.println();
        String[] nums2 = line2.split("/");
        m1 = Integer.parseInt(nums2[0]);
        d1 = Integer.parseInt(nums2[1]);
        y1 = Integer.parseInt(nums2[2]);
        
        lastDay.setDate(m1, d1, y1);
        
        System.out.printf("First day of class: %s, %s %d, %d%n", findWeekday(firstDay.getMonth(),firstDay.getDay(), firstDay.getYear()), monthName[firstDay.getMonth()], firstDay.getDay(), firstDay.getYear());
        System.out.printf("Last day of class: %s, %s %d, %d%n", findWeekday(lastDay.getMonth(), lastDay.getDay(), lastDay.getYear()), monthName[lastDay.getMonth()], lastDay.getDay(), lastDay.getYear());
        
        
    }
}
