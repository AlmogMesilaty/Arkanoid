package gamePhysics.shapes;
/**
 * @author almog mesilaty
 * @ID 314973686
 */
import biuoop.DrawSurface;
import game.animations.GameLevel;
import gamePhysics.Velocity;
import gamePhysics.collisionMechanisem.Collidable;
import game.observers.HitListener;
import game.observers.HitNotifier;
import geometry.Rectangle;
import geometry.Point;

import java.util.ArrayList;
import java.util.List;
/**
 * Blocks are rectangles that are part of the game.
 * Blocks can be hit, and drawn to the screen.
 */
public class Block implements Collidable, Sprite, HitNotifier {
 private List<HitListener> hitListeners = new ArrayList<HitListener>();
 private Rectangle collisionShape;
 /**
  * getter for the collision shape filed.
  * @return returns collision shape.
  */
 public Rectangle getCollisionRectangle() {
  return this.collisionShape;
 }
 /**
  * Notify the object that we collided with it at collisionPoint with a given velocity.
  * The returns the new velocity expected after the hit.
  * @param collisionPoint the point of the collision.
  * @param currentVelocity the velocity of the ball during the collision.
  * @param hitter the hitting ball.
  * @return new velocity expected after the hit.
  */
 public Velocity hit(Point collisionPoint, Velocity currentVelocity, Ball hitter) {
  //Checks the direction of collision by comparing x and y values of collisionPoint to the collisionRectangle.
  double xCollision = Math.round(collisionPoint.getX());
  double yCollision = Math.round(collisionPoint.getY());
  boolean horizontalCollision = xCollision <= Math.ceil(this.getCollisionRectangle().getUpperLeft().getX())
                                || xCollision >= Math.floor(this.getCollisionRectangle().getUpperLeft().getX())
                                + this.getCollisionRectangle().getWidth();
  boolean verticalCollision = yCollision <= Math.ceil(this.getCollisionRectangle().getUpperLeft().getY())
                              || yCollision >= Math.floor(this.getCollisionRectangle().getUpperLeft().getY())
                              + this.getCollisionRectangle().getHeight();
  //Updates collision direction in collisionInfo.
  double newDx = currentVelocity.getDx();
  double newDy = currentVelocity.getDy();
  if (horizontalCollision) {
   newDx *= -1;
  }
  if (verticalCollision) {
   newDy *= -1;
  }
  this.notifyHit(hitter);
  return new Velocity(newDx, newDy);
 }
 /**
  * Constructor.
  * @param collisionShape new block shape.
  */
 public Block(Rectangle collisionShape) {
  this.collisionShape = collisionShape;
 }
 /**
  * Draws block, using drawRectangle method.
  * @param d draw surface sends from the calling function, used to draw the block.
  */
 public void drawOn(DrawSurface d) {
  this.getCollisionRectangle().drawRectangle(d);
 }
 /**
  * notify the block time have passed,
  *  does nothing.
  */
 public void timePassed() { }
 /**
  * Adds block into a game.
  * @param g the game to add to.
  */
 public void addToGame(GameLevel g) {
  g.addSprite(this);
  g.addCollidable(this);
 }
 /**
  * Removes the block from the game.
  * @param g game to remove block from.
  */
 public void removeFromGame(GameLevel g) {
  g.removeSprite(this);
  g.removeColliadable(this);
 }
 /**
  * Adds new listener to the list.
  * @param hl new listener to add.
  */
 public void addHitListener(HitListener hl) {
  this.hitListeners.add(hl);
 }
 /**
  * Removes Hit listener from list.
  * @param hl listener to remove.
  */
 public void removeHitListener(HitListener hl) {
  this.hitListeners.remove(hl);
 }
 /**
  * Notify all listener in the list that a hit occurred.
  * @param hitter ball that committed the hit.
  */
 private void notifyHit(Ball hitter) {
  // Make a copy of the hitListeners before iterating over them.
  List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
  // Notify all listeners about a hit event:
  for (HitListener hl : listeners) {
   hl.hitEvent(this, hitter);
  }
 }
}
