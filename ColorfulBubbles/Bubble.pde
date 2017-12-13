class Bubble {

  PVector pos;
  float r;
  color c;

  Bubble() {
    pos = new PVector();
    r = 10;
    c = color(0);
  }

  Bubble(float x, float y, color c) {
    r = random(10, 50);
    pos = new PVector(x, y);
    pos.add(new PVector(random(-50, 50), random(-50, 50)));
    this.c = c;
  }

  void display() {
    stroke(c);
    fill(c, 100);
    ellipse(pos.x, pos.y, r * 2, r * 2);
  }

  void move() {
    pos.add(new PVector(random(-5, 5), random(-5, 5)));
  }

  boolean mouseOver() {

    if (abs(pos.x - mouseX) < 50) {
      return true;
    } else {
      return false;
    }
    
  }
  
}