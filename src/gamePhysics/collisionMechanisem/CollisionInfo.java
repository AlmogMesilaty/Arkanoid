package gamePhysics.collisionMechanisem;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
public class CollisionInfo {
 private geometry.Point collisionPoint;
 private Collidable collisionObject;
 /**
  * getter for colllision point.
  * @return the collision point
  */
 public geometry.Point collisionPoint() {
  return this.collisionPoint;
 }
 /**
  * the collidable object involved in the collision.
  * @return the current collision object.
  */
 public Collidable collisionObject() {
  return this.collisionObject;
 }
 /**
  *
  * @param collisionPoint
  * @param collisionObject
  */
 public CollisionInfo(geometry.Point collisionPoint, Collidable collisionObject) {
  this.collisionPoint = collisionPoint;
  this.collisionObject = collisionObject;
 }
 /**
  * Setter for collision object.
  * @param collisionObject the new collision object.
  */
 public void setCollisionObject(Collidable collisionObject) {
  this.collisionObject = collisionObject;
 }
 /**
  * Setter for collision point.
  * @param collisionPoint the new collision point.
  */
 public void setCollisionPoint(geometry.Point collisionPoint) {
  this.collisionPoint = collisionPoint;
 }
}
