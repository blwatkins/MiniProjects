class Color {
    
    constructor(color) {
        this.r = 0;
        this.g = 0;
        this.b = 0;
        this.a = 0;
        this._initColor(color);
    }

    getRed() {
        return this.r;
    }

    getGreen() {
        return this.g;
    }

    getBlue() {
        return this.b;
    }

    getAlpha() {
        return this.a;
    }

    setRed(red) {
        this.r = constrain(red, 0, 255);
    }

    setGreen(green) {
        this.g = constrain(green, 0, 255);
    }

    setBlue(blue) {
        this.b = constrain(blue, 0, 255);
    }

    setAlpha(alpha) {
        this.a = constrain(alpha, 0, 255);
    }

    setColor(color) {
        this._initColor(color);
    }

    _initColor(color) {
        colorMode(RGB, 255);
        this.r = int(red(color));
        this.g = int(green(color));
        this.b = int(blue(color));
        this.a = int(alpha(color));
    }

    getColor() {
        colorMode(RGB, 255);
        return color(this.r, this.g, this.b, this.a);
    }
}
