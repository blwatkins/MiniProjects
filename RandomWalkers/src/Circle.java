import processing.core.PApplet;
import processing.core.PVector;

import color.Color;

public class Circle {
    private final PApplet p;
    private final PVector position;
    private final PVector speed;
    private final Color color;
    private final int maxSpeed;
    private float radius;


    public Circle(PApplet p, PVector position, int maxSpeed) {
        this.p = p;
        this.position = position.copy();
        this.maxSpeed = maxSpeed;
        speed = new PVector(0, 0);
        radius = p.random(5, 50);
        color = new Color(p, p.color(0, 0, 255));
    }

    public void setColor(int color) {
        this.color.setColor(color);
    }

    public void display() {
        p.stroke(0);
        p.fill(color.getColor());
        p.ellipse(position.x, position.y, radius * 2, radius * 2);
    }

    public void move() {
        position.add(speed);
    }

    public void update() {
        updateRadius();
        updateSpeed();
    }

    public boolean isTooSmall() {
        return (radius <= 1);
    }

    private void updateRadius() {

        if (radius > 1) {
            radius -= 0.1;
        }
    }

    private void updateSpeed() {
        speed.set(p.random(-maxSpeed, maxSpeed), p.random(-maxSpeed, maxSpeed));
    }
}
