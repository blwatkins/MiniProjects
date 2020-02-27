package color.RGB;

import processing.core.PApplet;

import color.ColorGenerator;

public abstract class RGBColorGenerator extends ColorGenerator {

    public RGBColorGenerator(PApplet p) {
        super(p);
    }

    public int mapColor(float value, float minValue, float maxValue, int saturation, int brightness) {
        return randomColor();
    }

}
