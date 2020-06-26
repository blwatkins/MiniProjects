class ColorGeneratorFactory {

    randomColorGenerator() {
        let r = int(random(800));
        let colorGenerator = null;

        switch (r % 8) {
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
            case 5:
                colorGenerator = new MagentaColorGenerator();
                break;
            case 6:
                colorGenerator = new RedColorGenerator();
                break;
            case 7:
                colorGenerator = new WhiteColorGenerator();
                break;
            default:
                colorGenerator = new RandomColorGenerator();
                break;
        }

        return colorGenerator;
    }
}