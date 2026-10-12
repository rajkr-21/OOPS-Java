import java.util.*;

// Custom comparator for descending order
class CustomComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        // Safe against integer overflow
        return Integer.compare(o2, o1);
    }
}

// Renamed class to avoid conflict with java.util.Comparator
public class StudentMarksSorting {
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

        // Sorting the list in ascending order (natural ordering)
        a.sort(null);
        System.out.println("Sorted Marks List (Ascending): " + a);

        // Sorting the list in descending order using CustomComparator
        a.sort(new CustomComparator());

        System.out.println("Sorted Marks List (Descending): " + a);
    }
}