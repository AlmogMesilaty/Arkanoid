package gamePhysics.collisionMechanisem;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
import gamePhysics.Velocity;
/**
 * Interface determines all collidable objects functionality.
 */
public interface Collidable {
 /**
  * Return the "collision shape" of the object.
  * @return the collision shape.
  */
 geometry.Rectangle getCollisionRectangle();
 /**
  * Notify the object that we collided with it, at the collisionPoint with
  *  a given velocity.
  *  The return is the new velocity expected after the hit (based on)
  *  the force the object inflicted on us.
  * @param collisionPoint the point of the collision.
  * @param currentVelocity the velocity of the ball during the collision.
  * @param hitter the hitting ball.
  * @return new velocity expected after the hit.
  */
 Velocity hit(geometry.Point collisionPoint, Velocity currentVelocity, gamePhysics.shapes.Ball hitter);
}
