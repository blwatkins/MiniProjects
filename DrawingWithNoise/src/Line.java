import processing.core.PApplet;
import processing.core.PVector;

public class Line {

    private PApplet p;
    private PVector start;
    private PVector end;
    private int color;

    public Line(PApplet p) {
        init(p);
    }

    public Line(PApplet p, float startX, float startY, float endX, float endY) {
        init(p);
        start.set(startX, startY);
        end.set(endX, endY);
    }

    public Line(PApplet p, Point start, Point end) {
       init(p);
       this.start.set(start.getPosition());
       this.end.set(end.getPosition());
    }

    public void setColor(int color) {
        int r = (int)p.red(color);
        int g = (int)p.green(color);
        int b = (int)p.blue(color);
        int a = (int)p.alpha(this.color);
        this.color = p.color(r, g, b, a);
    }

    private void init(PApplet p) {
        this.p = p;
        start = new PVector();
        end = new PVector();
        color = p.color(255, 0, 0, 255);
    }

    public void display() {
        p.stroke(color);
        p.line(start.x, start.y, end.x, end.y);
        fade();
    }

    private void fade() {
        int red = (int)p.red(color);
        int green = (int)p.green(color);
        int blue = (int)p.blue(color);
        int alpha = (int)p.alpha(color);
        alpha--;
        alpha = PApplet.constrain(alpha, 0, 255);
        color = p.color(red, green, blue, alpha);
    }

    public boolean isFaded() {
        int alpha = (int)p.alpha(color);
        return alpha == 0;
    }

}
