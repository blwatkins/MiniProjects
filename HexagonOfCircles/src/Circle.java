import processing.core.PApplet;
import processing.core.PVector;

import color.Color;

public class Circle {
    private PApplet p;
    private PVector position;
    private float diameter;
    private float deltaDiameter;
    private Color color;

    public Circle(PApplet p, PVector position, float diameter) {
        this.p = p;
        this.position = new PVector();
        this.position.set(position);
        this.diameter = diameter;
        color = new Color(p);
        deltaDiameter = p.random(-3, 3);
    }

    public Color getColor() {
        return color;
    }

    public PVector getPosition() {
        return position;
    }

    public void setColor(int color) {
        this.color.setColor(color);
    }

    public void display() {
        p.fill(color.getColor());
        p.ellipse(position.x, position.y, diameter, diameter);
    }

    public void move() {
        diameter += deltaDiameter;

        if (diameter > 50 || diameter < 10) {
            deltaDiameter *= -1;
        }
    }

}
