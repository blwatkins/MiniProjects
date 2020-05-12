import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class NoOverlap extends PApplet {
    private ArrayList<Circle> circles;

    public static void main(String[] args) {
        String[] processingArgs = {"NoOverlap"};
        PApplet.main(processingArgs);
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        circles = new ArrayList<>();

        for (int i = 0; i < 200; i++) {
            circles.add(new Circle(this));
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
        PVector position = new PVector(mouseX, mouseY);
        circles.add(new Circle(this, position));
        checkOverlap();
    }

    public void keyPressed() {
        circles.add(new Circle(this));
        checkOverlap();
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

        if (diff.mag() == 0) {
            diff.set(0, 1);
        }

        diff.normalize().mult(a.getRadius() + b.getRadius());
        b.getPosition().set(PVector.add(a.getPosition(), diff));
    }

}
