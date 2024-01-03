/*
 * Author: James Jesus
 * Date: 1/3/2024
 * 
 * Removes duplicates from an ArrayList
 */
import java.util.ArrayList;

public class GenericsFundamental {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(14);
    list.add(24);
    list.add(14);
    list.add(42);
    list.add(25);
    
    System.out.println(list.toString());
    
    ArrayList<Integer> newList = removeDuplicates(list);
    
    System.out.print(newList);
  }
  
  public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
	  ArrayList<E> newList = (ArrayList)list.clone();
	  for (int i = 0; i < newList.size(); i++) {
		  for (int x = 0; x < newList.size(); x++) {
			  if ((newList.get(x).equals(newList.get(i))) && i != x) {
				  newList.remove(x);
				  newList.remove(i);
			  }
		  }
	  }
	  return newList;
  }
}