// Main Class
// Drawing With Noise
// Started: 6 August 2019


import java.util.ArrayList;
import processing.core.PApplet;


public class DrawingWithNoise extends PApplet{

    private ArrayList<Line> lines;
    private ArrayList<Point> points;

    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "DrawingWithNoise" };  // first string MUST match name of class

        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        lines = new ArrayList<>();
        points = new ArrayList<>();
    }

    public void draw() {
        background(200);
        float diam = 50;
        float x = random(mouseX - diam, mouseX + diam);
        float y = random(mouseY - diam, mouseY + diam);
        points.add(new Point(this, x, y));
        addLines();
        lines.add(new Line(this, pmouseX, pmouseY, mouseX, mouseY));

        for (Line line: lines) {
            line.display();
        }

        for (Point point: points) {
            point.display();
        }

        removeFadedLines();
        removeFadedPoints();
    }

    private void removeFadedLines() {
        ArrayList<Line> toRemove = new ArrayList<>();

        for (Line line: lines) {

            if (line.isFaded()) {
                toRemove.add(line);
            }
        }

        for (Line line: toRemove) {
            lines.remove(line);
        }
    }

    private void removeFadedPoints() {
        ArrayList<Point> toRemove = new ArrayList<>();

        for (Point point: points) {

            if (point.isFaded()) {
                toRemove.add(point);
            }
        }

        for (Point point: toRemove) {
            points.remove(point);
        }
    }

    private void addLines() {

    }


}
