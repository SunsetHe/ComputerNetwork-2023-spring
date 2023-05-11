package New.Week4;

public class ThreadTest04 implements Runnable{
    @Override
    public void run() {
        int worktime = 0;

        while (true){
            System.out.println("助教在教室的第"+worktime+"秒");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            worktime++;
        }
    }
}
