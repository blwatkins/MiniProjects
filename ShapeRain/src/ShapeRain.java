// Shape Rain
// Main Class

import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PVector;

public class ShapeRain extends PApplet {
    ArrayList<Polygon> shapes;

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
    }

    public void draw(){
        background(255);

        float x = random(width);
        float y = random(height);

        Polygon p = new Star(this, new PVector(x, y), 5, 10);
        shapes.add(p);

        for (Polygon shape: shapes) {
            shape.display();
            shape.fade();
        }

        for (int i = shapes.size() - 1; i >= 0; i--) {
            if (shapes.get(i).isFaded()) {
                shapes.remove(shapes.get(i));
            }
        }
    }

}
