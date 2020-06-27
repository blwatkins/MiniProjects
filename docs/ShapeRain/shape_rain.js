// Shape Rain sketch
// Press 's' to make shapes move

var shapes;
var n;
var isMoving;
var hasBlackBackground;

function setup() {
    createCanvas(windowWidth-20, windowHeight-20);
    frameRate(60);
    shapes = [];
    n = 0;
    isMoving = false;
    hasBlackBackground = true;
}

function draw() {
    displayBackground();
    addShape();
    displayShapes();
    moveShapes();
    incrementN();
}

function keyTyped() {

    if (key == 'a') {
        hasBlackBackground = !hasBlackBackground
    } else if (key == 's') {
        isMoving = !isMoving;
    }
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
    let shape = new Circle(position, radius);
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

function incrementN() {
    n += 0.01;

    if (n > 50000) {
        n = 0;
    }
}
