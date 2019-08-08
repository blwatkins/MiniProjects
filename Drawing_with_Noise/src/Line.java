import processing.core.PApplet;
import processing.core.PVector;

public class Line {

    private PApplet p;
    private PVector start;
    private PVector end;

    public Line(PApplet p) {
        init(p);
    }

    public Line(PApplet p, PVector start, PVector end) {
        init(p);
        start.set(start);
        end.set(end);
    }

    public Line(PApplet p, Point start, Point end) {
       init(p);
       this.start.set(start.getPosition());
       this.end.set(end.getPosition());
    }

    private void init(PApplet p) {
        this.p = p;
        start = new PVector();
        end = new PVector();
    }

}
