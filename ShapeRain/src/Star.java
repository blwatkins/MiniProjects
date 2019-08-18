import processing.core.PApplet;
import processing.core.PVector;

public class Star extends Polygon {

    public Star(PApplet p, PVector position, int points, float radius) {
        super(p, position, points, radius);
    }

    protected void initVertices(int points) {
        float theta = 0;
        points = PApplet.constrain(points, 3, 20);
        vertices = new PVector[points * 2];
        float deltaTheta = p.TWO_PI / points * 2;

        for (int i = 0; i < vertices.length; i++) {
            float r = radius;

            if (i % 2 == 0) {
                r /= 2;
            }

            float x = PApplet.cos(theta) * r;
            float y = PApplet.sin(theta) * r;
            theta += deltaTheta;
            vertices[i] = new PVector(x, y);
        }
    }
}
