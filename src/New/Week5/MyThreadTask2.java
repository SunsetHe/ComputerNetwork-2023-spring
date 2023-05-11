package New.Week5;

import java.util.ArrayList;
import java.util.Random;

public class MyThreadTask2 implements Runnable{
    static int[] seeds = {1234567,2345671,3456712};
    Res res;
    public ArrayList<Integer> list;
    public MyThreadTask2(int id, Res _res){
        Random r = new Random(seeds[id]);
        list = new ArrayList<>();
        for (int i = 0;i < 100;i++){
            list.add(r.nextInt(10000));
        }
        res = _res;
    }

    @Override
    public void run() {
        synchronized (res){
            int max = list.get(0);
            for (int i = 1;i < 100;i++){
                if (list.get(i) > max){
                    max = list.get(i);
                }
            }
            res.max_index = max;
        }
    }
}
