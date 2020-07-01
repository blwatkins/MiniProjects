package color.HSB;

import processing.core.PApplet;

import color.ColorGenerator;

public abstract class HSBColorGenerator extends ColorGenerator {

    public HSBColorGenerator(PApplet p) {
        super(p);
    }

    public int getRandomColor() {
        p.colorMode(PApplet.HSB, 360);
        int saturation = (int)p.random(100, 360);
        int brightness = (int)p.random(100, 360);
        int hue = (int)p.random(360);
        return mapColor(hue, 0, 360, saturation, brightness);
    }

}
