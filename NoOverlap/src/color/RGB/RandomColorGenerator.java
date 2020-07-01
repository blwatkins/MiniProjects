package color.RGB;

import processing.core.PApplet;

public class RandomColorGenerator extends RGBColorGenerator {

    public RandomColorGenerator(PApplet p) {
        super(p);
    }

    public int getRandomColor() {
        p.colorMode(PApplet.RGB, 255);
        int r = (int)p.random(255);
        int g = (int)p.random(255);
        int b = (int)p.random(255);
        return p.color(r, g, b);
    }

}
