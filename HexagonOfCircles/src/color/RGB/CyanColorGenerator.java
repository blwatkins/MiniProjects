package color.RGB;

import processing.core.PApplet;

public class CyanColorGenerator extends RGBColorGenerator {

    public CyanColorGenerator(PApplet p) {
        super(p);
    }

    public int randomColor() {
        p.colorMode(p.RGB, 255);
        int r = (int)p.random(50, 100);
        int g = (int)p.random(100, 255);
        int b = (int)p.random(100, 255);
        return p.color(r, g, b);
    }

}
