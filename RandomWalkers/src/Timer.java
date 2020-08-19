import processing.core.PApplet;

public class Timer {
    private final PApplet p;
    private final int millisecondWait;
    private int previousMilliseconds;

    public Timer(PApplet p, int millisecondWait) {
        this.p = p;
        this.millisecondWait = millisecondWait;
        previousMilliseconds = p.millis();
    }

    public boolean isReady() {
        boolean isReady = false;

        if (previousMilliseconds + millisecondWait <= p.millis()) {
            isReady = true;
        }

        return isReady;
    }

    public void reset() {
        previousMilliseconds = p.millis();
    }
}
