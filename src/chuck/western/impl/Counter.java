package chuck.western.impl;

public class Counter {
    private int count = 10;

    public int inc(){
        synchronized (this){
            return count --;
        }
    }
    public int getCount(){
        return count;
    }
}

class CountRunnable implements Runnable{
    private Counter counter = new Counter();

    @Override
    public void run() {
        while(counter.inc() >0){
            System.out.println(counter.getCount());
        }
    }
}

class runna{
    public static void main(String[] args) {
        CountRunnable cr = new CountRunnable();
        new Thread(cr).start();
        new Thread(cr).start();
        new Thread(cr).start();
    }
}
