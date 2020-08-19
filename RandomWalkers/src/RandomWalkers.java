// Press 'a' to clear the screen

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

import color.ColorGenerator;
import color.ColorGeneratorFactory;

public class RandomWalkers extends PApplet {
    private ArrayList<Circle> circles;
    private ColorGenerator colorGenerator;
    private Timer timer;

    public static void main(String[] args) {
        String[] processingArgs = {"RandomWalkers"};
        PApplet.main(processingArgs);
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        circles = new ArrayList<>();
        ColorGeneratorFactory colorGeneratorFactory = new ColorGeneratorFactory(this);
        colorGenerator = colorGeneratorFactory.getRandomColorGenerator();
        timer = new Timer(this, 1000);
        background(0);
    }

    public void draw() {
        addCircles();
        displayCircles();
        removeCircles();
    }

    public void keyPressed() {

        if (key == 'a') {
            clearScreen();
        }
    }

    public void mousePressed() {
        addCircle(mouseX, mouseY);
    }

    private void addCircles() {

        if (timer.isReady()) {
            addCircle(random(width), random(height));
            timer.reset();
        }
    }

    private void addCircle(float x, float y) {
        PVector position = new PVector(x, y);
        int color = colorGenerator.getRandomColor();
        Circle circle = new Circle(this, position, (int)random(5, 20));
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
}
