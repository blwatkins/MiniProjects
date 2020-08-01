class Circle {

    constructor() {
        this.position = createVector(random(width), random(height));
        this.radius = random(1, 50);
        this.color = new Color(color(0, 0, 255));
    }

    getPosition() {
        return this.position;
    }

    getRadius() {
        return this.radius;
    }

    setColor(color) {
        this.color.setColor(color);
    }

    display() {
        fill(this.color.getColor());
        noStroke();
        ellipse(this.position.x, this.position.y, this.radius * 2, this.radius * 2);
    }

    isOverlapping(circle) {
        let distance = dist(this.position.x, this.position.y, circle.getPosition().x, circle.getPosition().y);
        return distance < this.radius + circle.getRadius();
    }

}
