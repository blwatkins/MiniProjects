// Colorful Bubbles sketch
// An array of multicolored circles that move based on the mouse position

var b;

function setup() {
    createCanvas(windowWidth-20, windowHeight-20);
    b = new Bubble(width / 2, height / 2, color(0, 0, 0));
}

function draw() {
    background(255);
    b.display();
}