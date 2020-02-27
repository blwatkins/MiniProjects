package color.RGB;

import processing.core.PApplet;

import color.ColorGenerator;

public abstract class RGBColorGenerator extends ColorGenerator {

    public RGBColorGenerator(PApplet p) {
        super(p);
    }

    public int mapColor(float value, float minValue, float maxValue, int saturation, int brightness) {
        p.colorMode(p.RGB, 255);
        int r = (int)p.random(255);
        int g = (int)p.random(255);
        int b = (int)p.random(255);
        return p.color(r, g, b);
    }

}
