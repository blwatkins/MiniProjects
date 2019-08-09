// Color Calculator
// Main Class

import processing.core.PApplet;
import processing.core.PVector;

public class ColorCalculator extends PApplet {
    private Slider slider;

    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "ColorCalculator" };  // first string MUST match name of class

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
        float sliderLength = 400;
        PVector sliderPos = new PVector(width / 2 - sliderLength / 2, height / 2);
        slider = new Slider(this, sliderPos, sliderLength, 20, 0, 60);
    }

    public void draw(){
        slider.display();
    }

    public void mousePressed() {
        slider.mousePressed(mouseX, mouseY);
    }

}
