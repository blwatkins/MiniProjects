import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

import color.ColorGenerator;
import color.HSB.*;
import color.RGB.*;


public class HexagonOfCircles extends PApplet {
    private boolean addingCircles;
    private ArrayList<Circle> circles;
    private ColorGenerator colorGenerator;
    private float baseSize;
    private int sizeMode;
    private int constant = 1;
    private int distance = 2;
    private int random = 3;
    private boolean glow;
    private boolean move;

    public static void main(String[] args) {
        String[] processingArgs = {"HexagonOfCircles"};
        PApplet.main(processingArgs);
    }

    public void settings() {
        size(600, 600);
        //fullScreen();
    }

    public void setup() {
        randomColorGenerator();
        addingCircles = false;
        circles = new ArrayList<>();
        baseSize = 50;
        sizeMode = random;
        glow = false;
        thread("addCircles");
        move = false;
    }

    public void draw() {
        background(0);

        if (!addingCircles) {
            if (glow) {
                blendMode(ADD);
            }

            for (Circle c : circles) {
                c.display();
            }

            if (glow) {
                filter(BLUR, 6);
                for (Circle c : circles) {
                    c.display();
                }
            }

            if (move) {
                for (Circle c: circles) {
                    c.move();
                }
            }
        } else {
            textSize(20);
            textAlign(CENTER, CENTER);
            text("Loading...", width / 2f, height / 2f);
        }
    }

    public void addCircles() {
        addingCircles = true;
        addCircles(width / 2f, height / 2f, 0);
        addingCircles = false;
    }

    private void addCircles(float x, float y, int iteration) {
        if (iteration <= 8) {
            float s = map(dist(x, y, width / 2f, height / 2f), 0, min(width / 2f, height / 2f), baseSize, 10);

            if (sizeMode == distance) {
                addCircle(x, y, s);
            } else if (sizeMode == constant) {
                addCircle(x, y, baseSize);
            } else if (sizeMode == random) {
                addCircle(x, y, random(10, baseSize));
            }

            float theta = 0;
            for (int i = 0; i < 6; i++) {
                float a = x + (cos(theta) * baseSize);
                float b = y + (sin(theta) * baseSize);
                addCircles(a, b, iteration + 1);
                theta += TWO_PI / 6;
            }
        }
    }

    private void addCircle(float x, float y, float size) {
        boolean circlePresent = false;

        for (Circle c : circles) {
            if (dist(c.getPosition().x, c.getPosition().y, x, y) < baseSize) {
                circlePresent = true;
            }
        }

        if (!circlePresent) {
            Circle c = new Circle(this, new PVector(x, y), size);
            circles.add(c);
            c.setColor(colorGenerator.randomColor());
        }
    }

    public void keyPressed() {
        if (key == 'a') {
            randomColorGenerator();

            for (Circle c: circles) {
                c.setColor(colorGenerator.randomColor());
            }
        } else if (key == 's') {
            if (!addingCircles) {
                randomSizeMode();
                circles.clear();
                thread("addCircles");
            }
        } else if (key == 'd') {
            saveFrame("#######.png");
        } else if (key == 'f') {
           move = !move;
        } else if (key == 'g') {
            glow = !glow;
        }
    }

    private void randomColorGenerator() {
        int r = (int)random(1400);

        switch(r % 14) {
            case 0:
                colorGenerator = new BottomColorGenerator(this);
                break;
            case 1:
                colorGenerator = new RainbowColorGenerator(this);
                break;
            case 2:
                colorGenerator = new SoftColorGenerator(this);
                break;
            case 3:
                colorGenerator = new TopColorGenerator(this);
                break;
            case 4:
                colorGenerator = new WarmColorGenerator(this);
                break;
            case 5:
                colorGenerator = new BlackColorGenerator(this);
                break;
            case 6:
                colorGenerator = new BlueColorGenerator(this);
                break;
            case 7:
                colorGenerator = new CyanColorGenerator(this);
                break;
            case 8:
                colorGenerator = new GreenColorGenerator(this);
                break;
            case 9:
                colorGenerator = new MagentaColorGenerator(this);
                break;
            case 10:
                colorGenerator = new RandomColorGenerator(this);
                break;
            case 11:
                colorGenerator = new RedColorGenerator(this);
                break;
            case 12:
                colorGenerator = new WhiteColorGenerator(this);
                break;
            case 13:
                colorGenerator = new YellowColorGenerator(this);
                break;
        }
    }

    private void randomSizeMode() {
        int r = (int) random(300);

        if (r % 3 == 0) {
            sizeMode = constant;
        } else if (r % 3 == 1) {
            sizeMode = distance;
        } else {
            sizeMode = random;
        }

    }

}
