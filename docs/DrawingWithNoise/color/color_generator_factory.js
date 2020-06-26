class ColorGeneratorFactory {

    randomColorGenerator() {
        let r = int(random(400));
        let colorGenerator = null;

        switch (r % 4) {
            case 1:
                colorGenerator = new BlackColorGenerator();
                break;
            case 2:
                colorGenerator = new BlueColorGenerator();
                break;
            case 3:
                colorGenerator = new CyanColorGenerator();
                break;
            default:
                colorGenerator = new GreenColorGenerator();
                break;
        }

        return colorGenerator;
    }
}