class Shape {

    constructor(position) {
        this.position = createVector(position.x, position.y);
        this.color = new Color(color(0, 0, 255));
        this.speedY = random(0, 2);
    }

    display() {
        console.log('Nothing');
    }

    move() {
        this.position.y += this.speedY;
    }

    fade() {
        this.color.setAlpha(this.color.getAlpha() - 1);
    }

    isFaded() {
        this.color.getAlpha() <= 0;
    }
}
