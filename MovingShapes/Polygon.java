// Moving Shapes
// Polygon class 

import processing.core.PApplet;
import processing.core.PVector;

public class Polygon {

  public enum ShapeType {
    POLYGON, 
      STAR
  };

  public enum DrawingType {
    SOLID, 
      WIREFRAME, 
      TRANSPARENT
  };

  private PApplet p;
  private PVector[] points;
  private PVector position;
  private PVector velocity;
  private PVector acceleration;
  private int sides; // POLYGON -> at least 3, STAR -> at least 4
  private int fillColor;
  private int strokeColor;

  public Polygon(PApplet p) {
    this.p = p; 
    sides = 3;
    position = new PVector(0, 0);
    velocity = new PVector(0, 0);
    acceleration = new PVector(0, 0);
    fillColor = p.color(255);
    strokeColor = p.color(0);
  }
  
  public Polygon(PApplet p, int sides, PVector position) {
    this.p = p;
    this.sides = sides;
    this.position = position.copy();
    velocity = new PVector(0, 0);
    acceleration = new PVector(0, 0);
    fillColor = p.color(255);
    strokeColor = p.color(0);
  }
  
}