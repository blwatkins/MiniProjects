// Slider Value Class

import processing.core.PApplet;
import processing.core.PVector;

public class SliderValue {
    private PApplet p;
    private PVector position;
    private float diameter;

    public SliderValue(PApplet p) {
        this.p = p;
        position = new PVector();
        diameter = 15;
    }

    public SliderValue(PApplet p, PVector position, float diameter) {
        this.p = p;
        this.position = position.copy();
        this.diameter = diameter;
    }

    public PVector getPosition() {
        return position;
    }

    public float getDiameter() {
        return diameter;
    }

    public void updatePosition(float x, float minX, float maxX) {
        float y = position.y;
        x = PApplet.constrain(x, minX, maxX);
        position.set(x, y);
    }

    public void display() {
        p.noStroke();
        p.fill(0);
        p.ellipse(position.x, position.y, diameter, diameter);
    }

    public boolean rollover(float x, float y) {
        float distance = PApplet.dist(x, y, position.x, position.y);
        return distance < diameter / 2;
    }
}
