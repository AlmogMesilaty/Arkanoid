package geometry;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
import biuoop.DrawSurface;
/**
 * A point has an x and a y value, and can measure the distance to other points,
 * and if it is equal to another point.
 */
public class Point {
 private double x = 0;
 private double y = 0;
 /**
  * constructor.
  * @param x x axis value
  * @param y y axis value
  */
 public Point(double x, double y) {
  this.x = x;
  this.y = y;
 }

 /**
  * distance, measure distance between two points.
  * @param other the point to which the distance is measured
  * @return distance in double
  */
 public double distance(Point other) {
  double x1 = this.getX();
  double x2 = other.getX();
  double y1 = this.getY();
  double y2 = other.getY();
  return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)); //distance formula
 }

 /**
  * checks if two points are equals.
  * @param other the point for comparison.
  * @return boolean according to the result.
  */
 public boolean equals(Point other) {
  if (other == null) {
   return false;
  }
  return this.getX() == other.getX() && this.getY() == other.getY();
 }
 /**
  * returns instance x value.
  * @return x value in double.
  */
 public double getX() {
  return this.x;
 }
 /**
  * returns instance y value.
  * @return yvalue in double.
  */
 public double getY() {
  return this.y;
 }
 /**
  * x value setter.
  * @param x new x value.
  */
 public void setX(double x) {
  this.x = x;
 }
 /**
  * y value setter.
  * @param y new y value.
  */
 public void setY(double y) {
  this.y = y;
 }
 /**
  * draws point on the screen according to given radius.
  * @param radius determine the point size on the screen.
  * @param d draw surface object.
  */
 public void drawPoint(int radius, DrawSurface d) {
  d.fillCircle((int) Math.round(this.getX()),
   (int) Math.round(this.getY()), radius);
 }
}
