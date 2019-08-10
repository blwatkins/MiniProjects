// Colorful Bubbles
// An array of multicolored circles that move based on the mouse position
// Press the 'a' key to activate and deactivate trails

Bubble[] bubbles;
boolean trails;

void settings() {
  size(displayWidth, displayHeight - 45);
}

void setup() {
  bubbles = new Bubble[400];
  trails = true;
  String[] colors = {"magenta", "cyan", "blue", "red", "green"};
  int colDivisions = colors.length;
  int rowDivisions = height / colDivisions;
  
  for (int i = 0; i < bubbles.length; i++) {
    int x = (i % colDivisions) * (width / (colDivisions - 1));
    int y = (i % rowDivisions) * (colDivisions + 1);
    bubbles[i] = new Bubble(x, y, getRandomColor(colors[i % colDivisions]));
  }
}

void draw() {
  if (!trails) {
    background(255);
  }
  
  for (Bubble b : bubbles) {
    b.display();
    if (b.mouseOver()) {
      b.move();
    }
  }
}

void keyPressed() {
  if (key == 'a') {
    trails = !trails;
  }
}
