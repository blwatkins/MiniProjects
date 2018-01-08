import processing.core.PApplet;

public class Event {
  public enum Type {
    EVENT, 
      BIRTH, 
      DEATH
  };

  private String year;
  private int yearVal;
  private String text;
  private int backgroundColor;
  private int textColor;
  private Type type;
  private PApplet p;

  public Event(PApplet p) {
    this.p = p;
    year = "";
    yearVal = 0;
    text = "";
    backgroundColor = p.color(0);
    textColor = p.color(0);
    type = Type.EVENT;
  }
}