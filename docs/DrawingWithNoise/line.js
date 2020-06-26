// Line Class

class Line {

    constructor(start, end) {
        this.start = createVector(start.getX(), start.getY());
        this.end = createVector(end.getX(), end.getY());
        this.color = color(255, 0, 0);
    }

    setColor(color) {
        this.color = color;
    }

    display() {
        stroke(this.color);
        line(this.start.x, this.start.y, this.end.x, this.end.y);
        this.fade();
    }

    fade() {
        let alphaValue = alpha(this.color);
        alphaValue += deltaAlpha;
        alphaValue = constrain(alphaValue, 0, 255);
        this.color.setAlpha(alphaValue);
    }

    isFaded() {
        let alphaValue = alpha(this.color);
        return alphaValue <= 0;
    }
}
