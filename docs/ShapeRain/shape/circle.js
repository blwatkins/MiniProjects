class Circle extends Shape {

    constructor(position, radius) {
        super(position);
        this.radius = radius;
    }

    display() {
        noStroke();
        fill(this.color.getColor());
        pushMatrix();
        translate(this.position.x, this.position.y);
        ellipse(0, 0, this.radius * 2, this.radius * 2);
        popMatrix();
    }
}
