package chuck.western.impl;

public class syncTest extends  Thread{
    public syncTest(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(this.getName() + ": " + i);
        }
    }

    public static void main(String[] args) {
        new syncTest("thread1").start();
        new syncTest("thread2").start();
    }
}