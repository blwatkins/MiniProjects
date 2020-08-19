package color.RGB;

import processing.core.PApplet;

public class WhiteColorGenerator extends RGBColorGenerator {

    public WhiteColorGenerator(PApplet p) {
        super(p);
    }

    public int getRandomColor() {
        p.colorMode(PApplet.RGB, 255);
        int grey = (int)p.random(100, 255);
        return p.color(grey);
    }

}
