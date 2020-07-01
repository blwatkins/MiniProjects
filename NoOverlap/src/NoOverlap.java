// Overlapping Algorithm from The Coding Train - https://youtu.be/XATr_jdh-44
// Press 'a' to clear the circles
// Press 's' to change the color scheme

import java.util.ArrayList;

import processing.core.PApplet;

import color.ColorGenerator;
import color.ColorGeneratorFactory;

public class NoOverlap extends PApplet {
    private ArrayList<Circle> circles;
    private ColorGenerator colorGenerator;
    private ColorGeneratorFactory colorGeneratorFactory;

    public static void main(String[] args) {
        String[] processingArgs = {"NoOverlap"};
        PApplet.main(processingArgs);
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        circles = new ArrayList<>();
        colorGeneratorFactory = new ColorGeneratorFactory(this);
        colorGenerator = colorGeneratorFactory.getRandomColorGenerator();
    }

    public void draw() {
        background(0);
        addCircle();
        displayCircles();
    }

    public void keyPressed() {

        if (key == 'a') {
            circles.clear();
        } else if (key == 's') {
            changeColorScheme();
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
            potentialCircle.setColor(colorGenerator.getRandomColor());
            circles.add(potentialCircle);
        }
    }

    private void displayCircles() {

        for (Circle circle: circles) {
            circle.display();
        }
    }

    private void changeColorScheme() {
        colorGenerator = colorGeneratorFactory.getRandomColorGenerator();

        for (Circle c: circles) {
            int color = colorGenerator.getRandomColor();
            c.setColor(color);
        }
    }
}
