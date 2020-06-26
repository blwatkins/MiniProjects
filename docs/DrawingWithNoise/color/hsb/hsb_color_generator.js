class HSBColorGenerator {

    randomColor() {
        colorMode(HSB, 360);
        let saturation = int(random(100, 360));
        let brightness = int(random(100, 360));
        let hue = int(random(360));
        let color = this.mapColor(hue, 0, 360, saturation, brightness);
        return color;
    }

    mapColor(value, minValue, maxValue, saturation, brightness) {
        colorMode(HSB, 360);
        return color(0);
    }

}
