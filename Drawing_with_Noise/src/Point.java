// Point Class

import processing.core.PApplet;
import processing.core.PVector;

public class Point {
    private PApplet p;
    private PVector position;

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

    public PVector getPosition() {
        return position.copy();
    }

    public void display() {
        p.point(position.x, position.y);
    }


}
