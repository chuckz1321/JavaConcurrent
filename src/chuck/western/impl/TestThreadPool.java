package chuck.western.impl;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class TestThreadPool {
    public static void main(String[] args) throws InterruptedException{
        ExecutorService exec = Executors.newFixedThreadPool(3);

        //创建10个线程目标对象
        for(int index = 0; index < 10; index ++){
            Runnable run = new Runner(index);
            //执行线程目标对象
            exec.execute(run);
        }
        //shutdown
        exec.shutdown();
    }
}

class Runner implements Runnable{
    int index = 0;
    public Runner(int index){
        this.index = index;
    }
    @Override
    public void run() {
        long time = (long) (Math.random()*1000);
        System.out.println("线程："+Thread.currentThread().getName()+"(目标对象"
                +index+")"+":Sleeping"+time+"ms");
        try{
            Thread.sleep(time);
        }catch (InterruptedException e){

        }
    }
}