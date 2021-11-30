
package sorter;
import java.util.Arrays;

/**
 * This program is designed to test the implementation of several variants
 * of the selection sort algorithm.
 * @author jardo16
 * @since 11/15/17
 */
public class Sorter {

 
//     /**
//     * This will sort a numerical array from smallest to largest. Sorts Left to right.
//     * It then prints the array after each swap.
//     * @param list the array you wish to sort
//     * @version 1 First Version
//     */
//    public static void selectionSort(int[] list)
//    {
//        int i, j, temp, minIndex;
//        for (i = 0; i < list.length - 1; i++)
//        {
//             minIndex = i;
//             for (j = i+1; j < list.length; j++)
//            {
//                if (list[j] < list[minIndex])
//                    minIndex = j;
//            }
//            temp = list[i];
//            list[i] = list[minIndex];    
//            list[minIndex] = temp;
//            System.out.println(Arrays.toString(list));
//       }  
//    }
//    
//     /**
//     * This will sort a numerical array from smallest to largest. Sorts Left to right.
//     * It then prints the array after each swap. It will also print the 
//     * pairs of elements that are compared prior to each swap.
//     * @param list the array you wish to sort
//     * @version 2 Section Version
//     */
//
//    public static void selectionSort(int[] list)
//    {
//        int i, j, temp, minIndex;
//        for (i = 0; i < list.length - 1; i++)
//        {
//             minIndex = i;
//             for (j = i+1; j < list.length; j++)
//            {
//                if (list[j] < list[minIndex])
//                    minIndex = j;
//                System.out.printf("(%d,%d)", list[i], list[j]);
//            }
//            temp = list[i];
//            list[i] = list[minIndex];    
//            list[minIndex] = temp;
//            System.out.printf("%n%s%n",Arrays.toString(list));
//       }  
//    }
    
    
//     /**
//     * This will sort a numerical array from largest to smallest. Sorts Left to right.
//     * It then prints the array after each swap. It will also print the 
//     * pairs of elements that are compared prior to each swap.
//     * @param list the array you wish to sort
//     * @version 3 Third Version
//     */
//    public static void selectionSort(int[] list)
//    {
//        int i, j, temp, maxIndex;
//        for (i = 0; i < list.length - 1; i++)
//        {
//             maxIndex = i;
//             for (j = i+1; j < list.length; j++)
//            {
//                System.out.printf("(%d,%d)", list[maxIndex], list[j]);
//                if (list[j] > list[maxIndex])
//                    maxIndex = j;
//            }
//            temp = list[i];
//            list[i] = list[maxIndex];    
//            list[maxIndex] = temp;
//            System.out.printf("%n%s%n",Arrays.toString(list));
//       }  
//    }
    
     /**
     * This will sort a numerical array from largest to smallest, sorts right to left.
     * It then prints the array after each swap. It will also print the 
     * pairs of elements that are compared prior to each swap.
     * @param list the array you wish to sort
     * @version 3 Third Version
     */    
    public static void selectionSort(int[] list)
    {
        int i, j, temp, minIndex;
        for (i = list.length-1; i> 0; i--)
        {
             minIndex = i;
             for (j = i-1; j >= 0; j--)
            {
                if (list[j] < list[minIndex])
                    minIndex = j;
                System.out.printf("(%d,%d)", list[i], list[j]);
            }
            temp = list[i];
            list[i] = list[minIndex];    
            list[minIndex] = temp;
            System.out.printf("%n%s%n",Arrays.toString(list));
       }  
    }
}
