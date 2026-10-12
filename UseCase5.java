class TicketCounter implements Runnable {
    private int availableTickets = 3;

    public synchronized void bookTicket() {
        if (availableTickets > 0) {
            System.out.println(Thread.currentThread().getName() + " sold ticket number: " + availableTickets);
            availableTickets--;
        } else {
            System.out.println(Thread.currentThread().getName() + " Tickets are sold out.");
        }
    }

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        while (availableTickets > 0) {
            bookTicket();
        }
    }
}

public class UseCase5 {
    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter();

        Thread t1 = new Thread(counter, "Counter-1");
        Thread t2 = new Thread(counter, "Counter-2");

        t1.setPriority(10);

        t1.start();
        t2.start();
    }
}
