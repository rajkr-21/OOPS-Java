import java.util.Scanner;
public class AgeValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        try {
            agecheck(age);
            System.out.println("Age is valid.");
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void agecheck(int age) throws InvalidAgeException {
            if (age < 18) {
                throw new InvalidAgeException("Age is invalid..");
            }
    }
    class InvalidAgeException extends Exception {
        InvalidAgeException(String message) {
            super(message);
        }
    }
}
