package New.Week1to3;

public class Watch {
    long startTime;
    long endTime;

    void start(){
        this.startTime = System.currentTimeMillis();
    }

    void stop(){
        this.endTime = System.currentTimeMillis();
    }
}

