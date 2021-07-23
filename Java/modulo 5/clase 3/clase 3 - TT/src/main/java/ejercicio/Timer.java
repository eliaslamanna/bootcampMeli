package ejercicio;

public class Timer {

    private long startMs;
    private long stopMs;

    public void start() {
        this.startMs = System.currentTimeMillis();
    }

    public void stop() {
        this.stopMs = System.currentTimeMillis();
    }

    public long elapsedTime() {
        return this.stopMs - this.startMs;
    }

    public long getStartMs() {
        return startMs;
    }

    public void setStartMs(long startMs) {
        this.startMs = startMs;
    }

    public long getStopMs() {
        return stopMs;
    }

    public void setStopMs(long stopMs) {
        this.stopMs = stopMs;
    }
}
