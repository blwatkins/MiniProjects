class RGBColorGenerator {

    randomColor() {
        colorMode(RGB, 255);
        return color(0);
    }

    mapColor(value, minValue, maxValue, saturation, brightness) {
        return this.randomColor();
    }
}
