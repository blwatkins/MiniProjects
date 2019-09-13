// Shape Rain
// Main Class

import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PVector;
import shape.Shape;
import shape.Circle;
import shape.Polygon;
import shape.Star;

public class ShapeRain extends PApplet {
    private ArrayList<Shape> shapes;
    private int shapeType;
    private int shapePoints;
    private float n;

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
        shapeType = (int)random(0, 3);
        shapePoints = (int)random(3, 10);
    }

    public void draw(){
        background(255);
        float x = random(width);
        float y = random(height);
        float size = (noise(n) * 9.5F) + 0.5F;
        Shape p;

        if (shapeType == 0) {
            p = new Circle(this, new PVector(x, y), size);
        } else if (shapeType == 1) {
            p = new Polygon(this, new PVector(x, y), shapePoints, size);
        } else {
            p = new Star(this, new PVector(x, y), shapePoints, size);
        }

        shapes.add(p);

        for (Shape shape: shapes) {
            shape.display();
            shape.fade();
        }

        for (int i = shapes.size() - 1; i >= 0; i--) {

            if (shapes.get(i).isFaded()) {
                shapes.remove(shapes.get(i));
            }
        }

        n += 0.01;
    }

    public void keyPressed() {

        if (key == 's') {
            shapeType = (int)random(0, 3);
            shapePoints = (int)random(3, 10);
        }

    }

}
