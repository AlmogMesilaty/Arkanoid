package gamePhysics.shapes;
/**
 * @author almog mesilaty
 * @ID 314973686
 */
import biuoop.DrawSurface;
import gamePhysics.Velocity;
import gamePhysics.collisionMechanisem.GameEnvironment;
import gamePhysics.collisionMechanisem.CollisionInfo;
import geometry.Point;
import geometry.Line;
import game.animations.GameLevel;

import java.awt.*;

/**
 * size (radius), color, and location (a Point).
 * Balls also know how to draw themselves on a DrawSurface.
 */
public class Ball implements Sprite {
 private geometry.Point center;
 private int radius = 0;
 private java.awt.Color color;
 private Velocity velocity;
 private GameEnvironment gameEnvironment;
 /**
  * constructor for ball class.
  *
  * @param x     x value of ball center.
  * @param y     y value of ball center.
  * @param r     radius length.
  * @param color ball color.
  */
 public Ball(double x, double y, int r, java.awt.Color color) {
  this.center = new Point(x, y);
  this.radius = Math.abs(r);
  this.color = color;
  this.velocity = new Velocity(0, 0);
 }
 /**
  * returns ball center x value.
  *
  * @return ball center x value.
  */
 public int getX() {
  return (int) Math.round(this.center.getX());
 }
 /**
  * * returns ball center y value.
  *
  * @return ball center y value.
  */
 public int getY() {
  return (int) Math.round(this.center.getY());
 }
 /**
  * returns ball size.
  * calculates ball size using pi and radius.
  *
  * @return ball size in int.
  */
 public int getSize() {
  return (int) Math.round(Math.PI * this.radius * this.radius);
 }
 /**
  * returns ball's color.
  *
  * @return ball color.
  */
 public java.awt.Color getColor() {
  return this.color;
 }
 /**
  * draws the ball on a given surface.
  * @param surface draw surface instance.
  */
 public void drawOn(DrawSurface surface) {
  surface.setColor(this.getColor());
  surface.fillCircle(this.getX(), this.getY(), this.radius);
  surface.setColor(Color.BLACK);
  surface.drawCircle(this.getX(), this.getY(), this.radius);
 }
 /**
  * change ball velocity.
  * @param v new velocity.
  */
 public void setVelocity(Velocity v) {
  this.velocity = v;
 }
 /**
  * change ball velocity by entering specific change in x and y.
  *
  * @param dx change in x value.
  * @param dy change in y value.
  */
 public void setVelocity(double dx, double dy) {
  Velocity newVelocity = new Velocity(dx, dy);
  setVelocity(newVelocity);
 }
 /**
  * returns current ball velocity.
  * @return ball velocity.
  */
 public Velocity getVelocity() {
  return this.velocity;
 }
 /**
  * Set gameEnvironment.
  * @param gameEnvironment
  */
 public void setGameEnvironment(GameEnvironment gameEnvironment) {
  this.gameEnvironment = gameEnvironment;
 }
  /**
   * Adds ball into a game.
   * @param g the game to add the ball to.
   */
 public void addToGame(GameLevel g) {
  g.addSprite(this);
 }
 /**
  * Removes ball from game.
  * @param g Game to remove the ball from.
  */
 public void removeFromGame(GameLevel g) {
  g.removeSprite(this);
 }
 /**
  * updates the ball position according to its velocity.
  * checks if the ball is over its bounds, if so changes its velocity.
  */
 public void moveOneStep() {
  //Compute trajectory line.
  double xStart = this.center.getX();
  double yStart = this.center.getY();
  double xEnd = xStart + this.velocity.getDx();
  double yEnd = yStart + this.velocity.getDy();
  Line trajectory = new Line(xStart, yStart, xEnd, yEnd);
  //Check if moving on this trajectory will hit anything.
  CollisionInfo collisionInfo = this.gameEnvironment.getClosestCollision(trajectory);
  if (collisionInfo != null) {
   //Moves ball close to hit point.
   if (this.getVelocity().getDx() < 0) {
    this.center.setX(collisionInfo.collisionPoint().getX() + 0.1);
   } else if (this.getVelocity().getDx() > 0) {
    this.center.setX(collisionInfo.collisionPoint().getX() - 0.1);
   }
   if (this.getVelocity().getDy() < 0) {
    this.center.setY(collisionInfo.collisionPoint().getY() + 0.1);
   } else if (this.getVelocity().getDy() > 0) {
    this.center.setY(collisionInfo.collisionPoint().getY() - 0.1);
   }
   //Notify the hit object that collision occurred.
   //Change velocity according to collision direction.
   this.setVelocity(collisionInfo.collisionObject().hit(collisionInfo.collisionPoint(), this.velocity, this));
  }
  this.center = this.getVelocity().applyToPoint(this.center);
 }
 /**
  * notified that time has passed change ball position using moveOneStep.
  */
 public void timePassed() {
  this.moveOneStep();
 }
}