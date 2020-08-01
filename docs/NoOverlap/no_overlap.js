// No Overlap Sketch

var circles;

function setup() {
    createCanvas(windowWidth-20, windowHeight-20);
    frameRate(60);
    circles = [];
}

function draw() {
    ellipse(mouseX, mouseY, 50, 50);
}
