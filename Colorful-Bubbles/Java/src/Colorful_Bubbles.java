// Colorful Bubbles
// An array of multicolored circles that move based on the mouse position
// Press the 'a' key to activate and deactivate trails

import processing.core.PApplet;

public class Colorful_Bubbles extends PApplet{

    Bubble[] bubbles;
    boolean trails;

    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "Colorful_Bubbles" };

        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }

    }

    public void settings() {
        size(displayWidth, displayHeight - 45);
    }

    public void setup() {
        bubbles = new Bubble[400];
        trails = true;
        String[] colors = {"magenta", "cyan", "blue", "red", "green"};
        int colDivisions = colors.length;
        int rowDivisions = height / colDivisions;

        for (int i = 0; i < bubbles.length; i++) {
            int x = (i % colDivisions) * (width / (colDivisions - 1));
            int y = (i % rowDivisions) * (colDivisions + 1);
            bubbles[i] = new Bubble(x, y, getRandomColor(colors[i % colDivisions]));
        }

    }

    public void draw() {

        if (!trails) {
            background(255);
        }

        for (Bubble b : bubbles) {
            b.display();

            if (b.mouseOver()) {
                b.move();
            }

        }

    }

    public void keyPressed() {

        if (key == 'a') {
            trails = !trails;
        }

    }


}
