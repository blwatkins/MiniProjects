import processing.core.PApplet;

public class DrawingWithNoise extends PApplet{

    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "DrawingWithNoise" };  // first string MUST match name of class

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

    public void draw() {
        line(pmouseX, pmouseY, mouseX, mouseY);
    }

}
