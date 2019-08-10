// Color Class

import processing.core.PApplet;

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

}
