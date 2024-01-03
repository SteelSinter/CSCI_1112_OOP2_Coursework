/*
 * Author: James Jesus
 * Date: 1/3/2024
 * Sorts an array.
 */
import java.util.ArrayList;
import java.util.Comparator;

public class Exercise19_9 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(14);
    list.add(24);
    list.add(4);
    list.add(42);
    list.add(5);
    System.out.println(list);
    Exercise19_9.<Integer>sort(list);
    
    System.out.print(list);
  }
  
  public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
	  list.sort(Comparator.naturalOrder());
  }
}
