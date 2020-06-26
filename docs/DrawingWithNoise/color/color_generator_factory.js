class ColorGeneratorFactory {

    randomColorGenerator() {
        let r = int(random(1200));
        let colorGenerator = null;

        switch (r % 12) {
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
            case 8:
                colorGenerator = new YellowColorGenerator();
                break;
            case 9:
                colorGenerator = new BottomColorGenerator();
                break;
            case 10:
                colorGenerator = new RainbowColorGenerator();
                break;
            case 11:
                colorGenerator = new SoftColorGenerator();
                break;
            default:
                colorGenerator = new RandomColorGenerator();
                break;
        }

        return colorGenerator;
    }
}