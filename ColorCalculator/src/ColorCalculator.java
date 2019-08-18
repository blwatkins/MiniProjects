// Color Calculator
// Main Class

import processing.core.PApplet;
import processing.core.PVector;

public class ColorCalculator extends PApplet {
    private HorizontalSlider slider;
    private HorizontalSlider s;

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
        PVector sliderPos = new PVector(width / 2f - sliderLength / 2, height / 2);
        slider = new HorizontalSlider(this, sliderPos, sliderLength, 10, 0, 255);
        s = new HorizontalSlider(this, sliderPos.sub(new PVector(0, 100)), sliderLength, 10, 60, 100);
    }

    public void draw(){
        background(255);
        if (slider.isActive()) {
            float val = slider.getCurrentValue();
            s.setCurrentValue(val / 2);
        } else if (s.isActive()) {
            float val = s.getCurrentValue();
            slider.setCurrentValue(val * 2);
        }
        slider.display();
        s.display();
    }

    public void mousePressed() {
        slider.mousePressed(mouseX, mouseY);
        s.mousePressed(mouseX, mouseY);
    }

}
