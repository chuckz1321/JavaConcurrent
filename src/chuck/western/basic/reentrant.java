package chuck.western.basic;

public class reentrant {
    public synchronized void doSomething(){
        System.out.println("super action");
    }
}


class son extends reentrant{
    public synchronized void doSomething(){
        System.out.println(toString() + ":calling super.doSomething");
        super.doSomething();
    }
}