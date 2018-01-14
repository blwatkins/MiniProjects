// Moving Shapes
// RGB Color Functions
// Functions for working with RGB colors
// 0-255 scale

enum ColorType {
  BLACK,
  WHITE,
  GREY,
  RED,
  GREEN,
  BLUE,
  CYAN,
  YELLOW,
  MAGENTA,
  RANDOM
};

color getRandomColor(ColorType type) {
  color c;
  int r;
  int g;
  int b;

  switch (type) {
  case MAGENTA:
    r = (int)random(100, 255);
    g = (int)random(50, 100);
    b = (int)random(100, 255);
    break;
  case CYAN:
    r = (int)random(50, 100);
    g = (int)random(100, 255);
    b = (int)random(100, 255);
    break;
  case BLUE:
    r = (int)random(50, 100);
    g = (int)random(50, 100);
    b = (int)random(100, 255);
    break;
  case RED:
    r = (int)random(100, 255);
    g = (int)random(50, 100);
    b = (int)random(50, 100);
    break;
  case GREEN:
    r = (int)random(50, 100);
    g = (int)random(100, 255);
    b = (int)random(50, 100);
    break;
  default:
    r = (int)random(50, 100);
    g = (int)random(50, 100);
    b = (int)random(50, 100);
    break;
  }

  c = color(r, g, b);
  return c;
}