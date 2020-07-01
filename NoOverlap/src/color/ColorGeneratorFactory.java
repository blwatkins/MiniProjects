package color;

import processing.core.PApplet;

import color.HSB.*;
import color.RGB.*;


public class ColorGeneratorFactory {
    private PApplet p;

    public ColorGeneratorFactory(PApplet p) {
        this.p = p;
    }

    public ColorGenerator getRandomColorGenerator() {
        ColorGenerator colorGenerator;
        int random = (int)p.random(1400);

        switch(random % 14) {
            case 1:
                colorGenerator = new BlackColorGenerator(p);
                break;
            case 2:
                colorGenerator = new BlueColorGenerator(p);
                break;
            case 3:
                colorGenerator = new CyanColorGenerator(p);
                break;
            case 4:
                colorGenerator = new GreenColorGenerator(p);
                break;
            case 5:
                colorGenerator = new MagentaColorGenerator(p);
                break;
            case 6:
                colorGenerator = new RedColorGenerator(p);
                break;
            case 7:
                colorGenerator = new WhiteColorGenerator(p);
                break;
            case 8:
                colorGenerator = new YellowColorGenerator(p);
                break;
            case 9:
                colorGenerator = new BottomColorGenerator(p);
                break;
            case 10:
                colorGenerator = new CoolColorGenerator(p);
                break;
            case 11:
                colorGenerator = new RainbowColorGenerator(p);
                break;
            case 12:
                colorGenerator = new TopColorGenerator(p);
                break;
            case 13:
                colorGenerator = new WarmColorGenerator(p);
                break;
            default:
                colorGenerator = new RandomColorGenerator(p);
                break;
        }

        return colorGenerator;
    }

}
