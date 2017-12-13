// Colorful Bubbles sketch
// An array of multicolored circles that move based on the mouse position
// Press any key to add or take away trails

var bubbles = [];
var trails = true;

function setup() {
    createCanvas(windowWidth-20, windowHeight-20);
    var colors = getColorNames();
    var colDivisions = colors.length;
    var rowDivisions = height / colDivisions;

    for (var i = 0; i < 600; i++) {
        var x = (i % colDivisions) * (width / (colDivisions - 1));
        var y = (i % rowDivisions) * (colDivisions + 1);
        bubbles.push(new Bubble(x, y, getRandomColor(colors[i % colDivisions])));
    }

}

function draw() {

    if (!trails) {
        background(255);
    }

    for (var i = 0; i < 600; i++) {
        bubbles[i].display();

        if (bubbles[i].mouseOver()) {
            bubbles[i].move();
        }

    }

}

function keyPressed() {
    trails = !trails
}
