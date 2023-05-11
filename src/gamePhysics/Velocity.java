package gamePhysics;

import geometry.Point;

/**
 * @author almog mesilty
 * Velocity specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {
 private double dx = 0;
 private double dy = 0;
 /**
  * creates new velocity instance from given values.
  * @param dx change in x value.
  * @param dy change in y value.
  */
 public Velocity(double dx, double dy) {
  this.dx = dx;
  this.dy = dy;
 }
 /**
  * construct velocity instance from given angle and speed.
  * translate angle and speed to change in x and y values.
  * @param angle direction of the movement.
  * @param speed distance covered in the direction.
  * @return new velocity instance.
  */
 public static Velocity fromAngleAndSpeed(double angle, double speed) {
  double dx = Math.cos(angle) * speed;
  double dy = Math.sin(angle) * speed;
  return new Velocity(dx, dy);
 }

 /**
  * Take a point with position (x,y) and return a new point,
  * with position (x+dx, y+dy).
  * @param p point to update.
  * @return new point with updated position.
  */
 public Point applyToPoint(Point p) {
  return new Point(p.getX() + dx, p.getY() + dy);
 }
 /**
  * getter for Dx.
  * @return dx value.
  */
 public double getDx() {
  return this.dx;
 }
 /**
  * getter for Dy.
  * @return dy value.
  */
 public double getDy() {
  return this.dy;
 }
}