package New.Week5;

public class PlusMinusOne {
    public volatile int num;

    public void plusOne(){
        synchronized (this){
            this.num = this.num + 1;
            this.printNum();
        }
    }

    public void minusOne(){
        synchronized (this){
            this.num = this.num - 1;
            this.printNum();
        }
    }

    public void printNum(){
        System.out.println("num = " + this.num);
    }
}
