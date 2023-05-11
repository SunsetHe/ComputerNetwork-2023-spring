package New.Week5;

import New.Week4.PlusMinus;

public class MythreadTask3 implements Runnable{
    PlusMinus pm1;
    PlusMinus pm2;
    PlusMinus pm3;
    int tid;

    public MythreadTask3(PlusMinus pm1,PlusMinus pm2,PlusMinus pm3,int tid){
        this.pm1 = pm1;
        this.pm2 = pm2;
        this.pm3 = pm3;
        this.tid = tid;
    }

    @Override
    public void run() {
        if (tid == 1){
            synchronized (pm1){
                System.out.println("thread" + tid + "正在占用plusMinus1");
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("thread" + tid + "试图继续占用plusMinus2");
                System.out.println("thread" + tid + "等待中");
                synchronized (pm2){
                    System.out.println("thread" + tid + "成功占用plusMinus2");
                }
            }
        } else if (tid == 2) {
            synchronized (pm2){
                System.out.println("thread" + tid + "正在占用plusMinus2");
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("thread" + tid + "试图继续占用plusMinus3");
                System.out.println("thread" + tid + "等待中");
                synchronized (pm3){
                    System.out.println("thread" + tid + "成功占用plusMinus3");
                }
            }
        } else if (tid == 3) {
            synchronized (pm3){
                System.out.println("thread" + tid + "正在占用plusMinus3");
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("thread" + tid + "试图继续占用plusMinus1");
                System.out.println("thread" + tid + "等待中");
                synchronized (pm1){
                    System.out.println("thread" + tid + "成功占用plusMinus1");
                }
            }
        }
    }
}
