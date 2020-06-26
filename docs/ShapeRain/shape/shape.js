class Shape {

    constructor(position) {
        this.position = createVector(position.x, position.y);
    }

    display() {

    }

    move() {
        this.position.y++;
    }
}
