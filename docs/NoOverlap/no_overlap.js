// No Overlap Sketch
// Press 'a' to clear the circles
// Press 's' to change the color scheme

var circles;
var colorGeneratorFactory;
var colorGenerator;

function setup() {
    createCanvas(windowWidth-20, windowHeight-20);
    frameRate(60);
    circles = [];
    colorGeneratorFactory = new ColorGeneratorFactory();
    colorGenerator = colorGeneratorFactory.getRandomColorGenerator();
}

function draw() {
    background(0);
    addCircle();
    displayCircles();
}

function keyTyped() {

    if (key == 'a') {
        circles.splice(0, circles.length);
    } else if (key == 's') {
        changeColorScheme();
    }
}

function addCircle() {
    let potentialCircle = new Circle();
    let isOverlapping = false;

    circles.forEach((circle) => {

        if (potentialCircle.isOverlapping(circle)) {
            isOverlapping = true;
        }
    });

    if (!isOverlapping) {
        let color = colorGenerator.randomColor();
        potentialCircle.setColor(color);
        circles.push(potentialCircle);
    }
}

function displayCircles() {

    circles.forEach((circle) => {
        circle.display();
    });
}

function changeColorScheme() {
    colorGenerator = colorGeneratorFactory.getRandomColorGenerator();

    circles.forEach((circle) => {
        let color = colorGenerator.randomColor();
        circle.setColor(color);
    });
}
