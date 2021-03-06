class Circle extends Shape {

    constructor(position, color, radius) {
        super(position, color);
        this.radius = radius;
    }

    display() {
        push();
        noStroke();
        fill(this.color.getColor());
        translate(this.position.x, this.position.y);
        ellipse(0, 0, this.radius * 2, this.radius * 2);
        pop();
    }
}
