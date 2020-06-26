// Drawing with Noise sketch

var points;
var lines;
var meshSize;
var n;
var deltaAlpha;

function setup() {
    createCanvas(windowWidth-20, windowHeight-20, P2D);
    points = [];
    lines = [];
    meshSize = 50;
    n = 0;
    deltaAlpha = -1;
    frameRate(60);
}

function draw() {
    background(255);
    let x = random(mouseX - meshSize, mouseX + meshSize);
    let y = random(mouseY - meshSize, mouseY + meshSize);
    points.push(new Point(x, y));
    addLines();

    for (let i = 0; i < points.length; i++) {
        points[i].display();
    }

    for (let i = 0; i < lines.length; i++) {
        lines[i].display();
    }

    removeFadedPoints();
    removeFadedLines();
    meshSize = noise(n) * min(width, height) / 8;
    n += 0.01;

    if (n > 50000) {
        n = 0;
    }
}

function removeFadedPoints() {
    for (let i = points.length - 1; i >= 0; i--) {
        let point = points[i];

        if (point.isFaded()) {
            points.splice(i, 1);
        }
    }
}

function removeFadedLines() {
    for (let i = lines.length - 1; i >= 0; i--) {
        let line = lines[i];

        if (line.isFaded()) {
            lines.splice(i, 1);
        }
    }
}

function addLines() {
    let lastIndex = points.length - 1;
    let lastPoint = points[lastIndex];

    for (let i = 0; i < lastIndex; i++) {
        let point = points[i];

        if (point.getAlpha() > 200) {
            if (!hasPointIntersectingCircle(lastPoint, point)) {
                lines.push(new Line(lastPoint, point));
            }
        }
    }
}

function hasPointIntersectingCircle(a, b) {
    let hasIntersectingPoint = false;
    let diameter = a.distance(b);
    let center = createCenterPoint(a, b);

    for (let i = 0; i < points.length; i++) {
        let point = points[i];

        if (!Object.is(point, a) && !Object.is(point, b) && point.getAlpha() > 200) {
            let distance = point.distance(center);

            if (distance < diameter / 2) {
                hasIntersectingPoint = true;
                break;
            }
        }
    }

    return hasIntersectingPoint;
}

function createCenterPoint(a, b) {
    let centerX = (a.position.x + b.position.x) / 2;
    let centerY = (a.position.y + b.position.y) / 2;
    return (new Point(centerX, centerY));
}
