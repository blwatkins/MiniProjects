// ColorGenerator Class
package color;

import processing.core.PApplet;

public abstract class ColorGenerator {
    protected PApplet p;

    public ColorGenerator(PApplet p) {
        this.p = p;
    }

    public abstract int randomColor();

    public abstract int mapColor(float value, float minValue, float maxValue, int saturation, int brightness);
}
