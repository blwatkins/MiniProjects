package shape;

import color.Color;
import processing.core.PApplet;
import processing.core.PVector;

public abstract class Shape {
    protected PApplet p;
    protected PVector position;
    protected Color color;

    public Shape(PApplet p, PVector position) {
        this.p = p;
        this.position = position.copy();
        color = new Color(p, p.color(0, 0, 255));
    }

    public void setColor(int c) {
        p.colorMode(p.RGB, 255);
        int red = (int)p.red(c);
        int green = (int)p.green(c);
        int blue = (int)p.blue(c);
        color.setRed(red);
        color.setGreen(green);
        color.setBlue(blue);
    }

    public abstract void display();

    public void move() {
        position.y++;
    }

    public void fade() {
        color.setAlpha(color.getAlpha() - 1);
    }

    public boolean isFaded() {
        return color.getAlpha() == 0;
    }
}
