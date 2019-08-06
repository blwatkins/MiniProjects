import processing.core.*;

public class Colorful_Bubbles {
    // setup() function -> run once at the beginning of the program
    // invoked automatically
    public void setup() {

    }

    // draw() function -> run about 60 times per second
    // invoked automatically
    public void draw() {

    }

    // settings() function -> run once before setup()
    // used to set size of window
    // invoked automatically
    public void settings() {
        size(500, 500);
    }


    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "ProjectTemplate" };  // first string MUST match name of class
        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }
    }
}
