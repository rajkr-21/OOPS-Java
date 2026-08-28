// Save as Student.java
class Student {
    String name;
    int rollNo;

    // Default Constructor
    Student() {
        this.name = "Not Assigned";
        this.rollNo = 0;
    }

    // Parameterized Constructor
    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    // Method to display details
    void display() {
        System.out.println("Roll No: " + rollNo + ", Name: " + name);
    }

    public static void main(String[] args) {
        // Creating objects using different constructors
        Student s1 = new Student();
        Student s2 = new Student("Amit Kumar", 45);

        s1.display();
        s2.display();
    }
}
