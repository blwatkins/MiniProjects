import processing.core.PApplet;
import processing.core.PVector;

public class Circle {
    private PApplet p;
    private PVector position;
    private float radius;
    private int color;

    public Circle(PApplet p) {
        this.p = p;
        position = new PVector(p.random(p.width), p.random(p.height));
        radius = p.random(5, 50);
        color = p.color((int)p.random(255), (int)p.random(255), (int)p.random(255));
    }

    public PVector getPosition() {
        return position;
    }

    public float getRadius() {
        return radius;
    }

    public void display() {
        p.fill(color);
        p.noStroke();
        p.ellipse(position.x, position.y, radius * 2, radius * 2);
    }

    public boolean overlap(Circle c) {
        float distance = PApplet.dist(position.x, position.y, c.position.x, c.position.y);
        return distance < radius + c.radius;
    }
}
