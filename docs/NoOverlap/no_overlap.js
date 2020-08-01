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
    createInstructions();
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

function createInstructions() {
    let div = createElement('div');
    let h1 = createElement('h1', 'Instructions');
    let instructionList = createElement('ul');
    let instructions = [];
    instructions.push(createElement('li', "Press the 'a' key to clear the circles"));
    instructions.push(createElement('li', "Press the 's' key to change the color scheme"));
    div.id('instructions');
    h1.parent(div);
    instructionList.parent(div);

    instructions.forEach((instruction) => {
        instruction.parent(instructionList);
    });
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
