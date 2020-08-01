// No Overlap Sketch

var circles;

function setup() {
    createCanvas(windowWidth-20, windowHeight-20);
    frameRate(60);
    circles = [];
}

function draw() {
    background(0);
    displayCircles();
}

function keyTyped() {
    circles.push(new Circle());
}

function displayCircles() {
    circles.forEach((circle) => {
        circle.display();
    })
}
