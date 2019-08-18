// Color Calculator
// Main Class

import processing.core.PApplet;
import processing.core.PVector;

import java.awt.image.RGBImageFilter;

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
        initRGBSliders();
    }

    public void draw(){
        displayHSBBackground();
        displayRGBBackground();
        for (int i = 0; i < hsbSliders.length; i++) {
            hsbSliders[i].display();
        }

        for (int i = 0; i < rgbSliders.length; i++) {
            rgbSliders[i].display();
        }

        if (isActive_HSB()) {
            setRGBSliders();
        } else if (isActive_RGB()) {
            setHSBSliders();
        }
    }

    public void mousePressed() {
        for (HorizontalSlider slider: hsbSliders) {
            slider.mousePressed(mouseX, mouseY);
        }

        for (HorizontalSlider slider: rgbSliders) {
            slider.mousePressed(mouseX, mouseY);
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

    private void initRGBSliders() {
        rgbSliders = new HorizontalSlider[3];
        PVector sliderPos = new PVector(width/2 + width / 16, 16 * height / 20);

        for (int i = 0; i < rgbSliders.length; i++) {
            rgbSliders[i] = new HorizontalSlider(this, sliderPos, sliderLength, sliderHeight, 0, 255);
            sliderPos.add(new PVector(0, sliderHeight * 2));
        }
    }

    private void displayHSBBackground() {
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
            fill(360);
        }

        textAlign(CENTER, CENTER);
        text("H = " + h + "; S = " + s  + "; B = " + b, width / 4, 15 * height / 20);
    }

    private void displayRGBBackground() {
        int r = (int)rgbSliders[0].getCurrentValue();
        int g = (int)rgbSliders[1].getCurrentValue();
        int b = (int)rgbSliders[2].getCurrentValue();
        int brightness = (int)hsbSliders[2].getCurrentValue();

        colorMode(RGB, 255);
        fill(color(r,g,b));
        noStroke();
        rect(width / 2, 14 * height / 20, width, height);
        textSize(20);

        if (brightness > 180) {
            fill(0);
        } else {
            fill(255);
        }

        textAlign(CENTER, CENTER);
        text("R = " + r + "; G = " + g  + "; B = " + b, 3 * width / 4, 15 * height / 20);
    }

    private boolean isActive_HSB() {
        boolean isActive = false;

        for (HorizontalSlider slider: hsbSliders) {

            if (slider.isActive()) {
                isActive = true;
                break;
            }
        }

        return isActive;
    }

    private boolean isActive_RGB() {
        boolean isActive = false;

        for (HorizontalSlider slider: rgbSliders) {

            if (slider.isActive()) {
                isActive = true;
                break;
            }
        }

        return isActive;
    }

    private void setRGBSliders() {
        colorMode(HSB, 360);
        int h = (int)hsbSliders[0].getCurrentValue();
        int s = (int)hsbSliders[1].getCurrentValue();
        int b = (int)hsbSliders[2].getCurrentValue();
        int color = color(h, s, b);
        colorMode(RGB, 255);
        int red = (int)red(color);
        int green = (int)green(color);
        int blue = (int)blue(color);
        rgbSliders[0].setCurrentValue(red);
        rgbSliders[1].setCurrentValue(green);
        rgbSliders[2].setCurrentValue(blue);
    }

    private void setHSBSliders() {
        colorMode(RGB, 255);
        int r = (int)rgbSliders[0].getCurrentValue();
        int g = (int)rgbSliders[1].getCurrentValue();
        int b = (int)rgbSliders[2].getCurrentValue();
        int color = color(r, g, b);
        colorMode(HSB, 360);
        int hue = (int)hue(color);
        int saturation = (int)saturation(color);
        int brightness = (int)brightness(color);
        hsbSliders[0].setCurrentValue(hue);
        hsbSliders[1].setCurrentValue(saturation);
        hsbSliders[2].setCurrentValue(brightness);
    }

}
