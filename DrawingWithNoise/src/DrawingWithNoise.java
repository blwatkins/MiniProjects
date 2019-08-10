// Main Class
// Drawing With Noise
// Started: 6 August 2019


import java.util.ArrayList;
import processing.core.PApplet;


public class DrawingWithNoise extends PApplet{

    private ArrayList<Line> lines;
    private ArrayList<Point> points;
    private float meshSize;
    private float n;

    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "DrawingWithNoise" };  // first string MUST match name of class

        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }
    }

    public void settings() {
        size(800, 800, P2D);
    }

    public void setup() {
        lines = new ArrayList<>();
        points = new ArrayList<>();
        meshSize = 50;
        n = 0;
    }

    public void draw() {
        background(200);
        float x = random(mouseX - meshSize, mouseX + meshSize);
        float y = random(mouseY - meshSize, mouseY + meshSize);
        points.add(new Point(this, x, y));
        addLines();

        for (Line line: lines) {
            line.display();
        }

        for (Point point: points) {
            point.display();
        }

        removeFadedLines();
        removeFadedPoints();
        meshSize = noise(n) * min(width, height) / 8;
        n += 0.01;

        if (n > 50000) {
            n = 0;
        }
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
        int lastIndex = points.size() - 1;
        Point lastPoint = points.get(lastIndex);

        for (int i = 0; i < lastIndex; i++) {
            Point point = points.get(i);

            if (point.getAlpha() > 200) {

                if (!isPointIntersectingCircle(lastPoint, point)) {
                    lines.add(new Line(this, lastPoint, point));
                }
            }
        }
    }

    private boolean isPointIntersectingCircle(Point a, Point b) {
        boolean isIntersectingPoint = false;
        float diameter = a.distance(b);
        Point center = createCenterPoint(a, b);

        for (Point compare: points) {

            if (compare != a && compare != b) {
                float distance = compare.distance(center);

                if (distance < diameter / 2) {
                    isIntersectingPoint = true;
                    break;
                }
            }
        }

        return  isIntersectingPoint;
    }

    private Point createCenterPoint(Point a, Point b) {
        float centerX = (a.getPosition().x + b.getPosition().x) / 2;
        float centerY = (a.getPosition().y + b.getPosition().y) / 2;
        Point center = new Point(this, centerX, centerY);
        return center;
    }

}
