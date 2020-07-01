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
    }
}
