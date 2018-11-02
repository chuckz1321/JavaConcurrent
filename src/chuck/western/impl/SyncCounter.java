package chuck.western.impl;

public class SyncCounter {
    public int count = 0;
    public int increment(){
        return count++;
    }

    public static void main(String[] args) {
        SyncCounter counter = new SyncCounter();
        new CountRun(counter).start();
        new CountRun(counter).start();
        new CountRun(counter).start();
    }
}

class CountRun extends Thread{
    private SyncCounter counter = null;

    public CountRun(SyncCounter counter){
        this.counter = counter;
    }
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            counter.increment();
            System.out.println(Thread.currentThread().getName() + ": " + counter.count);
        }
    }
}
