class WarmColorGenerator extends HSBColorGenerator {

    mapColor(value, minValue, maxValue, saturation, brightness) {
        colorMode(HSB, 360);
        let hue = int(map(value, minValue, maxValue, 0, 70));
        return color(hue, saturation, brightness);
    }
}