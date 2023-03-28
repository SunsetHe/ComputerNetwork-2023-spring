package New;

import java.util.Random;

public class Fish implements Animal,Comparable<Fish> {

    @Override
    public void eat() {
        System.out.println("Fish eat");
    }

    @Override
    public void travel() {
        System.out.println("Fish travels");
    }

    @Override
    public int compareTo(Fish o) {
        return Integer.compare(this.size,o.getSize());
    }

    public int getSize() {
        return size;
    }


    int size;
    public Fish(){
        Random r = new Random();
        this.size = r.nextInt(100);
    }
    public void print(){
        System.out.print(this.size+"<");
    }



}
