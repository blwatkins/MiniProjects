package shape;

import processing.core.PApplet;
import processing.core.PVector;

public class Circle extends Shape {
    private float radius;

    public Circle(PApplet p, PVector position, float radius) {
        super(p, position);
        this.radius = radius;
    }

    public void display() {
        p.noStroke();
        p.fill(color.getColor());
        p.pushMatrix();
        p.translate(position.x, position.y);
        p.ellipse(0, 0, radius * 2, radius * 2);
        p.popMatrix();
    }

}
