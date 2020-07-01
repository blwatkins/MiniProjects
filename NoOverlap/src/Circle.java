import processing.core.PApplet;
import processing.core.PVector;

import color.Color;

public class Circle {
    private PApplet p;
    private PVector position;
    private float radius;
    private Color color;

    public Circle(PApplet p) {
        this.p = p;
        position = new PVector(p.random(p.width), p.random(p.height));
        radius = p.random(1, 50);
        color = new Color(p, p.color(255));
    }

    public void setColor(int color) {
        this.color.setColor(color);
    }

    public void display() {
        p.fill(color.getColor());
        p.noStroke();
        p.ellipse(position.x, position.y, radius * 2, radius * 2);
    }

    public boolean overlap(Circle c) {
        float distance = PApplet.dist(position.x, position.y, c.position.x, c.position.y);
        return distance < radius + c.radius;
    }
}
