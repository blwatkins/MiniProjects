// Shape Rain
// Main Class

import java.util.ArrayList;

import color.ColorGenerator;
import processing.core.PApplet;
import processing.core.PVector;
import shape.Shape;
import shape.Circle;
import shape.Polygon;
import shape.Star;

public class ShapeRain extends PApplet {
    private ArrayList<Shape> shapes;
    private ColorGenerator colorGenerator;
    private float colorTimer;
    private float colorTimerMax;
    private int shapeType;
    private int shapePoints;
    private float n;
    private boolean move;
    private boolean backgroundIsWhite;

    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "ShapeRain" };  // first string MUST match name of class

        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        shapes = new ArrayList<>();
        colorGenerator = new ColorGenerator(this);
        shapeType = (int)random(0, 3);
        shapePoints = (int)random(3, 10);
        colorTimer = 0;
        colorTimerMax = 500;
        move = false;
        backgroundIsWhite = true;
    }

    public void draw(){
        noStroke();
        if (backgroundIsWhite) {
            fill(255, 50);
        } else {
            fill(0, 50);
        }
        rect(-10, -10, width + 10, height + 10);
        float x = random(width);
        float y = random(height);
        float size = (noise(n) * 9.5F) + 0.5F;
        int col = getColor();

        Shape p;

        if (shapeType == 0) {
            p = new Circle(this, new PVector(x, y), size);
        } else if (shapeType == 1) {
            p = new Polygon(this, new PVector(x, y), shapePoints, size);
        } else {
            p = new Star(this, new PVector(x, y), shapePoints, size);
        }

        p.setColor(col);
        shapes.add(p);

        for (Shape shape: shapes) {
            shape.display();
            shape.fade();

            if (move) {
                shape.move();
            }

        }

        for (int i = shapes.size() - 1; i >= 0; i--) {

            if (shapes.get(i).isFaded()) {
                shapes.remove(shapes.get(i));
            }
        }

        n += 0.01;
        colorTimer = (colorTimer + 1f) % colorTimerMax;
    }

    public void keyPressed() {

        if (key == 'a') {
            colorGenerator.setRandomColorType();
        } else if (key == 's') {
            shapeType = (int)random(0, 3);
            shapePoints = (int)random(3, 10);
        } else if (key == 'd') {
            move = !move;
        } else if (key == 'f') {
            backgroundIsWhite = !backgroundIsWhite;
        }

    }

    public int getColor() {
        int col = color(255);

        if (colorGenerator.isRGB()) {
            col = colorGenerator.randomColor();
        } else if (colorGenerator.isHSB()) {
            col = colorGenerator.mapColor(colorTimer, 0, colorTimerMax, 360, 360);
        }

        return col;
    }

}
