public color getRandomColor(String name) {
  color c;
  int r;
  int g;
  int b;

  switch (name) {
  case "magenta":
    r = (int)random(100, 255);
    g = (int)random(50, 100);
    b = (int)random(100, 255);
    break;
  case "cyan":
    r = (int)random(50, 100);
    g = (int)random(100, 255);
    b = (int)random(100, 255);
    break;
  case "blue":
    r = (int)random(50, 100);
    g = (int)random(50, 100);
    b = (int)random(100, 255);
    break;
  case "red":
    r = (int)random(100, 255);
    g = (int)random(50, 100);
    b = (int)random(50, 100);
    break;
  case "green":
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