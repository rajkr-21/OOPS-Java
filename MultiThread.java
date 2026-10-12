class Counter {
    int count = 0;

    void increment() {
        count++;
        System.out.println(Thread.currentThread().getName() + " : " + count);
    }
}

class MyThread extends Thread {
    Counter c;

    MyThread(Counter c) {
        this.c = c;
    }

    public void run() {
        c.increment();
    }
}

public class MultiThread {
    public static void main(String[] args) {

        Counter c = new Counter();

        MyThread t1 = new MyThread(c);
        MyThread t2 = new MyThread(c);
        MyThread t3 = new MyThread(c);
        MyThread t4 = new MyThread(c);
        

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}