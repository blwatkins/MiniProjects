class Star extends Polygon {

    constructor(postition, radius, pointCount) {
        super(postition, radius, pointCount);
    }

    _initVertices(pointCount) {
        let theta = 0;
        pointCount = constrain(pointCount, 3, 20);
        let deltaTheta = TWO_PI / (pointCount * 2);

        for (let i = 0; i < pointCount * 2; i++) {
            let r = this.getRadiusForIndex(i);
            let x = cos(theta) * r;
            let y = sin(theta) * r;
            theta += deltaTheta;
            this.vertices.push(createVector(x, y));
        }
    }

    getRadiusForIndex(index) {
        let r = this.radius;

        if (this.isEven(index)) {
            r /= 2;
        }

        return r;
    }

    isEven(index) {
        return index % 2 === 0;
    }
}
