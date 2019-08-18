import processing.core.PApplet;
import processing.core.PVector;

public class Circle extends Polygon {

    public Circle(PApplet p, PVector position, float radius) {
        super(p, position, 0, radius);
    }

    public void display() {
        p.noStroke();
        p.fill(color.getColor());
        p.pushMatrix();
        p.translate(position.x, position.y);
        p.ellipse(0, 0, radius, radius);
        p.popMatrix();
    }

}
