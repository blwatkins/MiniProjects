class BlackColorGenerator extends RGBColorGenerator {

    randomColor() {
        colorMode(RGB, 255);
        let gray = int(random(100));
        return color(gray);
    }
}
