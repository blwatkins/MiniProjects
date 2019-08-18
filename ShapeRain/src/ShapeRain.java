// Shape Rain
// Main Class

import processing.core.PApplet;

public class ShapeRain extends PApplet {

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

    }

    public void draw(){

    }

}
