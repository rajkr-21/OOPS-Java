import java.util.*;
public class MapDemo {
    public static void main(String[] args) {
        // Create a HashMap to store student roll numbers and their corresponding names
        Map<Integer, Integer> s1 = new LinkedHashMap<>();

        // Adding students to the map
        s1.put(10, 100);
        s1.put(11, 98);
        s1.put(12, 80);
        s1.put(13, 70);
        s1.put(14, 60);
        s1.put(14,56);

        s1.remove(10);

        if (s1.containsKey(11)){
            System.out.println("Marks of Roll No"+ "is: " + s1.get(11));
        } else {
            System.out.println("Student Not Found");
        }

        // Displaying the student details using Map.Entry
        for (Map.Entry<Integer, Integer> i : s1.entrySet()) {
            System.out.println("Roll No: " + i.getKey() + " : Marks: " + i.getValue());
        }
    }
}
