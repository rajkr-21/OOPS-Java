public class Abstraction{
    public static void main(String [] args){
        Payment obj =new UPI();
        Payment.display();
        obj.makePayment();
        Payment obj1=new CreditCard();
        obj1.makePayment();

    }
}

interface Payment{
    void makePayment();
    static void display(){System.out.println("Payment Successfull");}
}
class UPI implements Payment{
    @Override
    public void makePayment(){
        System.out.println("Payment using UIPI");
    }
}
class CreditCard implements Payment{
    @Override
    public void makePayment(){
        System.out.println("Payment using Credit Card");
    }
}
