import processing.core.PApplet;
import processing.core.PImage;
import processing.data.XML;

public class Event {
  public enum Type {
    EVENT, 
      BIRTH, 
      DEATH
  };

  private String yearString;
  private int year;
  private String text;
  private String url;
  private int backgroundColor;
  private int textColor;
  private Type type;
  private PApplet p;
  private PImage image;

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
    image = null;
    try {
      getImage();
    }
    catch (Exception e) {
      p.println(e);
      image = null;
    }
  }

  public void getImage() {
    XML wikiPage = p.loadXML(url);
    XML body = wikiPage.getChild("body");
    XML[] divs = body.getChildren("div");

    XML contentDiv = null;
    for (int i = 0; i < divs.length; i++) {
      String id = divs[i].getString("id");
      if (id != null && id.equals("content")) {
        contentDiv = divs[i];
        break;
      }
    }

    XML[] contentDivs = contentDiv.getChildren("div");
    XML bodyContentDiv = null;
    for (int i = 0; i < contentDivs.length; i++) {
      String id = contentDivs[i].getString("id");
      if (id != null && id.equals("bodyContent")) {
        bodyContentDiv = contentDivs[i];
        break;
      }
    }

    XML[] bodyContentDivs = bodyContentDiv.getChildren("div");
    XML contentTextDiv = null;

    for (int i = 0; i < bodyContentDivs.length; i++) {
      String id = bodyContentDivs[i].getString("id");

      if (id != null && id.equals("mw-content-text")) {
        contentTextDiv = bodyContentDivs[i];
        break;
      }
    }

    XML parserOutputDiv = contentTextDiv.getChild("div");

    XML[] parserOutputTables = parserOutputDiv.getChildren("table");
    XML infoBoxTable = null;

    for (int i = 0; i < parserOutputTables.length; i++) {
      String tableClass = parserOutputTables[i].getString("class");

      if (tableClass != null && tableClass.equals("infobox vcard")) {
        infoBoxTable = parserOutputTables[i];
        break;
      }
    }

    XML[] tableRows = infoBoxTable.getChildren("tr");

    String imageURL = null;
    for (int i = 0; i < tableRows.length; i++) {
      XML content = tableRows[i].getChild("td");

      if (content != null) {
        String contentClass = content.getString("class");
        if (contentClass != null && contentClass.equals("photo")) {
          imageURL = tableRows[i].getChild("td").getChild("a").getChild("img").getString("src");
        }
      }
    }

    imageURL = "https:" + imageURL;

    image = p.loadImage(imageURL);
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
      p.image(image, 0, 0, p.height, p.width);
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