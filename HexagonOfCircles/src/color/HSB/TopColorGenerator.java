package color.HSB;

import processing.core.PApplet;

public class TopColorGenerator extends HSBColorGenerator {

    public TopColorGenerator(PApplet p) {
        super(p);
    }

    public int mapColor(float value, float minValue, float maxValue, int saturation, int brightness) {
        p.colorMode(p.HSB, 360);
        int hue = (int)PApplet.map(value, minValue, maxValue, 180, 360);
        return p.color(hue, saturation, brightness);
    }

}
