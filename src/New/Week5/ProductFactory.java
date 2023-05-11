package New.Week5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class ProductFactory {
    Queue<String> productQueue = new LinkedList<>();
    public synchronized void addProduct(String s){
        productQueue.add(s);
        this.notifyAll();
    }

    public synchronized String getProduct() throws InterruptedException{
        while (productQueue.isEmpty()){
            this.wait();
        }
        return productQueue.remove();
    }
}
