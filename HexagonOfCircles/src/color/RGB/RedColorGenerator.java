package color.RGB;

import processing.core.PApplet;

public class RedColorGenerator extends RGBColorGenerator {

    public RedColorGenerator(PApplet p) {
        super(p);
    }

    public int randomColor() {
        p.colorMode(p.RGB, 255);
        int r = (int)p.random(100, 255);
        int g = (int)p.random(50, 100);
        int b = (int)p.random(50, 100);
        return p.color(r, g, b);
    }

}
