// This Day In History
// HSB Color Functions
// Functions for working with HSB colors
// 0-360 scale

enum ColorType {
  RAINBOW, 
    SOFT, 
    WARM, 
    TOPC, 
    BOTTOMC;
};

ColorType getRandomColorType() {
  int rand = (int)random(1000);
  ColorType choice = ColorType.RAINBOW;

  switch(rand % 5) {

  case 0:
    choice = ColorType.RAINBOW;
    break;

  case 1:
    choice = ColorType.SOFT;
    break;

  case 2:
    choice = ColorType.WARM;
    break;

  case 3:
    choice = ColorType.TOPC;
    break;

  case 4:
    choice = ColorType.BOTTOMC;
    break;

  default:
    choice = ColorType.RAINBOW;
    break;
  }

  return choice;
}

color mapColor(ColorType type, float num, float min, float max) {
  int hue = 0;

  switch (type) {

  case RAINBOW:
    hue = (int)map(num, min, max, 0, 360);
    break;

  case SOFT:
    hue = (int)map(num, min, max, 90, 285);
    break;

  case WARM:
    hue = (int)map(num, min, max, 0, 70);
    break;

  case TOPC:
    hue = (int)map(num, min, max, 180, 360);
    break;

  case BOTTOMC:
    hue = (int)map(num, min, max, 0, 180);
    break;

  default:
    break;
  }

  return color(hue, 360, 360);
}

color mapColor(float num, float min, float max) {
  int hue = (int)map(num, min, max, 0, 360);
  return color(hue, 360, 360);
}