package game.observers;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
import game.managment.Counter;
import gamePhysics.shapes.Block;
import gamePhysics.shapes.Ball;
/**
 * Updates score when blocks are being hit and removed.
 */
public class ScoreTrackingListener implements HitListener {
 private Counter currentScore;
 /**
  * Builder.
  * @param scoreCounter Ongoing game score.
  */
 public ScoreTrackingListener(Counter scoreCounter) {
  this.currentScore = scoreCounter;
 }
 /**
  * Increase current score by 5.
  * @param beingHit the block being hit.
  * @param hitter the ball who hits the block.
  */
 public void hitEvent(Block beingHit, Ball hitter) {
  currentScore.increase(5);
 }
}
