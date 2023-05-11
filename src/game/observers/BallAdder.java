package game.observers;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
import game.animations.GameLevel;
import game.managment.Counter;
import java.awt.Color;
/**
 * In charge of adding new balls in the game and keeping track of ball counting.
 */
public class BallAdder implements HitListener {
 private GameLevel gameLevel;
 private Counter remainingBalls;
 /**
  * Removes the balls that hit death zones.
  * Updates the remaining balls number accordingly.
  * @param gameLevel Current game.
  * @param remainingBalls Number of blocks in game.
  */
 public BallAdder(GameLevel gameLevel, Counter remainingBalls) {
  this.gameLevel = gameLevel;
  this.remainingBalls = remainingBalls;
 }
 /**
  * Balls that are hit death zones should be removed from the game.
  * @param beingHit the block being hit.
  * @param hitter the ball who hits the block.
  */
 public void hitEvent(gamePhysics.shapes.Block beingHit, gamePhysics.shapes.Ball hitter) {
  double x = beingHit.getCollisionRectangle().getUpperLeft().getX();
  double y = beingHit.getCollisionRectangle().getUpperLeft().getY();
  //New ball.
  gamePhysics.shapes.Ball ball = new gamePhysics.shapes.Ball(x, y, 4, Color.WHITE);
  ball.setVelocity(2, 3);
  ball.addToGame(this.gameLevel);
  ball.setGameEnvironment(this.gameLevel.getEnvironment());
  try {
   remainingBalls.increase(1);
  } catch (Exception e) {
   System.out.printf("According to counter there are no more blocks.");
  }
 }
}
