// Shape Rain sketch
// Press 'a' to change the background to black or white
// Press 's' to make shapes move
// Press 'd' to change the shape type
// Press 'f' to change the color scheme

var shapes;
var shapeFactory;
var colorGeneratorFactory;
var colorGenerator;
var n;
var isMoving;
var hasBlackBackground;


function setup() {
    createCanvas(windowWidth-20, windowHeight-20);
    frameRate(60);
    shapes = [];
    shapeFactory = new ShapeFactory();
    colorGeneratorFactory = new ColorGeneratorFactory();
    colorGenerator = colorGeneratorFactory.getRandomColorGenerator();
    n = 0;
    isMoving = false;
    hasBlackBackground = true;
    createInstructions();
}

function draw() {
    displayBackground();
    addShape();
    displayShapes();
    moveShapes();
    removeFadedShapes();
    incrementN();
}

function keyTyped() {

    if (key === 'a') {
        hasBlackBackground = !hasBlackBackground
    } else if (key === 's') {
        isMoving = !isMoving;
    } else if (key === 'd') {
        shapeFactory.randomize();
    } else if (key === 'f') {
        colorGenerator = colorGeneratorFactory.getRandomColorGenerator();
    }
}

function createInstructions() {
    let div = createElement('div');
    let h1 = createElement('h1', 'Instructions');
    let instructionList = createElement('ul');
    let instructions = [];
    instructions.push(createElement('li', "Press the 'a' key to change the background to black or white"));
    instructions.push(createElement('li', "Press the 's' key to make the shapes move"));
    instructions.push(createElement('li', "Press the 'd' key to change the shape type"));
    instructions.push(createElement('li', "Press the 'f' key to change the color scheme"));
    div.id('instructions');
    h1.parent(div);
    instructionList.parent(div);

    instructions.forEach((instruction) => {
        instruction.parent(instructionList);
    });
}

function displayBackground() {
    noStroke();

    if (hasBlackBackground) {
        fill(0, 50);
    } else {
        fill(255, 50);
    }

    rect(-10, -10, width + 10, height + 10);
}

function addShape() {
    let x = random(width);
    let y = random(height);
    let position = createVector(x, y);
    let radius = (noise(n) * 9.5) + 0.5;
    let color = colorGenerator.randomColor();
    let shape = shapeFactory.getShape(position, radius, color);
    shapes.push(shape);
}

function displayShapes() {
    shapes.forEach((shape) => {
        shape.display();
        shape.fade();
    });
}

function moveShapes() {

    if (isMoving) {
        shapes.forEach((shape) => {
            shape.move();
        });
    }
}

function removeFadedShapes() {
    
    for (let i = shapes.length - 1; i >= 0; i--) {

        if (shapes[i].isFaded()) {
            shapes.splice(i, 1);
        }
    }
}

function incrementN() {
    n += 0.01;

    if (n > 50000) {
        n = 0;
    }
}
