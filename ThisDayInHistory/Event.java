import processing.core.PApplet;

public class Event {
  public enum Type {
    EVENT, 
      BIRTH, 
      DEATH
  };

  private String yearString;
  private int year;
  private String text;
  private int backgroundColor;
  private int textColor;
  private Type type;
  private PApplet p;

  public Event(PApplet p) {
    this.p = p;
    yearString = "";
    year = 0;
    text = "";
    backgroundColor = p.color(0);
    textColor = p.color(0);
    type = Type.EVENT;
  }

  public Event(PApplet p, int year, String text, Type type) {
    this.p = p;
    setYear(year);
    this.text = text;
    setType(type);
  }

  public void setYear(int year) {
    this.year = year;
    if (year < 0) {
      this.yearString = (year * -1) + " BC";
    } else {
      this.yearString =  new Integer(year).toString();
    }
  }

  public void setType(Type type) {
    this.type = type;
    setBackgroundColor(type);
  }

  private void setBackgroundColor(Type type) {
    switch (type) {
    case EVENT:
      backgroundColor = p.color(200);
      textColor = p.color(0);
      break;
    case BIRTH:
      backgroundColor = p.color(255);
      textColor = p.color(0);
      break;
    case DEATH:
      backgroundColor = p.color(0);
      textColor = p.color(255);
      break;
    default:
      backgroundColor = p.color(200);
      textColor = p.color(0);
      break;
    }
  }

  public int getTextColor() {
    return textColor;
  }

  public void display() {
    p.background(backgroundColor);
    p.textAlign(p.CENTER, p.CENTER);
    p.textSize(50);
    p.fill(textColor);
    p.text(yearString, p.width / 2, p.height / 10);
    p.textSize(20);
    p.textAlign(p.CENTER, p.TOP);
    p.text(text, p.width / 10, 2 * p.height / 10, 4 * p.width / 5, 2 * p.width / 5);
  }

  public String toString() {
    String out = "";
    out += "Event: " + "\n";
    out += "    " + "yearString = " + yearString + "\n";
    out += "    " + "year = " + year + "\n";
    out += "    " + "text = " + text + "\n";
    out += "    " + "type = " + getTypeText() + "\n";
    return out;
  }

  public String getTypeText() {
    String text = "";
    switch(type) {
    case EVENT:
      text = "event";
      break;
    case BIRTH:
      text = "birth";
      break;
    case DEATH:
      text = "death";
      break;
    default:
      text = "invalid";
      break;
    }

    return text;
  }
}