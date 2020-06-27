class Polygon extends Shape {

    constructor(position, radius, sideCount) {
        super(position);
        this.radius = radius;
        this.vertices = [];
        this._initVertices(sideCount);
    }

    _initVertices(sideCount) {
        let theta = 0;
        sideCount = constrain(sideCount, 3, 20);
        let deltaTheta = TWO_PI / sideCount;

        for (let i = 0; i < sideCount; i++) {
            let x = cos(theta) * this.radius;
            let y = sin(theta) * this.radius;
            theta += deltaTheta;
            this.vertices.push(createVector(x, y));
        }
    }

    display() {
        push();
        noStroke();
        fill(this.color.getColor());
        translate(this.position.x, this.position.y);
        beginShape();

        this.vertices.forEach((v) => {
            vertex(v.x, v.y);
        });

        endShape(CLOSE);
        pop();
    }
}