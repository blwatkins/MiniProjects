class ColorGeneratorFactory {

    randomColorGenerator() {
        let r = int(random(300));
        let colorGenerator = null;

        switch (r % 3) {
            case 1:
                colorGenerator = new BlackColorGenerator();
                break;
            case 2:
                colorGenerator = new BlueColorGenerator();
                break;
            default:
                colorGenerator = new CyanColorGenerator();
                break;
        }

        return colorGenerator;
    }
}