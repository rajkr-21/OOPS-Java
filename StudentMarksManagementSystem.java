public import java.util.ArrayList;
import java.util.Iterator;

class NegativeMarksException extends Exception {
    public NegativeMarksException(String message) {
        super(message);
    }
}

// 2. Student class definition
class Student {
    private String name;
    private int roll;
    private ArrayList<Integer> marks;

    // Constructor to initialize name and roll number
    public Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
        this.marks = new ArrayList<>();
    }

    // Method to add marks with exception handling
    public void addMarks(int score) {
        try {
            if (score < 0) {
                throw new NegativeMarksException("Exception: Marks cannot be negative (" + score + " provided).");
            }
            marks.add(score);
        } catch (NegativeMarksException e) {
            // Display appropriate error message and prevent adding to the list
            System.out.println(e.getMessage());
        }
    }

    // Getters for displaying data
    public String getName() {
        return name;
    }

    public int getRoll() {
        return roll;
    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }
}

// Main class to demonstrate the system
public class StudentMarksManagementSystem {
    public static void main(String[] args) {
        // Create an ArrayList to store multiple students
        ArrayList<Student> studentList = new ArrayList<>();

        // Creating student instances
        Student s1 = new Student("Alice", 101);
        Student s2 = new Student("Bob", 102);

        // Adding marks to Alice (with some invalid negative inputs)
        System.out.println("--- Adding marks for " + s1.getName() + " ---");
        s1.addMarks(85);
        s1.addMarks(-10); // Should trigger exception
        s1.addMarks(90);

        // Adding marks to Bob
        System.out.println("\n--- Adding marks for " + s2.getName() + " ---");
        s2.addMarks(78);
        s2.addMarks(92);
        s2.addMarks(-5); // Should trigger exception

        // Adding students to the main list
        studentList.add(s1);
        studentList.add(s2);

        // Displaying student details using Iterators
        displayStudentDetails(studentList);
    }

    // Display function written using Iterator
    public static void displayStudentDetails(ArrayList<Student> list) {
        System.out.println("\n================ STUDENT DETAILS ================");
        
        // Iterator to traverse the Student list
        Iterator<Student> studentIterator = list.iterator();
        
        while (studentIterator.hasNext()) {
            Student student = studentIterator.next();
            System.out.println("Roll No: " + student.getRoll() + " | Name: " + student.getName());
            System.out.print("Marks: ");
            
            // Iterator to traverse the individual student's marks list
            Iterator<Integer> marksIterator = student.getMarks().iterator();
            if (!marksIterator.hasNext()) {
                System.out.print("No marks available");
            }
            while (marksIterator.hasNext()) {
                System.out.print(marksIterator.next());
                if (marksIterator.hasNext()) {
                    System.out.print(", ");
                }
            }
            System.out.println("\n-------------------------------------------------");
        }
    }
}
 {
    
}
