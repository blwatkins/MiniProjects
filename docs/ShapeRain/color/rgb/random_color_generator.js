class RandomColorGenerator extends RGBColorGenerator {

    randomColor() {
        colorMode(RGB, 255);
        let r = int(random(255));
        let g = int(random(255));
        let b = int(random(255));
        return color(r, g, b);
    }
}
