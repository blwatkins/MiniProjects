package color.HSB;

import processing.core.PApplet;

public class RainbowColorGenerator extends HSBColorGenerator {

    public RainbowColorGenerator(PApplet p) {
        super(p);
    }

    public int mapColor(float value, float minValue, float maxValue, int saturation, int brightness) {
        p.colorMode(p.HSB, 360);
        int hue = (int) PApplet.map(value, minValue, maxValue, 0, 360);
        return p.color(hue, saturation, brightness);
    }

}
