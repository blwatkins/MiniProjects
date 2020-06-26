class Shape {

    constructor(position) {
        this.position = createVector(position.x, position.y);
        this.color = new Color(color(0, 0, 255));
    }

    display() {

    }

    move() {
        this.position.y++;
    }

    fade() {
        this.color.setAlpha(this.color.getAlpha() - 1);
    }

    isFaded() {
        this.color.getAlpha() <= 0;
    }
}
