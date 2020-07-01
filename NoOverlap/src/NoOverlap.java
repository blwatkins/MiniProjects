// Overlapping Algorithm from The Coding Train - https://youtu.be/XATr_jdh-44

import java.util.ArrayList;

import processing.core.PApplet;

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
    }

    public void draw() {
        background(0);
        addCircle();
        displayCircles();
    }

    public void keyPressed() {

        if (key == 'a') {
            circles.clear();
        }
    }

    private void addCircle() {
        Circle potentialCircle = new Circle(this);
        boolean isOverlapping = false;

        for (Circle circle: circles) {

            if (potentialCircle.overlap(circle)) {
                isOverlapping = true;
                break;
            }
        }

        if (!isOverlapping) {
            circles.add(potentialCircle);
        }
    }

    private void displayCircles() {

        for (Circle circle: circles) {
            circle.display();
        }
    }
}
