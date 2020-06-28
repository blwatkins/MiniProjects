class ShapeFactory {

    constructor() {
        this._circle = 0;
        this._polygon = 1;
        this._star = 2;
        this.type = this._circle;
        this.sideCount = 0;
        this.randomize();
    }

    getShape(position, radius) {
        let shape = null;

        if (this.type === this._circle) {
            shape = new Circle(position, radius)
        } else if (this.type === this._polygon) {
            shape = new Polygon(position, radius, this.sideCount);
        } else {
            shape = new Star(position, radius, this.sideCount);
        }

        return shape;
    }

    randomize() {
        let r = int(random(300));

        switch (r % 3) {
            case 1: 
                this.type = this._circle;
                break;
            case 2:
                this.type = this._star;
                break;
            default:
                this.type = this._polygon;
                break;
        }

        this.sideCount = int(random(3, 10));
    }
}
