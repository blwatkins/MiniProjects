package color.RGB;

import processing.core.PApplet;

public class GreenColorGenerator extends RGBColorGenerator {

    public GreenColorGenerator(PApplet p) {
        super(p);
    }

    public int getRandomColor() {
        p.colorMode(PApplet.RGB, 255);
        int r = (int)p.random(50, 100);
        int g = (int)p.random(100, 255);
        int b = (int)p.random(50, 100);
        return p.color(r, g, b);
    }

}
