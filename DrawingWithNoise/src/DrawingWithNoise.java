// Main Class
// Drawing With Noise
// Started: 6 August 2019
// Press 'a' to change background color
// Press 's' to randomly change color type
// Press 'd' to turn glow effect on and off

import java.util.ArrayList;
import processing.core.PApplet;


public class DrawingWithNoise extends PApplet{

    private ArrayList<Line> lines;
    private ArrayList<Point> points;
    private float meshSize;
    private float n;
    private Color color;
    private boolean glow;
    private float timer;
    private float timerMax;
    private boolean blackBG;

    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "DrawingWithNoise" };  // first string MUST match name of class

        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }

    }

    public void settings() {
        fullScreen(P2D);
    }

    public void setup() {
        lines = new ArrayList<>();
        points = new ArrayList<>();
        meshSize = 50;
        n = 0;
        color = new Color(this);
        glow = false;
        timer = 0;
        timerMax = 500;
        blackBG = true;
    }

    public void draw() {

        if (blackBG) {
            background(0);
        } else {
            background(255);
        }

        if (glow) {
            blendMode(ADD);
        } else {
            blendMode(BLEND);
        }

        float x = random(mouseX - meshSize, mouseX + meshSize);
        float y = random(mouseY - meshSize, mouseY + meshSize);
        Point p = new Point(this, x, y);
        int col = getColor();
        p.setColor(col);
        points.add(p);
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
        n = (n + 0.01f) % 50000f;
        timer = (timer + 0.1f) % timerMax;
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
                    Line line = new Line(this, lastPoint, point);
                    int c = getColor();
                    line.setColor(c);
                    lines.add(line);
                }
            }
        }
    }

    private boolean isPointIntersectingCircle(Point a, Point b) {
        boolean isIntersectingPoint = false;
        float diameter = a.distance(b);
        Point center = createCenterPoint(a, b);

        for (Point compare: points) {

            if (compare != a && compare != b && compare.getAlpha() > 200) {
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

    public void keyPressed() {

        if (key == 'a') {
            blackBG = !blackBG;

            if (!blackBG) {
                glow = false;
            }

        } else if (key == 's') {
            color.setRandomColorType();

        } else if (key == 'd') {

            if (blackBG) {
                glow = !glow;
            }
        }
    }

    public int getColor() {
        int col = color(255);

        if (color.isRGB()) {
            colorMode(RGB, 255);
            col = color.randomColor();
        } else if (color.isHSB()) {
            colorMode(HSB, 360);
            col = color.mapColor(timer, 0, timerMax, 360, 360);
        }

        return col;
    }
}
