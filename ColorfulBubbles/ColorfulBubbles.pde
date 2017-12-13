// An array of multicolored circles that move based on the mouse position

Bubble[] bubbles;

void setup() {
  size(500, 500);
  Color.init(this); // initialize context of static color class
  
  bubbles = new Bubble[500];
  String[] colors = {"magenta", "cyan", "blue", "red", "green"};
  
  for (int i = 0; i < bubbles.length; i++) {
    int x = (i % 5) * width / 4;
    int y = (i % 100) * 5;
    bubbles[i] = new Bubble(x, y, Color.getRandomColor(colors[i % 5]));
  }
  
}

void draw() {
  
  for (Bubble b: bubbles) {
    b.display();
    
    if (b.mouseOver()) {
     b.move(); 
    }
    
  }
  
}

void keyPressed() {
  background(255); 
}