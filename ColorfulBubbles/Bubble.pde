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
    r = random(10, min(width, height) / 10);
    pos = new PVector(x, y);
    pos.add(new PVector(random(-width / 10, width / 10), random(-height / 10, -height / 10)));
    this.c = c;
  }

  void display() {
    stroke(c);
    fill(c, 100);
    ellipse(pos.x, pos.y, r * 2, r * 2);
  }

  void move() {
    pos.add(new PVector(random(-width / 100, width / 100), random(-height/100, height / 100)));
  }

  boolean mouseOver() {

    if (abs(pos.x - mouseX) < width / 10) {
      return true;
    } else {
      return false;
    }
    
  }
  
}