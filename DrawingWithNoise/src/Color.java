// Color Class

import processing.core.PApplet;

import java.util.Random;

public class Color {
    private PApplet p;
    private ColorType colorType;

    public enum ColorType {
        RAINBOW,
        SOFT,
        WARM,
        TOPCOL,
        BOTTOMCOL,
        RANDOM,
        RED,
        YELLOW,
        GREEN,
        CYAN,
        BLUE,
        MAGENTA,
        WHITE,
        BLACK
    };

    public Color(PApplet p) {
        this.p = p;
        setRandomColorType();
    }

    public boolean isHSB() {
        boolean rainbow = colorType == ColorType.RAINBOW;
        boolean soft = colorType == ColorType.SOFT;
        boolean warm = colorType == ColorType.WARM;
        boolean top = colorType == ColorType.TOPCOL;
        boolean bottom = colorType == ColorType.BOTTOMCOL;
        return rainbow || soft || warm || top || bottom;
    }

    public void setColorType(ColorType colorType) {
        this.colorType = colorType;
    }

    public void setRandomColorType() {
        int rand = (int)p.random(1400);

        switch (rand % 14) {
            case 1:
                colorType = ColorType.SOFT;
                break;
            case 2:
                colorType = ColorType.WARM;
                break;
            case 3:
                colorType = ColorType.TOPCOL;
                break;
            case 4:
                colorType = ColorType.BOTTOMCOL;
                break;
            case 5:
                colorType = ColorType.RANDOM;
                break;
            case 6:
                colorType = ColorType.RED;
                break;
            case 7:
                colorType = ColorType.YELLOW;
                break;
            case 8:
                colorType = ColorType.GREEN;
                break;
            case 9:
                colorType = ColorType.CYAN;
                break;
            case 10:
                colorType = ColorType.BLUE;
                break;
            case 11:
                colorType = ColorType.MAGENTA;
                break;
            case 12:
                colorType = ColorType.WHITE;
                break;
            case 13:
                colorType = ColorType.BLACK;
                break;
            default:
                colorType = ColorType.RAINBOW;
                break;
        }
    }

    public int mapColor(float value, float minValue, float maxValue, int saturation, int brightness) {
        int hue = 0;
        p.colorMode(p.HSB, 360);

        switch (colorType) {
            case RAINBOW:
                hue = (int)PApplet.map(value, minValue, maxValue, 0, 360);
                break;
            case SOFT:
                hue = (int)PApplet.map(value, minValue, maxValue, 90, 285);
                break;
            case WARM:
                hue = (int)PApplet.map(value, minValue, maxValue, 0, 70);
                break;
            case TOPCOL:
                hue = (int)PApplet.map(value, minValue, maxValue, 180, 360);
                break;
            case BOTTOMCOL:
                hue = (int)PApplet.map(value, minValue, maxValue, 0, 180);
                break;
            default:
                hue = 0;
                break;
        }

        return p.color(hue, saturation, brightness);
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
            case BLUE:
                r = (int)p.random(50, 100);
                g = (int)p.random(50, 100);
                b = (int)p.random(100, 255);
                break;
            case MAGENTA:
                r = (int)p.random(100, 255);
                g = (int)p.random(50, 100);
                b = (int)p.random(100, 255);
                break;
            case WHITE:
                r = (int)p.random(100, 255);
                g = (int)p.random(100, 255);
                b = (int)p.random(100, 255);
                break;
            case BLACK:
                r = (int)p.random(0, 100);
                g = (int)p.random(0, 100);
                b = (int)p.random(0, 100);
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
