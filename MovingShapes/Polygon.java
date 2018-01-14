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
  private ShapeType type;
  private DrawingType drawingType;
  private PVector[] points;
  private PVector position;
  private PVector velocity;
  private PVector acceleration;
  private int pointCount;
  private float radius;
  private int fillColor;
  private int strokeColor;

  public Polygon(PApplet p) {
    this.p = p; 
    type = ShapeType.POLYGON;
    drawingType = DrawingType.WIREFRAME;
    pointCount = 3;
    position = new PVector(0, 0);
    velocity = new PVector(0, 0);
    acceleration = new PVector(0, 0);
    radius = 10;
    fillColor = p.color(255);
    strokeColor = p.color(0);
    createPoints();
  }

  public Polygon(PApplet p, int pointCount, PVector position, float radius, ShapeType type, DrawingType drawingType) {
    this.p = p;
    this.type = type;
    this.drawingType = drawingType;
    this.pointCount = pointCount;
    checkPointCount();
    this.position = position.copy();
    velocity = new PVector(0, 0);
    acceleration = new PVector(0, 0);
    this.radius = radius;
    checkRadius();
    fillColor = p.color(255);
    strokeColor = p.color(0);
    createPoints();
  }

  private void checkPointCount() {

    if (pointCount < 3) {
      pointCount = 3;
    }

    if (type == ShapeType.STAR) {
      pointCount *= 2;
    }
  }

  private void checkRadius() {
    if (radius <= 0) {
      radius = 10;
    }
  }

  private void createPoints() {
    points = new PVector[pointCount];
    float deltaTheta = TWO_PI / pointCount;
    switch(type) {
    case POLYGON:
      createPolygonPoints(deltaTheta);
      break;
    case STAR:
      break;
    case default:
      createPolygonPoints();
      break;
    }
  }

  private void createPolygonPoints(float deltaTheta) {
    float pointTheta = 0;
    for (int i = 0; i < pointCount; i++) {
      float x = position.x + cos(pointTheta) * radius;
      float y = position.y + sin(pointTheta) * radius;
      points[i] = new PVector(x, y);
      pointTheta += deltaTheta;
    }
  }
}