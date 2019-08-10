// Color Class

import processing.core.PApplet;

public class Color {
    PApplet p;

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
    }

    public ColorType getRandomColorType() {
        int rand = (int)p.random(1400);
        ColorType choice;

        switch (rand % 14) {
            case 1:
                choice = ColorType.SOFT;
                break;
            case 2:
                choice = ColorType.WARM;
                break;
            case 3:
                choice = ColorType.TOPCOL;
                break;
            case 4:
                choice = ColorType.BOTTOMCOL;
                break;
            case 5:
                choice = ColorType.RANDOM;
                break;
            case 6:
                choice = ColorType.RED;
                break;
            case 7:
                choice = ColorType.YELLOW;
                break;
            case 8:
                choice = ColorType.GREEN;
                break;
            case 9:
                choice = ColorType.CYAN;
                break;
            case 10:
                choice = ColorType.BLUE;
                break;
            case 11:
                choice = ColorType.MAGENTA;
                break;
            case 12:
                choice = ColorType.WHITE;
                break;
            case 13:
                choice = ColorType.BLACK;
                break;
            default:
                choice = ColorType.RAINBOW;
                break;
        }

        return choice;
    }

}
