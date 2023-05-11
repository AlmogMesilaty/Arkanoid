package game.observers;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
import gamePhysics.shapes.Block;
import gamePhysics.shapes.Ball;
/**
 * HitListener, objects that want to be notified of hits events.
 */
public interface HitListener {
 /**
  * This method is called whenever the beingHit object is hit.
  * The hitter parameter is the Ball that's doing the hitting.
  * @param beingHit the block being hit.
  * @param hitter the ball who hits the block.
  */
 void hitEvent(Block beingHit, Ball hitter);
}
