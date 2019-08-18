// Shape Rain
// Main Class

import processing.core.PApplet;
import processing.core.PVector;

public class ShapeRain extends PApplet {
    Polygon shape;

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
        shape = new Polygon(this, new PVector(width/2, height / 2), 10, 200);
    }

    public void draw(){
        background(255);
        shape.display();
    }

}
