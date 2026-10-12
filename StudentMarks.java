import java.util.*;

public class StudentMarks {
    public static void addMarks(List<Integer> marks, int mark) {
        marks.add(mark);
    }

    public static double calculateAverage(List<Integer> marks) {

        double sum = 0;
        for (int x : marks) {
            sum += x;
        }
        return sum / marks.size();
    }

    public static int findHighest(List<Integer> marks) {

        int max = marks.get(0);
        for (int x : marks) {
            if (x > max) {
                max = x;
            }
        }
        return max;
    }

    public static void displayMarks(List<Integer> marks) {
        Iterator<Integer> it = marks.iterator();
            while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
    


    public static void main(String[] args) {
        List<Integer> marks = new ArrayList<>();

        addMarks(marks, 78);
        addMarks(marks, 85);
        addMarks(marks, 92);
        addMarks(marks, 67);
        addMarks(marks, 88);

        displayMarks(marks);

        System.out.println("Average: " + calculateAverage(marks));
        System.out.println("Highest: " + findHighest(marks));
    }
}
