import processing.core.PApplet;
import processing.core.PVector;

import color.Color;

public class Circle {
    private PApplet p;
    private PVector position;
    private PVector speed;
    private int maxSpeed;
    private float radius;
    private Color color;

    public Circle(PApplet p, PVector position, int maxSpeed) {
        this.p = p;
        this.position = position.copy();
        this.maxSpeed = maxSpeed;
        speed = new PVector(0, 0);
        radius = p.random(5, 50);
        color = new Color(p, p.color(0, 0, 255));
    }
}
