package New.Week4;

public class TestVolatile extends Thread{
    public volatile boolean sayHello = true;

    @Override
    public void run() {
        long count = 0;
        while (sayHello){
            count++;
        }

        System.out.println("Thread terminated"+count);
    }
}
