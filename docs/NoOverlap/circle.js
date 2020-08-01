class Circle {

    constructor() {
        this.position = createVector(random(width), random(height));
        this.radius = random(1, 50);
        this.color = new Color(color(0, 0, 255));
    }

    setColor(color) {
        this.color.setColor(color);
    }

    display() {
        fill(this.color.getColor());
        noStroke();
        ellipse(this.position.x, this.position.y, this.radius * 2, this.radius * 2);
    }

}
