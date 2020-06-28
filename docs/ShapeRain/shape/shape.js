class Shape {

    constructor(position, color) {
        this.position = createVector(position.x, position.y);
        this.color = new Color(color);
        this.speedY = random(0, 2);
    }

    display() {

    }

    move() {
        this.position.y += this.speedY;
    }

    fade() {
        this.color.setAlpha(this.color.getAlpha() - 1);
    }

    isFaded() {
        return this.color.getAlpha() <= 0;
    }
}
