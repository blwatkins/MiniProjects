class ColorGeneratorFactory {

    randomColorGenerator() {
        let r = int(random(200));
        let colorGenerator = null;

        if (r % 2 == 0) {
            colorGenerator = new BlackColorGenerator();
        } else {
            colorGenerator = new BlueColorGenerator();
        }

        return colorGenerator;
    }
}