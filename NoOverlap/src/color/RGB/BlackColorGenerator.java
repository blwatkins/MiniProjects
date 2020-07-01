package color.RGB;

import processing.core.PApplet;

public class BlackColorGenerator extends RGBColorGenerator {

    public BlackColorGenerator(PApplet p) {
        super(p);
    }

    public int getRandomColor() {
        p.colorMode(PApplet.RGB, 255);
        int grey = (int)p.random(100);
        return p.color(grey);
    }

}
