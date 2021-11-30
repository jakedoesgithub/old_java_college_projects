package statisticsdemo;

/**
 *
 * @author Jake Ardoin
 */

import java.util.Arrays;

public class StatisticsDemo 
{

    public static void main(String[] args) 
    {
        Student[] student = new Student[6];
        student[0] = new Student("Mary", 85, 93, 97);
        student[1] = new Student("Bob", 67, 77, 71);
        student[2] = new Student("Tom", 85, 91, 89);
        student[3] = new Student("Anna", 79, 72, 80);
        student[4] = new Student("Hal", 96, 88, 99);
        student[5] = new Student("Gina", 89, 91, 82);
        System.out.println("Students:  " + Arrays.toString(student));
        System.out.println();
        
        double[] avgs = averages(student);
        System.out.printf("Average Exam 1 Grade = %.2f\n", avgs[0]);
        System.out.printf("Average Exam 2 Grade = %.2f\n", avgs[1]);
        System.out.printf("Average Final Exam Grade = %.2f\n", avgs[2]);
        System.out.printf("Average Course Grade = %.2f\n", avgs[3]);       
        System.out.println();
        
        Arrays.sort(student);
        System.out.println("After sorting student by course grade, ");
        System.out.println("Students:  "+ Arrays.toString(student));
        System.out.println();
        
        double med = median(student);
        System.out.printf("Median of Course Grades = %.2f\n", med);
        System.out.println();
        System.out.println();
        
        Employee[] employee = new Employee[5];
        employee[0] = new Employee("Sara", 68, 19, 5473);
        employee[1] = new Employee("Sam", 51, 18, 5829);
        employee[2] = new Employee("Lisa", 47, 16, 3892);
        employee[3] = new Employee("Jim", 33, 21, 4857);
        employee[4] = new Employee("Judy", 39, 23, 4295);
        System.out.println("Employees:  " + Arrays.toString(employee));
        System.out.println();
       
        avgs = averages(employee);
        System.out.printf("Average Hours = %.2f\n", avgs[0]);
        System.out.printf("Average Rate = $%.2f\n", avgs[1]);
        System.out.printf("Average Sales = $%.2f\n", avgs[2]);
        System.out.printf("Average Net Pay = $%.2f\n", avgs[3]);
        System.out.println();
        
        Arrays.sort(employee);
        System.out.println("After sorting employee by net pay, ");
        System.out.println("Employees:  " + Arrays.toString(employee));
        System.out.println();
        
        med = median(employee);
        System.out.printf("Median of Net Pay = $%.2f\n", med);       
    }
    
    public static double[] averages(Measurables[] objects)
    {

     double[] result = new double[4];
     
        for (Measurables object : objects) 
        {
            result[0] += object.getFirstInt();
        }
        result[0] = result[0] / (double)objects.length;
        
        for (Measurables object : objects) 
        {
            result[1] += object.getSecondInt();
        }
        result[1] = result[1] / (double)objects.length;
        
        for (Measurables object : objects) 
        {
            result[2] += object.getThirdInt();
        }
        result[2] = result[2] / (double)objects.length;
        for (Measurables object : objects) 
        {
            result[3] += object.getDouble();
        }
        result[3] = result[3] / (double)objects.length;
        
        return result;

    }
    
    public static double median(Measurables[] objects)
    {
       double result;
       if((objects.length % 2) == 0)
       {
            result = (objects[objects.length/2].getDouble() + objects[(objects.length/2)-1].getDouble()) / 2;
       }
       else
       {
           result = objects[objects.length / 2].getDouble();
       }
       return result;
    }
    
}

