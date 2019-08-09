// Color Calculator
// Slider Class

import processing.core.PApplet;
import processing.core.PVector;

public class Slider {
    private PApplet p;
    private boolean active;
    private PVector position;
    private float length;
    private float minValue;
    private float maxValue;
    private float currentValue;

    public Slider(PApplet p) {
        init(p);
        position = new PVector();
        length = 100;
        minValue = 0;
        maxValue = 0;
        currentValue = minValue;
    }

    public Slider(PApplet p, PVector position, float length, float minValue, float maxValue) {
        init(p);
        this.position = position.copy();
        this.length = length;
        this.minValue = minValue;
        this.maxValue = maxValue;
        currentValue = minValue;
    }

    private void init(PApplet p) {
        this.p = p;
        active = false;
    }

    public void display() {
        p.rect(position.x, position.y, length, 10);
    }

}
