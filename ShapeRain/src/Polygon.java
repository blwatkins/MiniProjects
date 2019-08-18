import processing.core.PApplet;
import processing.core.PVector;

public class Polygon {
    private PApplet p;
    private PVector position;
    private PVector[] vertices;
    private int[] color;
    private float radius;

    public Polygon(PApplet p, PVector position, int sides, float radius) {
        this.p = p;
        this.position = position.copy();
        this.radius = radius;
        init(sides);
    }

    private void init(int sides) {
        initColor();
        initVertices(sides);
    }

    private void initColor() {
        color = new int[4];
        color[0] = 0;
        color[1] = 0;
        color[2] = 0;
        color[4] = 255;
    }

    private void initVertices(int sides) {
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
        p.pushMatrix();
        p.translate(position.x, position.y);
        p.beginShape();

        for (int i = 0; i < vertices.length; i++) {
            p.vertex(vertices[i].x, vertices[i].y);
        }

        p.endShape(p.CLOSE);
    }

}
