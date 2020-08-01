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
        ellipse(position.x, position.y, radius * 2, radius * 2);
    }

}
