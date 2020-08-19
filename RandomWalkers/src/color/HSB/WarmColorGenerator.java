package color.HSB;

import processing.core.PApplet;

public class WarmColorGenerator extends HSBColorGenerator {

    public WarmColorGenerator(PApplet p) {
        super(p);
    }

    public int mapColor(float value, float minValue, float maxValue, int saturation, int brightness) {
        p.colorMode(PApplet.HSB, 360);
        int hue = (int)PApplet.map(value, minValue, maxValue, 0, 70);
        return p.color(hue, saturation, brightness);
    }

}
