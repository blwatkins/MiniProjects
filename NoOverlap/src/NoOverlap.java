import processing.core.PApplet;
import processing.core.PVector;

public class NoOverlap extends PApplet {
    private Circle[] circles;

    public static void main(String[] args) {
        String[] processingArgs = {"NoOverlap"};
        PApplet.main(processingArgs);
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        circles = new Circle[100];

        for (int i = 0; i < circles.length; i++) {
            circles[i] = new Circle(this);
        }

        checkOverlap();
    }

    public void draw() {
        background(0);

        for (Circle circle: circles) {
            circle.display();
        }
    }

    public void mousePressed() {

    }

    private void checkOverlap() {
        boolean overlap;

        do {
            overlap = false;
            for (Circle a : circles) {
                for (Circle b : circles) {
                    if (a != b) {
                        if (a.overlap(b)) {
                            overlap = true;
                            removeOverlap(a, b);
                        }
                    }
                }
            }
        } while (overlap);
    }

    private void removeOverlap(Circle a, Circle b) {
        PVector diff = PVector.sub(a.getPosition(), b.getPosition());
        diff.normalize().mult(a.getRadius() + b.getRadius());
        b.getPosition().set(PVector.add(a.getPosition(), diff));
    }

}
