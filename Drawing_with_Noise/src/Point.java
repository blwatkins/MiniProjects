// Point Class

import processing.core.PApplet;
import processing.core.PVector;

public class Point {
    private PApplet p;
    private PVector position;
    private float diameter = 2;

    public Point(PApplet p) {
        this.p = p;
        position = new PVector();
    }

    public Point(PApplet p, float x, float y) {
        this.p = p;
        position = new PVector(x, y);
    }

    public Point(PApplet p, PVector position) {
        this.p = p;
        this.position = position.copy();
    }

    public void display() {
        p.ellipse(position.x, position.y, diameter, diameter);
    }
}
