package chuck.western.impl;

public class Ticket extends Thread {
    private int ticket = 5;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if(ticket > 0){
                System.out.println("ticket = " + ticket --);
            }
        }
    }
}

class ticketrunnable implements Runnable{

    private int ticket = 5;
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if(ticket > 0){
                System.out.println("ticket = " + ticket --);
            }
        }
    }
}
class t{
    public static void main(String[] args) {
        //three threads shared the same 't'
        ticketrunnable t = new ticketrunnable();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
    }
}

