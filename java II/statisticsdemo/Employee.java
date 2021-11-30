
package statisticsdemo;

/**
 *
 * @author jardo16
 */
public class Employee implements Measurables, Comparable
{
    private String name;
    private int hours;
    private int rate;
    private int sales;
    private double netPay;
    
    public Employee(String name, int hours, int rate, int sales)
    {
        this.name = name;
        this.hours = hours;
        this.rate = rate;
        this.sales = sales;
        double wages;
        
        if(hours <= 40)
        {
            wages = (rate*hours);
        }
        else if( hours > 40 && hours <= 60)
        {
            wages = (rate*40) + (1.5*rate*(hours - 40));
        }
        else
        {
            wages = (rate*40) + (1.5*rate*20) + (2*rate*(hours - 60));
        }
        
        double commission = sales * 0.15;
        double grossPay = wages + commission;
        double withholdingTax = grossPay * 0.18;
        netPay = grossPay - withholdingTax;
        
    }
    
    public int getFirstInt()
    {
        return hours;
    }
    
    public int getSecondInt()
    {
        return rate;
    }
    
    public int getThirdInt()
    {
        return sales;
    }
    
    public double getDouble()
    {
        return netPay;
    }
    
    public int compareTo(Object otherObject)
    {
        Employee object = (Employee)otherObject;
        if (this.netPay < object.netPay)
        {
            return -1;
        }
        else if (this.netPay > object.netPay)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
    
    public String toString()
    {
       return String.format("%s %d, %d, %d, %.2f,", name, hours, rate, sales, netPay);
    }
    
}
