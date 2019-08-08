// Point Class

import processing.core.PApplet;
import processing.core.PVector;

public class Point {
    private PApplet p;
    private PVector position;
    private int color;

    public Point(PApplet p) {
        init(p);
    }

    public Point(PApplet p, float x, float y) {
        init(p);
        position.set(x, y);
    }

    public Point(PApplet p, PVector position) {
        init(p);
        this.position.set(position);
    }

    private void init(PApplet p) {
        this.p = p;
        position = new PVector();
        color = p.color(0, 0, 255, 255);
    }

    public PVector getPosition() {
        return position.copy();
    }

    public void display() {
        p.stroke(color);
        p.fill(color);
        p.ellipse(position.x, position.y, 5, 5);
        fade();
    }

    private void fade() {
        int red = (int)p.red(color);
        int green = (int)p.green(color);
        int blue = (int)p.blue(color);
        int alpha = (int)p.alpha(color);
        alpha--;
        alpha = PApplet.constrain(alpha, 0, 255);
        color = p.color(red, green, blue, alpha);
    }

    public boolean isFaded() {
        int alpha = (int)p.alpha(color);
        return alpha == 0;
    }


}
