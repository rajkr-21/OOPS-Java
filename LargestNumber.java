public class LargestNumber {

   // Method to find the largest of three integers
   public int findLargest(int a, int b, int c) {
       int largest = a;
       if (b > largest) {
           largest = b;
       }
       if (c > largest) {
           largest = c;
       }
       return largest;
   }

   // Method to find the largest of 
   // three doubles (method overloading)
   public double findLargest(double a, double b, double c) {
       double largest = a;
       if (b > largest) {
           largest = b;
       }
       if (c > largest) {
           largest = c;
       }
       return largest;
   }

   public static void main(String[] args) {
       LargestNumber ln = new LargestNumber();

       // Accepting three integer numbers
       int num1 = 12, num2 = 15, num3 = 9;
       System.out.println("Largest integer is: " + ln.findLargest(num1, num2, num3));

       // Accepting three double numbers
       double num4 = 12.5, num5 = 15.3, num6 = 9.8;
       System.out.println("Largest double is: " + ln.findLargest(num4, num5, num6));
   }
}
