class MagentaColorGenerator extends RGBColorGenerator {

    randomColor() {
        colorMode(RGB, 255);
        let r = int(random(100, 255));
        let g = int(random(50, 100));
        let b = int(random(100, 255));
        return color(r, g, b);
    }
}
