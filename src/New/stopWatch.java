package New;

public class stopWatch extends Watch {
    public stopWatch() {
        super();
    }

    public long getElapsedTime() {
        start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        stop();
        return this.endTime - this.startTime;
    }

}
