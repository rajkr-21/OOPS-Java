import java.util.*;
public class Sorting {
    public static void main(String[] args) {
        // Create an ArrayList to store student marks
        ArrayList<Integer> a = new ArrayList<>();

        // Adding marks to the list
        a.add(85);
        a.add(78);
        a.add(92);
        a.add(70);
        a.add(60);

        // Displaying the original list of marks
        System.out.println("Original Marks List: " + a);

        // Sorting the list in ascending order
        a.sort(null);
        System.out.println("Sorted Marks List (Ascending): " + a);

        // Sorting the list in descending order
        a.sort(Collections.reverseOrder());

        System.out.println("Sorted Marks List (Descending): " + a);
    }
    
}
