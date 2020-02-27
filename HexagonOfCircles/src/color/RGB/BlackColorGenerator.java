package color.RGB;

import processing.core.PApplet;

public class BlackColorGenerator extends RGBColorGenerator {

    public BlackColorGenerator(PApplet p) {
        super(p);
    }

    public int randomColor() {
        p.colorMode(p.RGB, 255);
        int grey = (int)p.random(100);
        return p.color(grey);
    }

}
