// Shape Rain sketch

var shapes;
var n;

function setup() {
    createCanvas(windowWidth-20, windowHeight-20);
    frameRate(60);
    shapes = [];
    n = 0;
}

function draw() {
    background(255);
    addShape();
    displayShapes();
    incrementN();
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

function incrementN() {
    n += 0.01;

    if (n > 50000) {
        n = 0;
    }
}
