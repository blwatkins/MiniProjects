// Colorful Bubbles
// Color functions

function getColorNames() {
    return ["magenta", "cyan", "blue", "red", "green"];
}

function getRandomColor(name) {
    var c;
    var r;
    var g;
    var b;

    switch (name) {
        case "magenta":
            r = random(100, 255); g = random(50, 100); b = random(100, 255);
            break;

        case "cyan":
            r = random(50, 100); g = random(100, 255); b = random(100, 255);
            break;

        case "blue":
            r = random(50, 100); g = random(50, 100); b = random(100, 255);
            break;

        case "red":
            r = random(100, 255); g = random(50, 100); b = random(50, 100);
            break;

        case "green":
            r = random(50, 100); g = random(100, 255); b = random(50, 100);
            break;

        default:
            r = random(50, 100); g = random(50, 100); b = random(50, 100);
            break;
    }

    c = color(r, g, b);
    return c;
}
