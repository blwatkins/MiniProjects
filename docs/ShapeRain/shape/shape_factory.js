class ShapeFactory {

    constructor() {
        this._circle = 0;
        this._polygon = 1;
        this.type = this._circle;
        this.sideCount = 0;
        this.randomize();
    }

    getShape(position, radius) {
        let shape = null;

        if (this.type === this._circle) {
            shape = new Circle(position, radius)
        } else {
            shape = new Polygon(position, radius, this.sideCount);
        }

        return shape;
    }

    randomize() {
        let r = int(random(200));

        switch (r % 2) {
            case 1: 
                this.type = this._circle;
                break;
            default:
                this.type = this._polygon;
                break;
        }

        this.sideCount = int(random(3, 10));
    }
}
