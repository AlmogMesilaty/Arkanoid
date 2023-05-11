package geometry;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * represents rectangle shapes objects.
 * the shape is defined by the upper left point and width and height.
 * can tell all the intersection points with a given line.
 */
public class Rectangle {
 private Point upperLeft;
 private double width;
 private double height;
 private Color color = Color.BLACK;
 /**
  * Create a new rectangle with location and width/height.
  * @param upperLeft
  * @param width
  * @param height
  */
 public Rectangle(Point upperLeft, double width, double height) {
  this.upperLeft = upperLeft;
  this.width = width;
  this.height = height;
 }
 /**
  * checks for intersections points with all the rectangle sides
  * with the specified line,
  * Return a (possibly empty) List of intersection points.
  * @param line line to check intersection with.
  * @return an array of intersection point.
  */
 public java.util.List<Point> intersectionPoints(Line line) {
  List<Point> intersectionPoints = new ArrayList<Point>();
  if (line.intersectionWith(this.getUpSide()) != null) {
   intersectionPoints.add(line.intersectionWith(this.getUpSide()));
  }
  if (line.intersectionWith(this.getRightSide()) != null) {
   intersectionPoints.add(line.intersectionWith(this.getRightSide()));
  }
  if (line.intersectionWith(this.getDownSide()) != null) {
   intersectionPoints.add(line.intersectionWith(this.getDownSide()));
  }
  if (line.intersectionWith(this.getLeftSide()) != null) {
   intersectionPoints.add(line.intersectionWith(this.getLeftSide()));
  }
  return intersectionPoints;
 }

 /**
  * Return the height of the rectangle.
  * @return rectangle width.
  */
 public double getWidth() {
  return this.width;
 }
 /**
  * Return the height of the rectangle.
  * @return rectangle height.
  */
 public double getHeight() {
  return this.height;
 }
 /**
  * Returns the upper-left point of the rectangle.
  * @return the upper-left point of the rectangle.
  */
 public Point getUpperLeft() {
  return this.upperLeft;
 }
 /**
  * changes rectangle color field.
  * @param color new color.
  */
 public void setColor(Color color) {
  this.color = color;
 }
 /**
  * returns rectangle up side as a line.
  * @return line.
  */
 public Line getUpSide() {
  //Upside start point is the rectangle location point.
  Point start = this.getUpperLeft();
  double xEnd = this.getUpperLeft().getX() + this.width;
  double yEnd = this.getUpperLeft().getY();
  Point end = new Point(xEnd, yEnd);
  return new Line(start, end);
 }
 /**
  * returns rectangle right side as a line.
  * @return line.
  */
 public Line getRightSide() {
  double xStart = this.getUpperLeft().getX() + this.width;
  double yStart = this.getUpperLeft().getY();
  Point start = new Point(xStart, yStart);
  double xEnd = this.getUpperLeft().getX() + this.width;
  double yEnd = this.getUpperLeft().getY() + this.height;
  Point end = new Point(xEnd, yEnd);
  return new Line(start, end);
 }
 /**
  * returns rectangle down side as a line.
  * @return line.
  */
 public Line getDownSide() {
  double xStart = this.getUpperLeft().getX() + this.width;
  double yStart = this.getUpperLeft().getY() + this.height;
  Point start = new Point(xStart, yStart);
  double xEnd = this.getUpperLeft().getX();
  double yEnd = this.getUpperLeft().getY() + this.height;
  Point end = new Point(xEnd, yEnd);
  return new Line(start, end);
 }
 /**
  * returns rectangle left side as a line.
  * @return line.
  */
 public Line getLeftSide() {
  //left side start point is the rectangle location point.
  double xStart = this.getUpperLeft().getX();
  double yStart = this.getUpperLeft().getY() + this.height;
  Point start = new Point(xStart, yStart);
  return new Line(start, this.getUpperLeft());
 }
 /**
  * draws the rectangle with filling color and black outline.
  * @param d draw surface object used to draw the rectangle.
  */
 public void drawRectangle(DrawSurface d) {
  int x = (int) Math.round(this.getUpperLeft().getX());
  int y = (int) Math.round(this.getUpperLeft().getY());
  int width = (int) Math.round(this.width);
  int height = (int) Math.round(this.height);
  d.setColor(this.color);
  d.fillRectangle(x, y, width, height);
  d.setColor(Color.BLACK);
  d.drawRectangle(x, y, width, height);
 }
  /**
  *  changes the rectangle upper left point.
  * @param upperLeft new point.
  */
 public void setUpperLeft(Point upperLeft) {
  this.upperLeft = upperLeft;
 }
}