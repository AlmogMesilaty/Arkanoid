package game.observers;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
import game.animations.GameLevel;
import game.managment.Counter;
import gamePhysics.shapes.Block;
import gamePhysics.shapes.Ball;

/**
 * Class in charge of removing balls that hit the death zones,
 * and keep track on remaining balls in the game.
 */
public class BallRemover implements HitListener {
 private GameLevel gameLevel;
 private Counter remainingBalls;
 /**
  * Removes the balls that hit death zones.
  * Updates the remaining balls number accordingly.
  * @param gameLevel Current game.
  * @param remainingBalls Number of blocks in game.
  */
 public BallRemover(GameLevel gameLevel, Counter remainingBalls) {
  this.gameLevel = gameLevel;
  this.remainingBalls = remainingBalls;
 }
 /**
  * Balls that are hit death zones should be removed from the game.
  * @param beingHit the block being hit.
  * @param hitter the ball who hits the block.
  */
 public void hitEvent(Block beingHit, Ball hitter) {
  hitter.removeFromGame(this.gameLevel);
  try {
   remainingBalls.decrease(1);
  } catch (Exception e) {
   System.out.printf("According to counter there are no more blocks.");
  }
 }
}
