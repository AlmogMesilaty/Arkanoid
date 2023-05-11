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
 * BLock remover is in charge of removing blocks from the game as well as keeping count
 * of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
 private GameLevel gameLevel;
 private Counter remainingBlocks;
 /**
  * Removes the blocks that was hit.
  * Updates the remaining blocks number accordingly.
  * @param gameLevel Current game.
  * @param remainingBlocks Number of blocks in game.
  */
 public BlockRemover(GameLevel gameLevel, Counter remainingBlocks) {
  this.gameLevel = gameLevel;
  this.remainingBlocks = remainingBlocks;
 }
 /**
  * Blocks that are hit should be removed from the game.
  * Remember to remove this listener from the block that is being removed from the game.
  * @param beingHit the block being hit.
  * @param hitter the ball who hits the block.
  */
 public void hitEvent(Block beingHit, Ball hitter) {
  beingHit.removeFromGame(this.gameLevel);
  beingHit.removeHitListener(this);
  try {
   remainingBlocks.decrease(1);
  } catch (Exception e) {
   System.out.printf("According to counter there are no more blocks.");
  }
 }
}
