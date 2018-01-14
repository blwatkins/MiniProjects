// This Day in History
// Event Class

import processing.core.PApplet;
import processing.core.PImage;
import processing.data.XML;

public class Event {
  public enum Type {
    EVENT, 
      BIRTH, 
      DEATH;

      public static String getTypeText(Type type) {
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
  };

  private String yearString;
  private int year;
  private String text;
  public String url;
  private int backgroundColor;
  private int textColor;
  private Type type;
  private PApplet p;
  public PImage image;

  public Event(PApplet p) {
    this.p = p;
    yearString = "";
    year = 0;
    text = "";
    url = "";
    backgroundColor = p.color(0);
    textColor = p.color(0);
    type = Type.EVENT;
    image = null;
  }

  public Event(PApplet p, int year, String text, String url, Type type) {
    this.p = p;
    setYear(year);
    this.text = text;
    this.url = url;
    setType(type);
    WikipediaScraper ws = new WikipediaScraper(p, url);
    image = ws.getPageImage();
  }

  public void setType(Type type) {
    this.type = type;
    setBackgroundColor(type);
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
    if (year < 0) {
      this.yearString = (year * -1) + " BC";
    } else {
      this.yearString =  new Integer(year).toString();
    }
  }

  private void setBackgroundColor(Type type) {
    switch (type) {
    case EVENT:
      backgroundColor = p.color(288);
      break;
    case BIRTH:
      backgroundColor = p.color(360);
      break;
    case DEATH:
      backgroundColor = p.color(0);
      break;
    default:
      backgroundColor = p.color(288);
      break;
    }
  }

  public int getTextColor() {
    return textColor;
  }

  public void setTextColor(int textColor) {
    this.textColor = textColor;
  }

  public void display() {
    p.background(backgroundColor);
    if (image != null) {
      p.tint(255, 180);
      p.image(image, p.width / 10, p.height / 10, 8 * p.height / 10, 8 * p.width / 10);
    }
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
    out += "    " + "url = " + url + "\n";
    out += "    " + "type = " + Type.getTypeText(type) + "\n";
    return out;
  }
}