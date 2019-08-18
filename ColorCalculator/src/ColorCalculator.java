// Color Calculator
// Main Class

import processing.core.PApplet;
import processing.core.PVector;

public class ColorCalculator extends PApplet {
    private HorizontalSlider[] hsbSliders;
    private HorizontalSlider[] rgbSliders;
    private float sliderLength;
    private float sliderHeight;

    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "ColorCalculator" };  // first string MUST match name of class

        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }
    }

    public void settings() {
        //fullScreen();
        size(800, 800);
    }

    public void setup() {
        sliderLength = (width / 2F) - (width / 8F);
        sliderHeight = (height / 40F);
        initHSBSliders();
    }

    public void draw(){
        setHSBBackgroundColor();
        for (int i = 0; i < hsbSliders.length; i++) {
            hsbSliders[i].display();
        }

    }

    public void mousePressed() {
        for (int i = 0; i < hsbSliders.length; i++) {
            hsbSliders[i].mousePressed(mouseX, mouseY);
        }
    }

    private void initHSBSliders() {
        hsbSliders = new HorizontalSlider[3];
        PVector sliderPos = new PVector(width / 16, 16 * height / 20);
        for (int i = 0; i < hsbSliders.length; i++) {
            hsbSliders[i] = new HorizontalSlider(this, sliderPos, sliderLength, sliderHeight, 0, 360);
            sliderPos.add(new PVector(0, sliderHeight * 2));
        }
    }

    private void setHSBBackgroundColor() {
        int h = (int)hsbSliders[0].getCurrentValue();
        int s = (int)hsbSliders[1].getCurrentValue();
        int b = (int)hsbSliders[2].getCurrentValue();

        colorMode(HSB, 360);
        fill(color(h, s, b));
        noStroke();
        rect(0, 14 * height / 20, width / 2, height);
        textSize(20);

        if (b > 180) {
            fill(0);
        } else {
            fill(255);
        }

        textAlign(CENTER, TOP);
        text("H = " + h + "; S = " + s  + "; B = " + b, width / 4, 14 * height / 20);
    }

}
