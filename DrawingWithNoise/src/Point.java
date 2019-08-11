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

    public int getAlpha() {
        return (int)p.alpha(color);
    }

    public PVector getPosition() {
        return position.copy();
    }

    public void setColor(int color) {
        int r = (int)p.red(color);
        int g = (int)p.green(color);
        int b = (int)p.blue(color);
        int a = (int)p.alpha(this.color);
        this.color = p.color(r, g, b, a);
    }

    public float distance(Point point) {
        float x1 = position.x;
        float y1 = position.y;
        float x2 = point.getPosition().x;
        float y2 = point.getPosition().y;
        return PApplet.dist(x1, y1, x2, y2);
    }

    public void display() {
        p.stroke(color);
        p.fill(color);
        p.ellipse(position.x, position.y, 3, 3);
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
