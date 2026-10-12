import java.util.*;

// Standalone custom comparator for descending order by marks
class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        // Compare s2 to s1 for descending order
        if (s1.getMarks() != s2.getMarks()) {
            return Integer.compare(s2.getMarks(), s1.getMarks());
        } else {
            // If marks are equal, compare by roll number for consistent ordering
            return Integer.compare(s1.getRoll(), s2.getRoll());
        }
    }
}

class Student {
    private String name;
    private int roll;
    private int marks;

    public Student(String name, int roll, int marks) {
        this.name = name;
        this.roll = roll;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public int getRoll() {
        return roll;
    }

    // Overriding toString() to display meaningful student details
    @Override
    public String toString() {
        return "Roll No: " + roll + " | Name: " + name + " | Marks: " + marks;
    }
}

public class ComparatorDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // 1. Add marks of 5 students
        students.add(new Student("A", 1, 85));
        students.add(new Student("B", 2, 92));
        students.add(new Student("C", 3, 78));
        students.add(new Student("D", 4, 92));
        students.add(new Student("E", 5, 88));

        System.out.println("--- Original List ---");
        students.forEach(System.out::println);

        // 2. Sort in Descending Order using the custom Comparator class
        students.sort(new StudentComparator());

        System.out.println("\n--- Descending Order (Custom Comparator) ---");
        students.forEach(System.out::println);
    }
}