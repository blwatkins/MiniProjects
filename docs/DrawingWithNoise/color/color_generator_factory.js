class ColorGeneratorFactory {

    randomColorGenerator() {
        let r = int(random(500));
        let colorGenerator = null;

        switch (r % 5) {
            case 1:
                colorGenerator = new BlackColorGenerator();
                break;
            case 2:
                colorGenerator = new BlueColorGenerator();
                break;
            case 3:
                colorGenerator = new CyanColorGenerator();
                break;
            case 4:
                colorGenerator = new GreenColorGenerator();
                break;
            default:
                colorGenerator = new MagentaColorGenerator();
                break;
        }

        return colorGenerator;
    }
}