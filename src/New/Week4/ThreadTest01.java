package New.Week4;

public class ThreadTest01 extends Thread{
    @Override
    public void run() {
        for (int i = 0;i < 10;i++){
            System.out.println(Thread.currentThread().threadId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
