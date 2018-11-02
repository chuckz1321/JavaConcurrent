package chuck.western.impl;

public class SyncSignal extends Thread{

    private Signal si = null;

    public SyncSignal(Signal s){
        this.si = s;
    }

    @Override
    public void run() {
        try {
            if (!si.si) {
                si.swap();
                sleep(1000);
                System.out.println(Thread.currentThread().getName() + ": swap() ");
            }
        }catch (InterruptedException e){

        }
    }
}

class Signal{
    public boolean si = false;
    public void swap(){
        si = true;

    }
}
class Tre{
    public static void main(String[] args) {
        Signal s = new Signal();
        new SyncSignal(s).start();
        new SyncSignal(s).start();
        new SyncSignal(s).start();
        new SyncSignal(s).start();
        new SyncSignal(s).start();
        new SyncSignal(s).start();
        new SyncSignal(s).start();
        new SyncSignal(s).start();
        new SyncSignal(s).start();
        new SyncSignal(s).start();
    }
}