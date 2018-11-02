package chuck.western.impl;

class TestRunnable implements Runnable {
    private Thread t;
    private String tName;

    public TestRunnable(String name){
        this.tName = name;
        System.out.println(this.tName + "has been created.");
    }

    @Override
    public void run() {
        System.out.println(this.tName + " is running.");
        try{
            for (int i = 4; i >0 ; i--) {
                System.out.println("Thread: " +tName +", " + i);
                Thread.sleep(100);
            }
        }catch (InterruptedException e){
            System.out.println("Thread " +  tName + " interrupted.");
        }
        System.out.println("Thread " +  tName + " exiting.");
    }

    public void start(){
        System.out.println(tName + " starts.");
        if(t == null){
            t = new Thread(this, tName);
            t.start();
        }
    }
}

public class RunnableDemo{
    public static void main(String[] args) {
        TestRunnable r1 = new TestRunnable("thread1");
        r1.start();
        TestRunnable r2 = new TestRunnable("thread2");
        r2.start();
    }
}