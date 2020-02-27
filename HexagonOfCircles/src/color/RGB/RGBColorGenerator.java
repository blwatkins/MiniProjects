package color.RGB;

import processing.core.PApplet;

import color.ColorGenerator;

public class RGBColorGenerator extends ColorGenerator {

    public RGBColorGenerator(PApplet p) {
        super(p);
    }

    public int mapColor(float value, float minValue, float maxValue, int saturation, int brightness) {
        p.colorMode(p.RGB, 255);
        int r = (int)p.random(255);
        int g = (int)p.random(255);
        int b = (int)p.random(255);
        return p.color(r, g, b);
    }

    public int randomColor() {
        int r;
        int g;
        int b;
        p.colorMode(p.RGB, 255);

        switch (colorType) {
            case RED:
                r = (int)p.random(100, 255);
                g = (int)p.random(50, 100);
                b = (int)p.random(50, 100);
                break;
            case YELLOW:
                r = (int)p.random(100, 255);
                g = (int)p.random(100, 255);
                b = (int)p.random(50, 100);
                break;
            case GREEN:
                r = (int)p.random(50, 100);
                g = (int)p.random(100, 255);
                b = (int)p.random(50, 100);
                break;
            case CYAN:
                r = (int)p.random(50, 100);
                g = (int)p.random(100, 255);
                b = (int)p.random(100, 255);
                break;
            case MAGENTA:
                r = (int)p.random(100, 255);
                g = (int)p.random(50, 100);
                b = (int)p.random(100, 255);
                break;
            default:
                r = (int)p.random(255);
                g = (int)p.random(255);
                b = (int)p.random(255);
                break;
        }

        return p.color(r, g, b);
    }

}
