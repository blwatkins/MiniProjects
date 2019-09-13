package shape;

import processing.core.PApplet;
import processing.core.PVector;
import color.Color;

public class Polygon extends Shape {
    protected PVector[] vertices;
    protected float radius;

    public Polygon(PApplet p, PVector position, int sides, float radius) {
        super(p, position);
        this.radius = radius;
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

}
