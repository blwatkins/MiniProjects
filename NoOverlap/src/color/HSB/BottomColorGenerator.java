package color.HSB;

import processing.core.PApplet;

public class BottomColorGenerator extends HSBColorGenerator {

    public BottomColorGenerator(PApplet p) {
        super(p);
    }

    public int mapColor(float value, float minValue, float maxValue, int saturation, int brightness) {
        p.colorMode(PApplet.HSB, 360);
        int hue = (int) PApplet.map(value, minValue, maxValue, 0, 180);
        return p.color(hue, saturation, brightness);
    }

}
