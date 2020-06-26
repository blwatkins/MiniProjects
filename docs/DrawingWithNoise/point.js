// Point Class

class Point {

    constructor(x, y) {
        this.position = createVector(x, y);
        this.color = color(0, 0, 255);
    }

    getAlpha() {
        return int(alpha(this.color));
    }

    getX() {
        return this.position.x;
    }

    getY() {
        return this.position.y;
    }

    setColor(color) {
        this.color = color;
    }

    distance(point) {
        let x1 = this.position.x;
        let y1 = this.position.y;
        let x2 = point.position.x;
        let y2 = point.position.y;
        return dist(x1, y1, x2, y2);
    }

    display() {
        stroke(this.color);
        fill(this.color);
        ellipse(this.position.x, this.position.y, 3, 3);
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
