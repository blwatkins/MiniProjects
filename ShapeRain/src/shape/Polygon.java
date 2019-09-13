package shape;

import processing.core.PApplet;
import processing.core.PVector;
import color.Color;

public class Polygon {
    protected PApplet p;
    protected PVector position;
    protected PVector[] vertices;
    protected Color color;
    protected float radius;

    public Polygon(PApplet p, PVector position, int sides, float radius) {
        this.p = p;
        this.position = position.copy();
        this.radius = radius;
        color = new Color(p, p.color(0, 0, 255));
        init(sides);
    }

    protected void init(int sides) {
        initVertices(sides);
    }

    protected void initVertices(int sides) {
        float theta = 0;
        sides = PApplet.constrain(sides, 3, 20);
        vertices = new PVector[sides];
        float deltaTheta = p.TWO_PI / sides;

        for (int i = 0; i < sides; i++) {
            float x = PApplet.cos(theta) * radius;
            float y = PApplet.sin(theta) * radius;
            theta += deltaTheta;
            vertices[i] = new PVector(x, y);
        }
    }

    public void setColor(int c) {
        p.colorMode(p.RGB, 255);
        int red = (int)p.red(c);
        int green = (int)p.green(c);
        int blue = (int)p.blue(c);
        color.setRed(red);
        color.setGreen(green);
        color.setBlue(blue);
    }

    public void display() {
        p.noStroke();
        p.fill(color.getColor());
        p.pushMatrix();
        p.translate(position.x, position.y);
        p.beginShape();

        for (int i = 0; i < vertices.length; i++) {
            p.vertex(vertices[i].x, vertices[i].y);
        }

        p.endShape(p.CLOSE);
        p.popMatrix();
    }

    public void fade() {
        color.setAlpha(color.getAlpha() - 1);
    }

    public boolean isFaded() {
        return color.getAlpha() == 0;
    }

}
