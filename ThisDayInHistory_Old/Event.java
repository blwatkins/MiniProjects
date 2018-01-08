import processing.core.PApplet;

public class Event {
  private String year;
  private int yearVal;
  private String text;
  private String type;
  private int bgCol;
  private int textCol;
  private PApplet p;

  public Event(PApplet p) {
    this.p = p;
    year = "";
    yearVal = 0;
    text = "";
    type = "event";
    bgCol = p.color(0);
    textCol = p.color(255);
  }

  public Event(PApplet p, String text) {
    this.p = p;
    year = "";
    yearVal = 0;
    this.text = text;
    type = "event";
    bgCol = p.color(0);
    textCol = p.color(255);
  }

  public int getYearVal() {
    return yearVal;
  }

  public void setType(String type) {
    this.type = type;
    calcBgColor();
  }

  public void setYear(String year, int yearVal, int maxYear, int minYear) {
    this.year = year;
    this.yearVal = yearVal;
    int hue = (int)p.map(yearVal, minYear, maxYear, 0, 255);
    textCol = p.color(hue, 255, 255);
  }

  public void display() {
    p.background(bgCol);
    p.textAlign(p.CENTER, p.CENTER);
    p.textSize(50);
    p.fill(textCol);
    p.text(year, p.width / 2, p.height / 10);
    p.textSize(20);
    p.textAlign(p.CENTER, p.TOP);
    p.text(text, p.width / 10, 2 * p.height / 10, 4 * p.width / 5, 2 * p.width / 5);
    p.noFill();
  }

  private void calcBgColor() {
    switch (type) {
    case "event":
      bgCol = p.color(200);
      break;
    case "birth":
      bgCol = p.color(255);
      break;
    case "death":
      bgCol = p.color(0);
      break;
    default:
      bgCol = p.color(200);
      break;
    }
  }

  public String toString() {
    String out = "";
    out += "Event: " + "\n";
    out += "    " + "year = " + year + "\n";
    out += "    " + "yearVal = " + yearVal + "\n";
    out += "    " + "text = " + text + "\n";
    out += "    " + "type = " + type + "\n";
    return out;
  }
}