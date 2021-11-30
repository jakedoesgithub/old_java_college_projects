
package sorter;
import java.util.Arrays;
/**
 *This will create an array, print it, sort it according to selectionSort method
 * and print it again. 
 * @author jardo16
 * @since 11/15/2017
 * 
 */
public class SelectionSortDemo {
    
    public static void main(String[] args)
    {
       // int[] test2 = {9,8,7,6,5,4,3,2,1};
       // int[] test1 = {1,2,3,4,5,6,7,8,9};
        int[] array = {2, 4, 5, 6, 4, 5, 3, 5, 3};
        System.out.printf("Initial Data: %s%n%n", Arrays.toString(array));
        
        Sorter.selectionSort(array);
        System.out.printf("%nSorted Data: %s", Arrays.toString(array));
    }
}
