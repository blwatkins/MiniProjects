// Press 'a' to clear the screen
// Press 'w' to increase the maximum speed
// Press 's' to decrease the maximum speed

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

import color.ColorGenerator;
import color.ColorGeneratorFactory;

public class RandomWalkers extends PApplet {
    private ArrayList<Circle> circles;
    private ColorGenerator colorGenerator;
    private ColorGeneratorFactory colorGeneratorFactory;
    private int maxSpeed;

    public static void main(String[] args) {
        String[] processingArgs = {"RandomWalkers"};
        PApplet.main(processingArgs);
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        circles = new ArrayList<>();
        colorGeneratorFactory = new ColorGeneratorFactory(this);
        colorGenerator = colorGeneratorFactory.getRandomColorGenerator();
        maxSpeed = 5;
        background(0);
    }

    public void draw() {
        displayCircles();
        removeCircles();
    }

    public void keyPressed() {

        if (key == 'a') {
            clearScreen();
        } else if (key == 'w') {
            increaseMaxSpeed();
        } else if (key == 's') {
            decreaseMaxSpeed();
        }
    }

    public void mousePressed() {
        addCircle(mouseX, mouseY);
    }

    private void addCircle(float x, float y) {
        PVector position = new PVector(x, y);
        int color = colorGenerator.getRandomColor();
        Circle circle = new Circle(this, position, maxSpeed);
        circle.setColor(color);
        circles.add(circle);
    }

    private void displayCircles() {

        for (Circle circle: circles) {
            circle.display();
            circle.move();
            circle.update();
        }
    }

    private void removeCircles() {

        for (int i = circles.size() - 1; i >= 0; i--) {

            if (circles.get(i).isTooSmall()) {
                circles.remove(i);
            }
        }
    }

    private void clearScreen() {
        background(0);
        circles.clear();
    }

    private void increaseMaxSpeed() {
        maxSpeed++;
        maxSpeed = constrain(maxSpeed, 1, 20);
    }

    private void decreaseMaxSpeed() {
        maxSpeed--;
        maxSpeed = constrain(maxSpeed, 1, 20);
    }
}
